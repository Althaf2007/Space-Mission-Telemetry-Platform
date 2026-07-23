package com.sfl.sensormonitordevice.service;

import com.sfl.sensormonitordevice.dto.AlertRequest;
import com.sfl.sensormonitordevice.entity.Telemetry;
import com.sfl.sensormonitordevice.exception.TelemetryRecordNotFoundException;
import com.sfl.sensormonitordevice.repository.MissionTelemetryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MissionTelemetryManager {

    @Autowired
    private MissionTelemetryStore telemetryStore;

    @Autowired
    private RestTemplate restTemplate;

    public Telemetry saveTelemetry(Telemetry telemetry) {

        AlertRequest alert = new AlertRequest();

        alert.setSatelliteId(telemetry.getSatelliteId());
        alert.setAlertStatus("ACTIVE");

        boolean generate = false;

        if (telemetry.getBatteryLevel() < 20) {

            alert.setAlertType("LOW_BATTERY");
            alert.setAlertMessage("Battery dropped below 20%");
            generate = true;
        }

        else if (telemetry.getTemperature() > 75) {

            alert.setAlertType("HIGH_TEMPERATURE");
            alert.setAlertMessage("Temperature exceeded safe limit");
            generate = true;
        }

        else if (telemetry.getSignalStrength() < 25) {

            alert.setAlertType("LOW_SIGNAL");
            alert.setAlertMessage("Signal strength is too low");
            generate = true;
        }

        if (generate) {

            restTemplate.postForObject(
                    "http://localhost:8083/mission-alert",
                    alert,
                    String.class
            );
        }

        return telemetryStore.save(telemetry);
    }

    public List<Telemetry> getAllTelemetry() {
        return telemetryStore.findAll();
    }

    public List<Telemetry> getTelemetryBySatellite(Integer satelliteId) {

        List<Telemetry> records = telemetryStore.findBySatelliteId(satelliteId);

        if(records.isEmpty()) {
            throw new TelemetryRecordNotFoundException("No Telemetry Records Found");
        }

        return records;
    }

    public String deleteTelemetry(Integer telemetryId){

        Telemetry telemetry = telemetryStore.findById(telemetryId)
                .orElseThrow(() ->
                        new TelemetryRecordNotFoundException("Telemetry Record Not Found"));

        telemetryStore.delete(telemetry);

        return "Telemetry Deleted Successfully";
    }

}