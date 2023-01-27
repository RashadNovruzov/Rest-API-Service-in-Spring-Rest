package org.rashad.springproject.RestApiService.services;

import org.rashad.springproject.RestApiService.models.Measurement;
import org.rashad.springproject.RestApiService.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MeasurementService {
    private MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository){
        this.measurementRepository = measurementRepository;
    }

    public void save(Measurement measurement){
        measurement.setCreatedAt(LocalDateTime.now());
        measurementRepository.save(measurement);
    }

    public List<Measurement> findAll(){
        return measurementRepository.findAll();
    }

    public List<Measurement> findByRainingTrue(){
        return measurementRepository.findByRainingTrue();
    }

    public Measurement findById(int id){
        return measurementRepository.findById(id).orElse(null);
    }

}
