package com.sfl.orbitalregistryservice.dto;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public class OrbitalSatelliteDTO {

    private Integer satelliteId;

    @NotBlank(message = "Satellite name is mandatory")
    private String name;

    @NotBlank(message = "Mission name is mandatory")
    private String missionName;

    private LocalDate launchDate;

    private String orbitType;

    private String status;

    public OrbitalSatelliteDTO() {
    }

    public Integer getSatelliteId() {
        return satelliteId;
    }

    public void setSatelliteId(Integer satelliteId) {
        this.satelliteId = satelliteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public String getOrbitType() {
        return orbitType;
    }

    public void setOrbitType(String orbitType) {
        this.orbitType = orbitType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}