package com.flightfluxapp.controller;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flightfluxapp.dto.BookingRequestDto;
import com.flightfluxapp.entity.Booking;
import com.flightfluxapp.service.BookingService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/api/v1.0/flight/booking/{flightId}")
    public Mono<ResponseEntity<Map<String, String>>> book(@PathVariable Long flightId,@Valid @RequestBody BookingRequestDto dto) {

        return bookingService.bookTicket(flightId, dto)
            .map(booking -> {
                Map<String, String> response = Map.of("pnr", booking.getPnr());
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            });
    }

    @GetMapping("/api/v1.0/flight/ticket/{pnr}")
    public ResponseEntity<Mono<Booking>> getTicket(@PathVariable String pnr) {
    	
        return ResponseEntity.ok(bookingService.getByPnr(pnr));
    }

    @GetMapping("/api/v1.0/flight/booking/history/{email}")
    public ResponseEntity<Flux<Booking>> history(@PathVariable String email) {
    	
        return ResponseEntity.ok(bookingService.history(email));
    }

    @DeleteMapping("/api/v1.0/flight/booking/cancel/{pnr}")
    public Mono<ResponseEntity<Map<String, String>>> cancel(@PathVariable String pnr) {

        return bookingService.cancelBooking(pnr)
                .then(Mono.just(
                    ResponseEntity.ok(
                        Map.of("message", "Ticket cancelled successfully")
                    )
                ));
    }
}