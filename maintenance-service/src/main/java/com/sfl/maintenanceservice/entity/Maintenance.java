package com.sfl.maintenanceservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceId;

    @NotNull(message = "Satellite ID is required")
    private Long satelliteId;

    @NotBlank(message = "Engineer Name is required")
    private String engineerName;

    @NotNull(message = "Schedule Date is required")
    private LocalDate scheduleDate;

    private String remarks;

    private String status;

    public Maintenance() {
    }

    public Maintenance(Long maintenanceId, Long satelliteId, String engineerName,
                       LocalDate scheduleDate, String remarks, String status) {
        this.maintenanceId = maintenanceId;
        this.satelliteId = satelliteId;
        this.engineerName = engineerName;
        this.scheduleDate = scheduleDate;
        this.remarks = remarks;
        this.status = status;
    }

    public Long getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Long maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public Long getSatelliteId() {
        return satelliteId;
    }

    public void setSatelliteId(Long satelliteId) {
        this.satelliteId = satelliteId;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}