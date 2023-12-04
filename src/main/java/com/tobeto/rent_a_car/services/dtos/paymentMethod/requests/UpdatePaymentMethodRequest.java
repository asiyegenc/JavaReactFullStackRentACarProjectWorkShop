package com.tobeto.rent_a_car.services.dtos.paymentMethod.requests;

import com.tobeto.rent_a_car.entities.Customer;
import lombok.Data;
import java.time.LocalDate;

@Data

public class UpdatePaymentMethodRequest {

    private int id;

    private String paymentType;

    private String cardHolderName;

    private String cardNumber;

    private LocalDate expirationDate;

    private Integer cvv;

    private Customer customerId;
}