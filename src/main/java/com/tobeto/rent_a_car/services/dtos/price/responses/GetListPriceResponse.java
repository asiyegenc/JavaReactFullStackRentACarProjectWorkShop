package com.tobeto.rent_a_car.services.dtos.price.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListPriceResponse {
    private int id;
    private Double hourlyFee;
    private Double dailyFee;
    private Double weeklyFee;
    private Double mountlyFee;
}
