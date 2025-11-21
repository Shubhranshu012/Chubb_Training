package com.flightfluxapp.controller;

import lombok.*;
import reactor.core.publisher.Mono;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.flightfluxapp.service.FlightInventoryService;
import jakarta.validation.Valid;
import com.flightfluxapp.dto.InventoryRequestDto;


@RestController
@RequiredArgsConstructor
public class AirlineInventoryController {

    private final FlightInventoryService inventoryService;

    @PostMapping("/api/v1.0/flight/airline/inventory/add")
    public Mono<ResponseEntity> addInventory(@Valid @RequestBody InventoryRequestDto dto) {

        return inventoryService.addInventory(dto)
            .map(result -> {
                Map<String, String> response = Map.of("message", "Inventory added successfully");
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            });
    }


}