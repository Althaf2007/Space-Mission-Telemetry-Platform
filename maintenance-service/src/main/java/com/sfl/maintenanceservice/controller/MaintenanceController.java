package com.sfl.maintenanceservice.controller;

import com.sfl.maintenanceservice.entity.Maintenance;
import com.sfl.maintenanceservice.service.MaintenanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService service;
    @PostMapping
    public Maintenance saveMaintenance(@Valid @RequestBody Maintenance maintenance) {
        return service.saveMaintenance(maintenance);
    }

    @GetMapping
    public List<Maintenance> getAllMaintenance() {
        return service.getAllMaintenance();
    }

    @GetMapping("/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return service.getMaintenanceById(id);
    }

    @PutMapping("/{id}")
    public Maintenance updateMaintenance(@PathVariable Long id,
                                         @Valid @RequestBody Maintenance maintenance) {
        return service.updateMaintenance(id, maintenance);
    }

    @DeleteMapping("/{id}")
    public String deleteMaintenance(@PathVariable Long id) {
        return service.deleteMaintenance(id);
    }
}