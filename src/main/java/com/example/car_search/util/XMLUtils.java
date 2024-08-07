package com.example.car_search.util;

import com.example.car_search.dto.CarDTO;
import com.example.car_search.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.List;

public class XMLUtils {
    public static String carsToXml(List<Car> cars) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Cars.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


        StringWriter sw = new StringWriter();
        marshaller.marshal(new
                Cars(cars), sw);
        return sw.toString();
    }

    @XmlRootElement(name = "cars")
    @XmlAccessorType(XmlAccessType.FIELD)
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Cars {
        private List<Car> car;
    }
}
