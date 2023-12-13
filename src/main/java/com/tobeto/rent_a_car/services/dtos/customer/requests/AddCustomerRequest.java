package com.tobeto.rent_a_car.services.dtos.customer.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public  class AddCustomerRequest {


    @NotBlank(message = "Ad boş olamaz")
    private String firstName;

    @NotBlank(message = "Soyad boş olamaz")
    private String lastName;

    @NotNull(message = "Yaş boş olamaz")
    @Min(value = 18, message = "Müşteri 18 yaşından küçük olamaz")
    private Short age;

    @NotBlank(message = "Telefon boş olamaz")
    @Pattern(regexp = "^[0-9]+$", message = "Geçersiz telefon numarası")
    private String phone;

    @NotBlank(message = "E-posta boş olamaz")
    @Email(message = "Geçersiz e-posta adresi")
    private String email;
}