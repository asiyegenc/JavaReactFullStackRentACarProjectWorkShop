package com.tobeto.rent_a_car.services.abstracts;

import com.tobeto.rent_a_car.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rent_a_car.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetAllCustomersResponse;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetAllCustomersResponse> getAll();

    GetCustomerResponse getById(int id);

    void delete(int id);

    void add(AddCustomerRequest addCustomerRequest);

    void update(UpdateCustomerRequest updateCustomerRequest);
}