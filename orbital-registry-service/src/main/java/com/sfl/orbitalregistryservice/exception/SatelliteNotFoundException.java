package com.sfl.orbitalregistryservice.exception;

public class SatelliteNotFoundException extends RuntimeException {

    public SatelliteNotFoundException(String message) {
        super(message);
    }
}