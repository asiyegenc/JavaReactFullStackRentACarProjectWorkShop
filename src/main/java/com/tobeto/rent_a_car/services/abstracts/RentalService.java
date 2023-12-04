package com.tobeto.rent_a_car.services.abstracts;

import com.tobeto.rent_a_car.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rent_a_car.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetRentalResponse;

import java.util.List;

public  interface RentalService {

List<GetAllRentalsResponse>getAll();

GetRentalResponse getById(int id);

void delete(int id);

void add(AddRentalRequest addRentalRequest);

void update(UpdateRentalRequest updateRentalRequest);
}