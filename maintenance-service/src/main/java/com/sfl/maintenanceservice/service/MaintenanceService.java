package com.sfl.maintenanceservice.service;

import com.sfl.maintenanceservice.entity.Maintenance;
import com.sfl.maintenanceservice.exception.MaintenanceNotFoundException;
import com.sfl.maintenanceservice.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository repository;
    public Maintenance saveMaintenance(Maintenance maintenance) {
        return repository.save(maintenance);
    }

    public List<Maintenance> getAllMaintenance() {
        return repository.findAll();
    }

    public Maintenance getMaintenanceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MaintenanceNotFoundException(
                        "Maintenance not found with ID: " + id));
    }

    public Maintenance updateMaintenance(Long id, Maintenance maintenance) {

        Maintenance existing = repository.findById(id)
                .orElseThrow(() -> new MaintenanceNotFoundException(
                        "Maintenance not found with ID: " + id));

        existing.setSatelliteId(maintenance.getSatelliteId());
        existing.setEngineerName(maintenance.getEngineerName());
        existing.setScheduleDate(maintenance.getScheduleDate());
        existing.setRemarks(maintenance.getRemarks());
        existing.setStatus(maintenance.getStatus());

        return repository.save(existing);
    }

    public String deleteMaintenance(Long id) {

        Maintenance existing = repository.findById(id)
                .orElseThrow(() -> new MaintenanceNotFoundException(
                        "Maintenance not found with ID: " + id));

        repository.delete(existing);

        return "Maintenance deleted successfully.";
    }
}