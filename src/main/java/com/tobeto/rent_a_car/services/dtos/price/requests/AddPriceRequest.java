package com.tobeto.rent_a_car.services.dtos.price.requests;

import lombok.Data;

@Data
public  class AddPriceRequest {

    private Double hourlyFee;

    private Double dailyFee;

    private Double weeklyFee;

    private Double mountlyFee;
}