package com.sfl.orbitalregistryservice.repository;

import com.sfl.orbitalregistryservice.entity.OrbitalSatellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrbitalSatelliteRepository extends JpaRepository<OrbitalSatellite, Integer> {

}