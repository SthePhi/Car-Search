package com.example.car_search.value_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarSearchCriteria {
    private String length;
    private String weight;
    private String velocity;
    private String color;
}
