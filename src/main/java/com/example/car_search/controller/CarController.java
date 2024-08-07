package com.example.car_search.controller;

import com.example.car_search.dto.CarDTO;
import com.example.car_search.model.Car;
import com.example.car_search.service.CarService;
import com.example.car_search.util.CarToDTOMapper;
import com.example.car_search.util.XMLUtils;
import com.example.car_search.value_object.CarSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {@Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDTO>> searchCars(@RequestParam(required = false) String length,
                                             @RequestParam(required = false) String weight,
                                             @RequestParam(required = false) String velocity,
                                             @RequestParam(required = false) String color){
        CarSearchCriteria criteria = new CarSearchCriteria();
        criteria.setColor(color);
        criteria.setLength(length);
        criteria.setVelocity(velocity);
        criteria.setWeight(weight);

        List<Car> cars = carService.searchCars(criteria);
        return ResponseEntity.ok(cars.stream().map(car ->
                CarToDTOMapper.mapCarToCarDTO(car)).collect(Collectors.toUnmodifiableList()));
    }

    @GetMapping("/download")
    public ResponseEntity<String> downloadCars(@RequestParam(required = false) String length,
                                               @RequestParam(required = false) String weight,
                                               @RequestParam(required = false) String velocity,
                                               @RequestParam(required = false) String color) throws Exception {
        CarSearchCriteria criteria = new CarSearchCriteria(length, weight, velocity, color);
        List<Car> cars = carService.searchCars(criteria);

        JAXBContext context = JAXBContext.newInstance(XMLUtils.Cars.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


        StringWriter sw = new StringWriter();
        marshaller.marshal(new
                XMLUtils.Cars(cars), sw);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"cars.xml\"")
                .body(sw.toString());
    }
}
