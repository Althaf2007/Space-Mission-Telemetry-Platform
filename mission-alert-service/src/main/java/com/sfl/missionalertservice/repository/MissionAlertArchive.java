package com.sfl.missionalertservice.repository;
import com.sfl.missionalertservice.entity.MissionAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MissionAlertArchive extends JpaRepository<MissionAlert, Integer> {

    List<MissionAlert> findBySatelliteId(Integer satelliteId);

}