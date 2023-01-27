package org.rashad.springproject.RestApiService.dto;

import org.rashad.springproject.RestApiService.models.Sensor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MeasurementDTO {

    @Min(value = -100,message = "Value has to be greater than -100")
    @Max(value = 100,message = "Value has to be less than 100")
    @NotNull(message = "value cant be empty")
    private double value;

    @NotNull(message = "raining cant be empty")
    private boolean raining;

    @NotNull(message = "sensorDTO cant be empty")
    private SensorDTO sensorDTO;

    public MeasurementDTO() {
    }

    public MeasurementDTO(double value, boolean raining, SensorDTO sensor) {
        this.value = value;
        this.raining = raining;
        this.sensorDTO = sensor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensorDTO;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensorDTO = sensor;
    }
}
