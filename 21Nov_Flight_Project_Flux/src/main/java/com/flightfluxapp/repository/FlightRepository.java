package com.flightfluxapp.repository;

import com.flightfluxapp.entity.Flight;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FlightRepository extends R2dbcRepository<Flight, String> {
}
