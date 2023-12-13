package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository <Brand, Integer> {
    List<Brand> findByName(String name);

    @Query("Select new com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name) From Brand b")
    List<GetListBrandResponse> findByNameDto();

}