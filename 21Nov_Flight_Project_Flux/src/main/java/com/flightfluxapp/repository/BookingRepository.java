package com.flightfluxapp.repository;

import com.flightfluxapp.entity.Booking;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookingRepository extends R2dbcRepository<Booking, Long> {

    Mono<Booking> findByPnr(String pnr);

    @Query("""
        SELECT * FROM bookings WHERE email = :email AND cancelled = false ORDER BY booking_time DESC
        """)
    Flux<Booking> findActiveBookingsByEmail(String email);

    @Query("""
        SELECT p.seat_number FROM passengers p JOIN bookings b ON p.booking_id = b.id WHERE b.inventory_id = :flightId AND b.cancelled = false
    """)
    Flux<String> getBookedSeats(Long flightId);
}
