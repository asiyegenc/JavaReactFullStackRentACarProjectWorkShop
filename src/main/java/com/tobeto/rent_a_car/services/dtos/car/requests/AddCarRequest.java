package com.tobeto.rent_a_car.services.dtos.car.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class AddCarRequest {

    @NotBlank(message = "Model yılı boş olamaz")
    private int modelYear;

    @NotBlank(message = "Model adı boş olamaz")
    private String modelName;

    @Positive(message = "Marka id doğru girilmelidir")
    private int brandId;

    @NotNull(message = "Renk ID doğru girilmelidir")
    private int colorId;

    @NotNull(message = "Type ID doğru girilmelidir.")
    private int typeId;

}