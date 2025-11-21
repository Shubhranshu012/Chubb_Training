package com.flightfluxapp.service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

import com.flightfluxapp.dto.BookingRequestDto;
import com.flightfluxapp.entity.Booking;
import com.flightfluxapp.entity.Passenger;
import com.flightfluxapp.exception.BadRequentException;
import com.flightfluxapp.exception.ExceptionDuetoTiming;
import com.flightfluxapp.exception.NotFoundException;
import com.flightfluxapp.repository.BookingRepository;
import com.flightfluxapp.repository.FlightInventoryRepository;
import com.flightfluxapp.repository.PassengerRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final FlightInventoryRepository inventoryRepo;
    private final BookingRepository bookingRepo;
    private final PassengerRepository passengerRepo;

    public Mono<Booking> bookTicket(Long flightId, BookingRequestDto dto) {

        return inventoryRepo.findById(flightId)
            .switchIfEmpty(Mono.error(new NotFoundException("Flight not found")))
            .flatMap(flight -> {
                if (flight.getAvailableSeats() < dto.getNumberOfSeats()) {
                    return Mono.error(new BadRequentException("Not enough seats available"));
                }
              
                if (dto.getNumberOfSeats()!= dto.getPassengers().size()) {
                    return Mono.error(new BadRequentException("Seat numbers must match passenger count"));
                }

                Set<String> uniqueSeats = new HashSet<>(dto.getSeatNumbers());
                if (uniqueSeats.size() != dto.getSeatNumbers().size()) {
                    return Mono.error(new BadRequentException("Duplicate seat numbers in request"));
                }

                return bookingRepo.getBookedSeats(flightId)
                    .collectList()
                    .flatMap(bookedSeats -> {

                        for (String seat : dto.getSeatNumbers()) {
                            if (bookedSeats.contains(seat)) {
                                return Mono.error(new BadRequentException("Seat " + seat + " is already booked"));
                            }
                        }
                        flight.setAvailableSeats(flight.getAvailableSeats() - dto.getNumberOfSeats());

                        return inventoryRepo.save(flight)
                            .flatMap(updatedFlight -> {

                                String pnr = "PNR" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
                                double totalPrice = dto.getNumberOfSeats() * updatedFlight.getPrice();

                                Booking booking = Booking.builder().pnr(pnr).email(dto.getEmail()).bookingTime(LocalDateTime.now())
                                        .departureTime(updatedFlight.getDepartureTime()).arrivalTime(updatedFlight.getArrivalTime())
                                        .journeyDateTime(updatedFlight.getDepartureTime()).inventoryId(updatedFlight.getId())
                                        .flightNumber(updatedFlight.getFlightNumber()).totalPrice(totalPrice)
                                        .cancelled(false).build();

                                return bookingRepo.save(booking)
                                    .flatMap(savedBooking -> {

                                        List<Passenger> passengerList = dto.getPassengers().stream()
                                            .map(p -> Passenger.builder()
                                                    .bookingId(savedBooking.getId()).name(p.getName())
                                                    .gender(p.getGender()).age(p.getAge())
                                                    .seatNumber(p.getSeatNumber())
                                                    .mealOption(p.getMealOption()).build()
                                            )
                                            .toList();

                                        return Flux.fromIterable(passengerList).flatMap(passengerRepo::save).then(Mono.just(savedBooking));
                                    });
                            });
                    });
            });
    }

    public Mono<Booking> getByPnr(String pnr) {
        return bookingRepo.findByPnr(pnr)
                .switchIfEmpty(Mono.error(new NotFoundException("PNR not found")))
                .filter(b -> !b.isCancelled())
                .switchIfEmpty(Mono.error(new NotFoundException("Ticket has been cancelled")));
    }

    public Flux<Booking> history(String email) {
        return bookingRepo.findActiveBookingsByEmail(email)
                .flatMap(booking ->
                    passengerRepo.findByBookingId(booking.getId())
                            .collectList().map(passengers -> {booking.setPassengers(passengers);return booking;})
                );
    }

    public Mono<Void> cancelBooking(String pnr) {

        return bookingRepo.findByPnr(pnr)
            .switchIfEmpty(Mono.error(new NotFoundException("PNR not found")))
            .flatMap(booking -> {
                LocalDateTime cutoff = LocalDateTime.now().plusHours(24);
                if (!booking.getJourneyDateTime().isAfter(cutoff)) {
                    return Mono.error(new ExceptionDuetoTiming("Cannot cancel within 24 hours of journey"));
                }
                booking.setCancelled(true);
                booking.setCancelledAt(LocalDateTime.now());

                return bookingRepo.save(booking)
                    .flatMap(savedBooking ->
                        passengerRepo.findByBookingId(savedBooking.getId())
                            .collectList()
                            .flatMap(passengers -> {
                                int seatCount = passengers.size();
                                return inventoryRepo.findById(savedBooking.getInventoryId())
                                    .switchIfEmpty(Mono.error(new NotFoundException("Flight inventory not found")))
                                    .flatMap(inventory -> {
                                        inventory.setAvailableSeats(inventory.getAvailableSeats() + seatCount);
                                        return inventoryRepo.save(inventory);
                                    });
                            })
                    );
            })
            .then(); 
    }
}
