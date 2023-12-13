package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.entities.Color;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetListColorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository <Color, Integer> {

    @Query("Select new com.tobeto.rent_a_car.services.dtos.color.responses.GetListColorResponse(col.id, col.color) From Color col")
    List<GetListColorResponse> findByColorIdDto(String color);
}
