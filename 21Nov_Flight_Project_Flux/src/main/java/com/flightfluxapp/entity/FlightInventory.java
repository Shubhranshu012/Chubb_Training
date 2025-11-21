package com.flightfluxapp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("flight_inventory")
public class FlightInventory {

    @Id
    private Long id;

    private String flightNumber;     

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    private Integer totalSeats;
    private Integer availableSeats;
    private boolean active;
}
