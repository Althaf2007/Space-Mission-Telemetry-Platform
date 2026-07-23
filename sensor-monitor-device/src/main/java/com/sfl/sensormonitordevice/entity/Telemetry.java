package com.sfl.sensormonitordevice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "telemetry_records")
public class Telemetry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer telemetryId;

    @NotNull(message = "Satellite Id is mandatory")
    private Integer satelliteId;

    @Min(value = 0, message = "Battery cannot be below 0")
    @Max(value = 100, message = "Battery cannot exceed 100")
    private Integer batteryLevel;

    @NotNull(message = "Temperature is mandatory")
    private Double temperature;

    @Positive(message = "Signal strength must be positive")
    private Double signalStrength;

    private Double altitude;

    @NotNull(message = "Timestamp is mandatory")
    private LocalDateTime timestamp;

    public Telemetry() {
    }

    public Integer getTelemetryId() {
        return telemetryId;
    }

    public void setTelemetryId(Integer telemetryId) {
        this.telemetryId = telemetryId;
    }

    public Integer getSatelliteId() {
        return satelliteId;
    }

    public void setSatelliteId(Integer satelliteId) {
        this.satelliteId = satelliteId;
    }

    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(Double signalStrength) {
        this.signalStrength = signalStrength;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}