package com.flightfluxapp.service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

import com.flightfluxapp.dto.InventoryRequestDto;
import com.flightfluxapp.dto.SearchRequestDto;
import com.flightfluxapp.entity.Flight;
import com.flightfluxapp.entity.FlightInventory;
import com.flightfluxapp.exception.AvaliableSeatMoreThanTotal;
import com.flightfluxapp.exception.BadRequentException;
import com.flightfluxapp.exception.ExceptionDuetoTiming;
import com.flightfluxapp.exception.FlightAlreadyExist;
import com.flightfluxapp.exception.FlightNotFoundException;
import com.flightfluxapp.repository.FlightInventoryRepository;
import com.flightfluxapp.repository.FlightRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FlightInventoryService {

    private final FlightInventoryRepository inventoryRepo;
    private final FlightRepository flightRepo;

    public Mono<FlightInventory> addInventory(InventoryRequestDto dto) {

        if (dto.getAvailableSeats() > dto.getTotalSeats()) {
            return Mono.error(new AvaliableSeatMoreThanTotal(
                    "Available seats cannot be greater than total seats"));
        }

        if (dto.getArrivalTime().isBefore(dto.getDepartureTime())) {
            return Mono.error(new ExceptionDuetoTiming(
                    "Arrival time cannot be before departure time"));
        }

        if (dto.getFromPlace().equals(dto.getToPlace())) {
            return Mono.error(new BadRequentException(
                    "From and To cannot be same"));
        }
        return inventoryRepo.findDuplicateFlight(
                    dto.getAirlineName(),
                    dto.getFlightNumber(),
                    dto.getFromPlace(),
                    dto.getToPlace(),
                    dto.getDepartureTime())
            .flatMap(existing ->
                Mono.error(new FlightAlreadyExist(
                    "Flight already exists with same details")))

            .switchIfEmpty(Mono.defer(() ->
                flightRepo.findById(dto.getFlightNumber())
                    .switchIfEmpty(Mono.defer(() -> {

                        Flight newFlight = Flight.builder()
                                .flightNumber(dto.getFlightNumber())
                                .airlineName(dto.getAirlineName())
                                .fromPlace(dto.getFromPlace())
                                .toPlace(dto.getToPlace())
                                .isNew(true) 
                                .build();

                        return flightRepo.save(newFlight);
                    }))
            ))

            .cast(Flight.class)

            .flatMap(flight -> {

                FlightInventory fi = FlightInventory.builder()
                        .flightNumber(flight.getFlightNumber())
                        .departureTime(dto.getDepartureTime())
                        .arrivalTime(dto.getArrivalTime())
                        .price(dto.getPrice())
                        .totalSeats(dto.getTotalSeats())
                        .availableSeats(dto.getAvailableSeats())
                        .active(true)
                        .build();

                return inventoryRepo.save(fi);  
            });
    }




    public Mono<Map<String, List<FlightInventory>>> searchFlights(SearchRequestDto dto) {

        LocalDateTime onwardStart = dto.getJourneyDate().atStartOfDay();
        LocalDateTime onwardEnd = dto.getJourneyDate().atTime(23, 59, 59);

        return inventoryRepo.findByFromPlaceAndToPlaceAndDepartureTimeBetween(
                dto.getFromPlace(), dto.getToPlace(), onwardStart, onwardEnd)
            .collectList()
            .flatMap(onwardFlights -> {

                if (onwardFlights.isEmpty()) {
                    return Mono.error(new FlightNotFoundException("No onward flights found"));
                }

                Map<String, List<FlightInventory>> response = new HashMap<>();
                response.put("onwardFlights", onwardFlights);

                if (dto.getTripType().equalsIgnoreCase("ROUND_TRIP")) {

                    if (dto.getReturnDate() == null) {
                        return Mono.error(new ExceptionDuetoTiming("Return date is required for ROUND_TRIP"));
                    }

                    LocalDateTime returnStart = dto.getReturnDate().atStartOfDay();
                    LocalDateTime returnEnd = dto.getReturnDate().atTime(23, 59, 59);

                    return inventoryRepo.findByFromPlaceAndToPlaceAndDepartureTimeBetween(
                                dto.getToPlace(), dto.getFromPlace(), returnStart, returnEnd)
                            .collectList()
                            .flatMap(returnFlights -> {

                                if (returnFlights.isEmpty()) {
                                    return Mono.error(new FlightNotFoundException("No return flights found"));
                                }

                                response.put("returnFlights", returnFlights);
                                return Mono.just(response);
                            });
                }

                return Mono.just(response);
            });
    }
}
