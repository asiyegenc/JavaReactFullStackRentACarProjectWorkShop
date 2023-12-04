package com.tobeto.rent_a_car.controllers;

import com.tobeto.rent_a_car.services.abstracts.CustomerService;

import com.tobeto.rent_a_car.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rent_a_car.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetAllCustomersResponse;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetCustomerResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public List<GetAllCustomersResponse> getAll() {
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        customerService.delete(id);
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest) {
        customerService.add(addCustomerRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        customerService.update(updateCustomerRequest);
    }
}


/*
 private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        List<Customer>customers=customerRepository.findAll();
        return customers;
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id){
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Customer customerToDelete=customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @PutMapping("{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer customer){
        Customer customerToUpdate=customerRepository.findById(id).orElseThrow();
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setAge(customerToUpdate.getAge());
        customerToUpdate.setPhone(customerToUpdate.getPhone());
        customerToUpdate.setEmail(customerToUpdate.getEmail());
        return customerRepository.save(customerToUpdate);
    }
 */
