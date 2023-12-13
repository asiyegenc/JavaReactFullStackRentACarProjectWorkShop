package com.tobeto.rent_a_car.services.dtos.car.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateCarRequest {

    @NotNull(message = "Model yılı boş olamaz")
    private int modelYear;

    @Size(min = 3, max = 50, message = "Model adı boş olamaz")
    private String modelName;

    @NotNull(message = "Renk ID doğru girilmelidir")
    private int colorId;

    @NotNull(message = "Type ID doğru girilmelidir")
    private int typeId;
}