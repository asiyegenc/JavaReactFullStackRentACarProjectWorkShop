package com.tobeto.rent_a_car.services.abstracts;

import com.tobeto.rent_a_car.entities.Customer;
import com.tobeto.rent_a_car.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rent_a_car.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetAllCustomersResponse;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetCustomerResponse;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetAllCustomersResponse> getAll();

   // GetCustomerResponse getById(int id);

    void delete(int id);

    void add(AddCustomerRequest addCustomerRequest);

    void update(UpdateCustomerRequest updateCustomerRequest);

    List<GetListCustomerResponse>getByFirstName(String firstName);

    List<GetListCustomerResponse>getByEmailLike(String email);

    List<Customer> getByPhone(String phone);

    Customer getById(int id);
}