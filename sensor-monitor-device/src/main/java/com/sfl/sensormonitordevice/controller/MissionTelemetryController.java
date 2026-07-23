package com.sfl.sensormonitordevice.controller;

import com.sfl.sensormonitordevice.entity.Telemetry;
import com.sfl.sensormonitordevice.service.MissionTelemetryManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission-telemetry")
public class MissionTelemetryController {

    @Autowired
    private MissionTelemetryManager telemetryManager;

    @PostMapping
    public Telemetry saveTelemetry(@Valid @RequestBody Telemetry telemetry){
        return telemetryManager.saveTelemetry(telemetry);
    }

    @GetMapping
    public List<Telemetry> getAllTelemetry(){
        return telemetryManager.getAllTelemetry();
    }

    @GetMapping("/{satelliteId}")
    public List<Telemetry> getTelemetry(@PathVariable Integer satelliteId){
        return telemetryManager.getTelemetryBySatellite(satelliteId);
    }

    @DeleteMapping("/{telemetryId}")
    public String deleteTelemetry(@PathVariable Integer telemetryId){
        return telemetryManager.deleteTelemetry(telemetryId);
    }
}