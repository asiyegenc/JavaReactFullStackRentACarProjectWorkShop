package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.repositories.BrandRepository;
import com.tobeto.rent_a_car.services.abstracts.BrandService;
import com.tobeto.rent_a_car.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rent_a_car.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetAllBrandsResponse;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    public final BrandRepository brandRepository;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brandList = brandRepository.findAll();
        List<GetAllBrandsResponse> getAllBrandsResponseList = new ArrayList<>();
        for (Brand brand : brandList) {
            GetAllBrandsResponse getAllBrandsResponse = new GetAllBrandsResponse();
            getAllBrandsResponse.setId(brand.getId());
            getAllBrandsResponse.setName(brand.getName());
        }
        return getAllBrandsResponseList;
    }/*

@Override
    public GetBrandResponse getById(int id) {
        Brand brandToId = brandRepository.findById(id).orElseThrow();
        GetBrandResponse getBrandResponse= new GetBrandResponse();
        brandToId.setName(brandToId.getName());
        return getBrandResponse;
    }
*/

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    @Override
    public void add(AddBrandRequest addBrandRequest) {

        if (addBrandRequest.getName().length() < 2 || addBrandRequest.getName().length() > 50) {
            throw new IllegalArgumentException("Marka adı en az 3 karakter ve en fazla 50 karakter olmalıdır.");
        }

        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        if (updateBrandRequest.getId() <= 0 || updateBrandRequest.getId() > 1000) {
            throw new IllegalArgumentException("Brand ID pozitif bir değer olmalı ve 1 ile 1000 arasında olmalıdır.");
        }
        Brand brandToUpdate = brandRepository.findById(updateBrandRequest.getId()).orElseThrow();
        brandToUpdate.setName(updateBrandRequest.getName());
        brandRepository.save(brandToUpdate);
    }

    @Override
    public List<Brand> getByName(String name) {
        return brandRepository.findByName(name);
    }

    @Override
    public List<GetListBrandResponse> getByNameDto() {
        // return brandRepository.findByNameDto();
        return brandRepository.findByNameDto().stream()
                .sorted(Comparator.comparing(GetListBrandResponse::getName))
                .toList();
    }
}
