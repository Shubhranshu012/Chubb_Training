package com.flightfluxapp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("bookings")
public class Booking {
    @Id
    private Long id;

    private String pnr;
    private String email;
    private LocalDateTime bookingTime;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDateTime journeyDateTime;
    private Double totalPrice;
    private boolean cancelled;
    private LocalDateTime cancelledAt;
    private Long inventoryId;
    private String flightNumber;

    @Transient 
    private List<Passenger> passengers;
}
