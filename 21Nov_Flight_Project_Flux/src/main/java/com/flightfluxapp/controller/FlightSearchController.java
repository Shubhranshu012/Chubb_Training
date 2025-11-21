package com.flightfluxapp.controller;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flightfluxapp.dto.SearchRequestDto;
import com.flightfluxapp.entity.FlightInventory;
import com.flightfluxapp.service.FlightInventoryService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FlightSearchController {

    private final FlightInventoryService inventoryService;

    @PostMapping("/api/v1.0/flight/search")
    public ResponseEntity<Mono<Map<String, List<FlightInventory>>>> search(@Valid @RequestBody SearchRequestDto dto) {
        return ResponseEntity.ok(inventoryService.searchFlights(dto));
    }
}
