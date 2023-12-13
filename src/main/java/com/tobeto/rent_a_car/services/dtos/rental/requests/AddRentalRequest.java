package com.tobeto.rent_a_car.services.dtos.rental.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddRentalRequest {

    @NotNull(message = "Kiralama tarihi boş olamaz")
    private LocalDate rentalDate;

    @NotNull(message = "Dönüş tarihi boş olamaz")
    private LocalDate returnDate;

    @NotNull(message = "CustomerId boş olamaz")
    private int customerId;

    @NotNull(message = "CarId boş olamaz")
    private int carId;

    @NotNull(message = "PaymentMethodId boş olamaz")
    private int paymentMethodId;

}