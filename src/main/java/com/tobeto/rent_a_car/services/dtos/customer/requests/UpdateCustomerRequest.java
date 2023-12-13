package com.tobeto.rent_a_car.services.dtos.customer.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateCustomerRequest {

    @NotNull(message = "ID boş olamaz")
    private int id;

    @NotBlank(message = "Ad boş olamaz")
    private String firstName;

    @NotBlank(message = "Soyad boş olamaz")
    private String lastName;

    @Min(value = 18, message = "Müşteri 18 yaşından küçük olamaz")
    private Short age;

    @Pattern(regexp = "^[0-9]+$", message = "Geçersiz telefon numarası")
    private String phone;

    @Email(message = "Geçersiz e-posta adresi")
    private String email;
}