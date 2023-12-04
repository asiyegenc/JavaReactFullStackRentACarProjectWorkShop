package com.tobeto.rent_a_car.services.dtos.price.responses;

import lombok.Data;

@Data
public class GetAllPricesResponse {

    private int id;

    private Double hourlyFee;

    private Double dailyFee;

    private Double weeklyFee;

    private Double mountlyFee;
}