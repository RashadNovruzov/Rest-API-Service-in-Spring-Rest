package org.rashad.springproject.RestApiService.controllers;


import org.modelmapper.ModelMapper;
import org.rashad.springproject.RestApiService.dto.SensorDTO;
import org.rashad.springproject.RestApiService.models.Sensor;
import org.rashad.springproject.RestApiService.services.SensorService;
import org.rashad.springproject.RestApiService.util.SensorException;
import org.rashad.springproject.RestApiService.util.SensorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    private final SensorValidator sensorValidator;

    @Autowired
    public SensorController(SensorService sensorService, ModelMapper modelMapper, SensorValidator sensorValidator){
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
    }


    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult){
        Sensor sensor = convertToSensor(sensorDTO);
        sensorValidator.validate(sensor,bindingResult);
        if (bindingResult.hasErrors()){
            StringBuffer errorMsg = new StringBuffer();
            bindingResult.getFieldErrors()
                    .stream()
                    .forEach((FieldError e)->errorMsg.append(e.getField()).append(" : ").append(e.getDefaultMessage()).append(";"));
            throw new SensorException(errorMsg.toString());
        }
        sensorService.save(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO,Sensor.class);
    }
}
