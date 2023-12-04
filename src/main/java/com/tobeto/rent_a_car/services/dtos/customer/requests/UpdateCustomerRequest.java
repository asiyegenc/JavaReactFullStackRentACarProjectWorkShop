package com.tobeto.rent_a_car.services.dtos.customer.requests;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private int id;

    private String firstName;

    private String lastName;

    private Short age;

    private String phone;

    private String email;
}