package com.tobeto.rent_a_car.services.abstracts;

import com.tobeto.rent_a_car.entities.Type;
import com.tobeto.rent_a_car.services.dtos.type.requests.AddTypeRequest;
import com.tobeto.rent_a_car.services.dtos.type.requests.UpdateTypeRequest;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetAllTypesResponse;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetListTypeResponse;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetTypeResponse;

import java.util.List;

public interface TypeService {

    List<GetAllTypesResponse>getAll();

   // GetTypeResponse getById(int id);

    void delete(int id);

    void add(AddTypeRequest addTypeRequest);

    void update(UpdateTypeRequest updateTypeRequest);

    List<GetListTypeResponse>getByName(String name);

    Type getById(int id);
}