package com.sfl.orbitalregistryservice.service;
import com.sfl.orbitalregistryservice.entity.OrbitalSatellite;
import com.sfl.orbitalregistryservice.exception.SatelliteNotFoundException;
import com.sfl.orbitalregistryservice.repository.OrbitalSatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrbitalSatelliteService {

    @Autowired
    private OrbitalSatelliteRepository repository;

    public OrbitalSatellite addSatellite(OrbitalSatellite satellite) {
        return repository.save(satellite);
    }

    public List<OrbitalSatellite> getAllSatellites() {
        return repository.findAll();
    }

    public OrbitalSatellite getSatelliteById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new SatelliteNotFoundException("Satellite not found with ID : " + id));
    }

    public OrbitalSatellite updateSatellite(Integer id, OrbitalSatellite satellite) {

        OrbitalSatellite existing = getSatelliteById(id);

        existing.setName(satellite.getName());
        existing.setMissionName(satellite.getMissionName());
        existing.setLaunchDate(satellite.getLaunchDate());
        existing.setOrbitType(satellite.getOrbitType());
        existing.setStatus(satellite.getStatus());

        return repository.save(existing);
    }

    public String deleteSatellite(Integer id) {

        OrbitalSatellite satellite = getSatelliteById(id);

        repository.delete(satellite);

        return "Satellite Deleted Successfully";
    }
}