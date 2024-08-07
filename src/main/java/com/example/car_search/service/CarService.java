package com.example.car_search.service;

import com.example.car_search.model.Car;
import com.example.car_search.value_object.CarSearchCriteria;

import java.util.List;

public interface CarService {
    List<Car> searchCars(CarSearchCriteria criteria);

//    List<Car> searchCars(String s, String number, String number1, String red);
}
