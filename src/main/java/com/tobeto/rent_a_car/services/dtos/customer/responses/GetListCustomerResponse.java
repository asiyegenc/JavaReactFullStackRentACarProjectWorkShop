package com.tobeto.rent_a_car.services.dtos.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private Short age;
    private String phone;
    private String email;
}
