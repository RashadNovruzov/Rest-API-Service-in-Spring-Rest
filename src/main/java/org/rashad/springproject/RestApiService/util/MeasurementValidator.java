package org.rashad.springproject.RestApiService.util;

import org.rashad.springproject.RestApiService.dto.MeasurementDTO;
import org.rashad.springproject.RestApiService.dto.SensorDTO;
import org.rashad.springproject.RestApiService.models.Measurement;
import org.rashad.springproject.RestApiService.models.Sensor;
import org.rashad.springproject.RestApiService.services.MeasurementService;
import org.rashad.springproject.RestApiService.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {
    private SensorService sensorService;
    private MeasurementService measurementService;

    public MeasurementValidator(){

    }

    @Autowired
    public MeasurementValidator(SensorService sensorService, MeasurementService measurementService) {
        this.sensorService = sensorService;
        this.measurementService = measurementService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeasurementDTO measurement = (MeasurementDTO) target;
        SensorDTO sensor = measurement.getSensor();
        if(sensor==null){
            errors.rejectValue("sensor","","Sensor can not be empty");
            return;
        }

        if(this.sensorService.findByName(sensor.getName()) == null){
            errors.rejectValue("sensor","","Sensor with this name doesn't exists.");
        }
    }
}
