package com.sfl.maintenanceservice.exception;

public class MaintenanceNotFoundException extends RuntimeException {

    public MaintenanceNotFoundException(String message) {
        super(message);
    }
}