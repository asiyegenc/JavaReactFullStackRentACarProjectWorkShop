package com.tobeto.rent_a_car.services.abstracts;

import com.tobeto.rent_a_car.entities.Color;
import com.tobeto.rent_a_car.services.dtos.color.requests.AddColorRequest;
import com.tobeto.rent_a_car.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetAllColorsResponse;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetColorResponse;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetListColorResponse;

import java.util.List;

public interface ColorService {

    List<GetAllColorsResponse> getAll();

    //GetColorResponse getById(int id);

    void delete(int id);

    void add(AddColorRequest addColorRequest);

    void update(UpdateColorRequest colorRequest);

    List<GetListColorResponse> getByColorIdDto(String color);

    Color getById(int id);
}