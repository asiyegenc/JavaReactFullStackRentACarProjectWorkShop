package com.tobeto.rent_a_car.services.dtos.rental.requests;

import com.tobeto.rent_a_car.entities.Car;
import com.tobeto.rent_a_car.entities.Customer;
import com.tobeto.rent_a_car.entities.PaymentMethod;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddRentalRequest {

    private LocalDate rentalDate;

    private LocalDate returnDate;

    private Customer customerId;

    private Car carId;

    private PaymentMethod paymentMethodId;
}