package org.rashad.springproject.RestApiService.repositories;

import org.rashad.springproject.RestApiService.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {
    List<Measurement> findByRainingTrue();
}
