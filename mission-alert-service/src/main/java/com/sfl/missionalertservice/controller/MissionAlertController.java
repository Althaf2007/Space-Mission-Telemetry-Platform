package com.sfl.missionalertservice.controller;
import com.sfl.missionalertservice.entity.MissionAlert;
import com.sfl.missionalertservice.service.MissionAlertCoordinator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mission-alert")
public class MissionAlertController {

    @Autowired
    private MissionAlertCoordinator alertCoordinator;

    @PostMapping
    public MissionAlert saveAlert(@Valid @RequestBody MissionAlert alert) {
        return alertCoordinator.saveAlert(alert);
    }

    @GetMapping
    public List<MissionAlert> getAllAlerts() {
        return alertCoordinator.getAllAlerts();
    }

    @GetMapping("/{satelliteId}")
    public List<MissionAlert> getAlertsBySatellite(@PathVariable Integer satelliteId) {
        return alertCoordinator.getAlertsBySatellite(satelliteId);
    }

    @DeleteMapping("/{alertId}")
    public String deleteAlert(@PathVariable Integer alertId) {
        return alertCoordinator.deleteAlert(alertId);
    }
}