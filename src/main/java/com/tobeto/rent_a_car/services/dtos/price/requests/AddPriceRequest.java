package com.tobeto.rent_a_car.services.dtos.price.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public  class AddPriceRequest {

    @NotNull(message = "Saatlik ücret boş olamaz")
    private Double hourlyFee;

    @NotNull(message = "Günlük ücret boş olamaz")
    private Double dailyFee;

    @NotNull(message = "Haftalık ücret boş olamaz")
    private Double weeklyFee;

    @NotNull(message = "Aylık ücret boş olamaz")
    private Double monthlyFee;
}