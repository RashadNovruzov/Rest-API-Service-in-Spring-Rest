package org.rashad.springproject.RestApiService.services;

import org.rashad.springproject.RestApiService.models.Sensor;
import org.rashad.springproject.RestApiService.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class SensorService {

    private SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository){
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void save(Sensor sensor){
        sensorRepository.save(sensor);
    }

    public Sensor findByName(String name){
        return sensorRepository.findByName(name).orElse(null);
    }

}
