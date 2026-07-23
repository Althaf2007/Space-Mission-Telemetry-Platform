package com.sfl.sensormonitordevice.repository;

import com.sfl.sensormonitordevice.entity.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionTelemetryStore extends JpaRepository<Telemetry, Integer> {

    List<Telemetry> findBySatelliteId(Integer satelliteId);

}