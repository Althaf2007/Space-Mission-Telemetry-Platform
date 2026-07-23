package com.sfl.sensormonitordevice.exception;
public class TelemetryRecordNotFoundException extends RuntimeException {
    public TelemetryRecordNotFoundException(String message) {
        super(message);
    }
}