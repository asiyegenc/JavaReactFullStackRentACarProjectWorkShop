package com.tobeto.rent_a_car.services.dtos.customer.responses;

import lombok.Data;

@Data
public  class GetCustomerResponse {


    private String firstName;

    private String lastName;

    private Short age;

    private String phone;

    private String email;
}