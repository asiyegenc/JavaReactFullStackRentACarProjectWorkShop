package com.tobeto.rent_a_car.services.abstracts;

import com.tobeto.rent_a_car.services.dtos.color.requests.AddColorRequest;
import com.tobeto.rent_a_car.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetAllColorsResponse;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetColorResponse;

import java.util.List;

public interface ColorService {

    List<GetAllColorsResponse> getAll();

    GetColorResponse getById(int id);

    void delete(int id);

    void add(AddColorRequest addColorRequest);

    void update(UpdateColorRequest colorRequest);
}