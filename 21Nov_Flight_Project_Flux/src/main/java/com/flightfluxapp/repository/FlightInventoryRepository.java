package com.flightfluxapp.repository;

import com.flightfluxapp.entity.FlightInventory;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface FlightInventoryRepository extends R2dbcRepository<FlightInventory, Long> {

    @Query("""
        SELECT fi.* FROM flight_inventory fi JOIN flights f ON fi.flight_number = f.flight_number
        WHERE f.from_place = :from AND f.to_place = :to AND fi.departure_time BETWEEN :start AND :end
    """)
    Flux<FlightInventory> findByFromPlaceAndToPlaceAndDepartureTimeBetween(
            String from,
            String to,
            LocalDateTime start,
            LocalDateTime end
    );

    @Query("""
        SELECT fi.* FROM flight_inventory fi
        JOIN flights f ON fi.flight_number = f.flight_number WHERE f.airline_name = :airline
        AND f.flight_number = :flightNumber AND f.from_place = :from AND f.to_place = :to AND fi.departure_time = :departure
    """)
    Mono<FlightInventory> findDuplicateFlight(
            String airline,
            String flightNumber,
            String from,
            String to,
            LocalDateTime departure
    );
}
