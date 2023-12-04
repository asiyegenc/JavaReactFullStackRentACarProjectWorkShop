package com.tobeto.rent_a_car.services.dtos.car.responses;

import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.entities.Color;
import com.tobeto.rent_a_car.entities.Price;
import com.tobeto.rent_a_car.entities.Type;
import lombok.Data;

@Data
public  class GetCarResponse {

    private int modelYear;

    private String modelName;

    private String status;

    private Price price;

    private Brand brand;

    private Color color;

    private Type type;
}