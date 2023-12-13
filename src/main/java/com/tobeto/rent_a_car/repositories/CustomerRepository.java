package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Customer;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {

    @Query("SELECT new com.tobeto.rent_a_car.services.dtos.customer.responses.GetListCustomerResponse(cus.id, cus.firstName, cus.lastName, cus.age, cus.phone, cus.email) FROM Customer cus WHERE cus.firstName = :firstName")
    List<GetListCustomerResponse> findByFirstName(@RequestParam("firstName") String firstName);

    @Query("SELECT new com.tobeto.rent_a_car.services.dtos.customer.responses.GetListCustomerResponse(cus.id, cus.firstName, cus.lastName, cus.age, cus.phone, cus.email) FROM Customer cus WHERE cus.email LIKE %:email%")
    List<GetListCustomerResponse> findByEmailLike(@RequestParam("email") String email);

    List<Customer>findByPhone(@RequestParam String phone);
}
