package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.Customer;
import com.tobeto.rent_a_car.repositories.CustomerRepository;
import com.tobeto.rent_a_car.services.abstracts.CustomerService;
import com.tobeto.rent_a_car.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rent_a_car.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetAllCustomersResponse;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetCustomerResponse;
import com.tobeto.rent_a_car.services.dtos.customer.responses.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<GetAllCustomersResponse> getAllCustomersResponseList = new ArrayList<>();
        for (Customer customer : customerList) {
            GetAllCustomersResponse getAllCustomersResponse = new GetAllCustomersResponse();
            getAllCustomersResponse.setId(customer.getId());
            getAllCustomersResponse.setFirstName(customer.getFirstName());
            getAllCustomersResponse.setLastName(customer.getLastName());
            getAllCustomersResponse.setAge(customer.getAge());
            getAllCustomersResponse.setPhone(customer.getPhone());
            getAllCustomersResponse.setEmail(customer.getEmail());
            getAllCustomersResponseList.add(getAllCustomersResponse);
        }
        return getAllCustomersResponseList;
    }
    /*
    @Override
    public GetCustomerResponse getById(int id) {
        Customer customerToId= customerRepository.findById(id).orElseThrow();
        GetCustomerResponse getCustomerResponse=new GetCustomerResponse();
        getCustomerResponse.setFirstName(customerToId.getFirstName());
        getCustomerResponse.setLastName(customerToId.getLastName());
        getCustomerResponse.setAge(customerToId.getAge());
        getCustomerResponse.setPhone(customerToId.getPhone());
        getCustomerResponse.setEmail(customerToId.getEmail());
        return getCustomerResponse;
    }*/

    @Override
    public void delete(int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);

    }

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {
        Customer customer = new Customer();
        customer.setFirstName(addCustomerRequest.getFirstName());
        customer.setLastName(addCustomerRequest.getLastName());
        customer.setAge(addCustomerRequest.getAge());
        customer.setPhone(addCustomerRequest.getPhone());
        customer.setEmail(addCustomerRequest.getEmail());
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customerToUpdate = customerRepository.findById(updateCustomerRequest.getId()).orElseThrow();
        customerToUpdate.setFirstName(updateCustomerRequest.getFirstName());
        customerToUpdate.setLastName(updateCustomerRequest.getLastName());
        customerToUpdate.setAge(updateCustomerRequest.getAge());
        customerToUpdate.setPhone(updateCustomerRequest.getPhone());
        customerToUpdate.setEmail(updateCustomerRequest.getEmail());
        customerRepository.save(customerToUpdate);
    }

    @Override
    public List<GetListCustomerResponse> getByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public List<GetListCustomerResponse> getByEmailLike(String email) {
        //return customerRepository.findByEmailLike(email);
        return customerRepository.findByEmailLike(email).stream().map((customer) -> {
            return new GetListCustomerResponse(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getPhone(), customer.getEmail());
        }).toList();
    }


    @Override
    public List<Customer> getByPhone(String phone) {
        //return customerRepository.findByPhone(phone);
        return customerRepository.findByPhone(phone).stream()
                .filter(customer -> customer.getPhone() != null)
                .toList();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }
}