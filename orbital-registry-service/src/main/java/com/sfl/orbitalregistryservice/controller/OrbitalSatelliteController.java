package com.sfl.orbitalregistryservice.controller;
import com.sfl.orbitalregistryservice.entity.OrbitalSatellite;
import com.sfl.orbitalregistryservice.service.OrbitalSatelliteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orbital-satellites")
public class OrbitalSatelliteController {

    @Autowired
    private OrbitalSatelliteService service;

    @PostMapping
    public OrbitalSatellite addSatellite(@Valid @RequestBody OrbitalSatellite satellite) {
        return service.addSatellite(satellite);
    }

    @GetMapping
    public List<OrbitalSatellite> getAllSatellites() {
        return service.getAllSatellites();
    }

    @GetMapping("/{id}")
    public OrbitalSatellite getSatellite(@PathVariable Integer id) {
        return service.getSatelliteById(id);
    }

    @PutMapping("/{id}")
    public OrbitalSatellite updateSatellite(@PathVariable Integer id,
                                            @Valid @RequestBody OrbitalSatellite satellite) {

        return service.updateSatellite(id, satellite);
    }

    @DeleteMapping("/{id}")
    public String deleteSatellite(@PathVariable Integer id) {

        return service.deleteSatellite(id);
    }
}