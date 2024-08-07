package com.example.car_search.service;

import com.example.car_search.model.Car;
import com.example.car_search.repository.CarRepository;
import com.example.car_search.value_object.CarSearchCriteria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {
    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @Test
    public void
    testSearchCars() {
        // Given
        Car car1 = new Car(1L, "4.5", "1500", "120", "red");
        Car car2 = new Car(2L, "3.8", "1300", "110", "blue");
        List<Car> expectedCars = List.of(car1, car2);
        when(carRepository.findByLengthGreaterThanEqualAndWeightGreaterThanEqualAndVelocityGreaterThanEqualAndColor("4.0", "1300", "110", "red"))
                .thenReturn(expectedCars);

        // When
        List<Car> result = carService.searchCars(new CarSearchCriteria("4.0", "1300", "110", "red"));

        // Then
        assertEquals(expectedCars, result);
    }

}