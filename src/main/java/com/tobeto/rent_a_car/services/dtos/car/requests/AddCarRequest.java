package com.tobeto.rent_a_car.services.dtos.car.requests;

import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.entities.Color;
import com.tobeto.rent_a_car.entities.Price;
import com.tobeto.rent_a_car.entities.Type;
import lombok.Data;

@Data
public  class AddCarRequest {

    private int modelYear;

    private String modelName;

    private String status;

    private Price priceId;

    private Brand brandId;

    private Color colorId;

    private Type typeId;
}