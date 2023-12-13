package com.tobeto.rent_a_car.services.dtos.customer.requests;

import jakarta.validation.constraints.Min;

public class DeleteCustomerRequest {
    @Min(value = 1, message = "Geçersiz müşteri kimliği")
    private int customerId;
}
