package com.example.car_search.repository;

import com.example.car_search.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByLengthGreaterThanEqualAndWeightGreaterThanEqualAndVelocityGreaterThanEqualAndColor(
            String length, String weight, String velocity, String color);
    List<Car> findByLengthGreaterThanEqualOrWeightGreaterThanEqualOrVelocityGreaterThanEqualOrColor(
            String length, String weight, String velocity, String color);
}
