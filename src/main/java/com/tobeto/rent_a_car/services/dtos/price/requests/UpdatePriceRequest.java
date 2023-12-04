package com.tobeto.rent_a_car.services.dtos.price.requests;

import lombok.Data;

@Data
public  class UpdatePriceRequest {

    private int id;

    private Double hourlyFee;

    private Double dailyFee;

    private Double weeklyFee;

    private Double mountlyFee;
}