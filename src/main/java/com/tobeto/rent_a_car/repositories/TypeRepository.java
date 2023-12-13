package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Type;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetListTypeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository  <Type, Integer> {

    @Query("Select new com.tobeto.rent_a_car.services.dtos.type.responses.GetListTypeResponse(t.id, t.name) from Type t" )
    List<GetListTypeResponse>findByType(String name);
}
