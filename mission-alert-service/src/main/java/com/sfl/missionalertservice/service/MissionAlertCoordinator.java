package com.sfl.missionalertservice.service;

import com.sfl.missionalertservice.dto.MaintenanceRequest;
import com.sfl.missionalertservice.entity.MissionAlert;
import com.sfl.missionalertservice.exception.AlertNotFoundException;
import com.sfl.missionalertservice.repository.MissionAlertArchive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class MissionAlertCoordinator {

    @Autowired
    private MissionAlertArchive alertArchive;

    @Autowired
    private RestTemplate restTemplate;

    public MissionAlert saveAlert(MissionAlert alert) {

        MissionAlert savedAlert = alertArchive.save(alert);

        MaintenanceRequest request = new MaintenanceRequest();

        request.setSatelliteId(alert.getSatelliteId().longValue());
        request.setEngineerName("System");
        request.setScheduleDate(LocalDate.now().plusDays(1));
        request.setRemarks(alert.getAlertMessage());
        request.setStatus("SCHEDULED");

        restTemplate.postForObject(
                "http://localhost:8080/maintenance",
                request,
                String.class
        );

        return savedAlert;
    }

    public List<MissionAlert> getAllAlerts() {
        return alertArchive.findAll();
    }

    public List<MissionAlert> getAlertsBySatellite(Integer satelliteId) {

        List<MissionAlert> alerts = alertArchive.findBySatelliteId(satelliteId);

        if (alerts.isEmpty()) {
            throw new AlertNotFoundException(
                    "No Alerts Found For Satellite : " + satelliteId);
        }

        return alerts;
    }

    public String deleteAlert(Integer alertId) {

        MissionAlert alert = alertArchive.findById(alertId)
                .orElseThrow(() ->
                        new AlertNotFoundException(
                                "Alert Not Found : " + alertId));

        alertArchive.delete(alert);

        return "Alert Deleted Successfully";
    }
}