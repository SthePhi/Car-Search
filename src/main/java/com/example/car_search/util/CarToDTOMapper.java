package com.example.car_search.util;

import com.example.car_search.dto.CarDTO;
import com.example.car_search.model.Car;

public class CarToDTOMapper {
    public static CarDTO mapCarToCarDTO(Car car){
        return CarDTO.builder()
                .color(car.getColor())
                .length(car.getLength())
                .velocity(car.getVelocity())
                .weight(car.getWeight())
                .build();
    }
}
