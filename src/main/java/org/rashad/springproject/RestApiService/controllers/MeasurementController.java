package org.rashad.springproject.RestApiService.controllers;

import org.modelmapper.ModelMapper;
import org.rashad.springproject.RestApiService.dto.MeasurementDTO;
import org.rashad.springproject.RestApiService.dto.RainyDaysCountDTO;
import org.rashad.springproject.RestApiService.models.Measurement;
import org.rashad.springproject.RestApiService.services.MeasurementService;
import org.rashad.springproject.RestApiService.services.SensorService;
import org.rashad.springproject.RestApiService.util.MeasurementException;
import org.rashad.springproject.RestApiService.util.MeasurementValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;
    private final MeasurementValidator measurementValidator;
    private final SensorService sensorService;

    @Autowired
    public MeasurementController(MeasurementService measurementService, ModelMapper modelMapper, MeasurementValidator measurementValidator, SensorService sensorService){
        this.measurementService = measurementService;
        this.modelMapper = modelMapper;
        this.measurementValidator = measurementValidator;
        this.sensorService = sensorService;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementDTO measurementDTO, BindingResult bindingResult){
        measurementValidator.validate(measurementDTO,bindingResult);
        Measurement measurement = convertToMeasurement(measurementDTO);

        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            bindingResult.getFieldErrors().forEach(
                    (e)->{
                        errorMsg.append(e.getField()).append(" : ").append(e.getDefaultMessage()).append(";");
                    }
            );
            throw new MeasurementException(errorMsg.toString());
        }
        measurement.setSensor(sensorService.findByName(measurement.getSensor().getName()));
        measurement.getSensor().getMeasurements().add(measurement);
        measurementService.save(measurement);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping
    public List<MeasurementDTO> measurements(){
        return measurementService.findAll().stream().map((measurement -> convertToMeasurementDTO(measurement))).collect(Collectors.toList());
    }

    @GetMapping("/rainyDaysCount")
    public RainyDaysCountDTO rainyDaysCount(){
        return new RainyDaysCountDTO(measurementService.findByRainingTrue().size());
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement){
       return modelMapper.map(measurement,MeasurementDTO.class);
    }
    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO,Measurement.class);
    }

}
