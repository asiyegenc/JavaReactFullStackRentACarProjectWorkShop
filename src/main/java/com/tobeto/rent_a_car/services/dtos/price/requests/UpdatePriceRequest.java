package com.tobeto.rent_a_car.services.dtos.price.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public  class UpdatePriceRequest {

    @NotNull(message = "ID boş olamaz")
    private int id;

    @DecimalMin(value = "0.0", inclusive = false, message = "Saatlik ücret sıfırdan büyük olmalıdır")
    private Double hourlyFee;

    @DecimalMin(value = "0.0", inclusive = false, message = "Günlük ücret sıfırdan büyük olmalıdır")
    private Double dailyFee;

    @DecimalMin(value = "0.0", inclusive = false, message = "Haftalık ücret sıfırdan büyük olmalıdır")
    private Double weeklyFee;

    @DecimalMin(value = "0.0", inclusive = false, message = "Aylık ücret sıfırdan büyük olmalıdır")
    private Double monthlyFee;
}