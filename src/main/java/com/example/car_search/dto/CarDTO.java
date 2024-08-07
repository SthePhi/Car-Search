package com.example.car_search.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarDTO {
    private String length;
    private String weight;
    private String velocity;
    private String color;
}
