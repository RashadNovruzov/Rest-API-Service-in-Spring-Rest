package org.rashad.springproject.RestApiService.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    @Min(value = -100,message = "Value has to be greater than -100")
    @Max(value = 100,message = "Value has to be less than 100")
    @NotNull(message = "value can not be empty")
    private double value;

    @Column(name = "raining")
    @NotNull(message = "raining cant be null")
    private boolean raining;

    @Column(name = "measured_at")
    private LocalDateTime createdAt;

    @NotNull(message = "sensor can not be empty")
    @ManyToOne
    @JoinColumn(name = "sensor_id",referencedColumnName = "id")
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(int id, double value, boolean raining, LocalDateTime createdAt, Sensor sensor) {
        this.id = id;
        this.value = value;
        this.raining = raining;
        this.createdAt = createdAt;
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", value=" + value +
                ", raining=" + raining +
                ", createdAt=" + createdAt +
                ", sensor=" + sensor +
                '}';
    }
}
