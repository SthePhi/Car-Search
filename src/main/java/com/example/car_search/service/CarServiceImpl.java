package com.example.car_search.service;

import com.example.car_search.model.Car;
import com.example.car_search.repository.CarRepository;
import com.example.car_search.value_object.CarSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;
    @Override
    public List<Car> searchCars(CarSearchCriteria criteria) {
        return carRepository.findByLengthGreaterThanEqualAndWeightGreaterThanEqualAndVelocityGreaterThanEqualAndColor(
                criteria.getLength(), criteria.getWeight(), criteria.getVelocity(), criteria.getColor());
    }
}
