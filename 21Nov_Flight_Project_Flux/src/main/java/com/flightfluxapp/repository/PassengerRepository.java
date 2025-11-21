package com.flightfluxapp.repository;


import com.flightfluxapp.entity.Passenger;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface PassengerRepository extends R2dbcRepository<Passenger, Long> {

    Flux<Passenger> findByBookingId(Long bookingId);
}
