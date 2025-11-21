package com.flightfluxapp.exception;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(org.springframework.web.bind.support.WebExchangeBindException.class)
    public Mono<ResponseEntity<Map<String, String>>> handleValidationErrors(WebExchangeBindException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return Mono.just(ResponseEntity.badRequest().body(errors));
    }

    @ExceptionHandler(NotFoundException.class)
    public Mono<ResponseEntity<Map<String, String>>> handleNotFound(NotFoundException ex) {
        return Mono.just(
            ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()))
        );
    }

    @ExceptionHandler(BadRequentException.class)
    public Mono<ResponseEntity<Map<String, String>>> handleBadRequest(BadRequentException ex) {
        return Mono.just(
            ResponseEntity.badRequest()
                .body(Map.of("error", ex.getMessage()))
        );
    }

    @ExceptionHandler(ExceptionDuetoTiming.class)
    public Mono<ResponseEntity<Map<String, String>>> handleTiming(ExceptionDuetoTiming ex) {
        return Mono.just(
            ResponseEntity.badRequest()
                .body(Map.of("error", ex.getMessage()))
        );
    }

    @ExceptionHandler(FlightAlreadyExist.class)
    public Mono<ResponseEntity<Map<String, String>>> handleExists(FlightAlreadyExist ex) {
        return Mono.just(
            ResponseEntity.badRequest()
                .body(Map.of("error", ex.getMessage()))
        );
    }

    @ExceptionHandler(AvaliableSeatMoreThanTotal.class)
    public Mono<ResponseEntity<Map<String, String>>> handleSeatError(AvaliableSeatMoreThanTotal ex) {
        return Mono.just(
            ResponseEntity.badRequest()
                .body(Map.of("error", ex.getMessage()))
        );
    }

    @ExceptionHandler(FlightNotFoundException.class)
    public Mono<ResponseEntity<Map<String, String>>> handleFlightNotFound(FlightNotFoundException ex) {
        return Mono.just(
            ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()))
        );
    }
}