package com.tobeto.rent_a_car.services.abstracts;

import com.tobeto.rent_a_car.entities.Car;
import com.tobeto.rent_a_car.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent_a_car.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rent_a_car.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rent_a_car.services.dtos.car.responses.GetCarResponse;
import com.tobeto.rent_a_car.services.dtos.car.responses.GetListCarResponse;

import java.util.List;

public interface CarService {

    List<GetAllCarsResponse> getAll();

    //GetCarResponse getById(int id);

    void delete(int id);

    void add(AddCarRequest addCarRequest);

    void update(UpdateCarRequest updateCarRequest);

    List<Car> getByModelName(String modelName);

    List<GetListCarResponse> getByStatus();

    List<GetListCarResponse> getByOrderBymodelYear();

    List<GetListCarResponse> getByBrandAndModelName();

    Car getById(int id);
}

