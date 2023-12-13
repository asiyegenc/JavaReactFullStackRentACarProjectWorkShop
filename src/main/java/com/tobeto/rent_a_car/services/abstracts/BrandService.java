package com.tobeto.rent_a_car.services.abstracts;

import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rent_a_car.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetAllBrandsResponse;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetBrandResponse;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

   // GetBrandResponse getById(int id);

    void delete(int id);

    void add(AddBrandRequest brandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    List<Brand> getByName(String name);

    List<GetListBrandResponse> getByNameDto();

    Brand getById(int id);
}