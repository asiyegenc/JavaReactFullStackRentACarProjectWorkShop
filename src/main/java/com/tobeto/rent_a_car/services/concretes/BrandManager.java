package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.repositories.BrandRepository;
import com.tobeto.rent_a_car.services.abstracts.BrandService;
import com.tobeto.rent_a_car.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rent_a_car.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetAllBrandsResponse;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetBrandResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {

    public final BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

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
    }

@Override
    public GetBrandResponse getById(int id) {
        Brand brandToId = brandRepository.findById(id).orElseThrow();
        GetBrandResponse getBrandResponse= new GetBrandResponse();
        brandToId.setName(brandToId.getName());
        return getBrandResponse;
    }

    @Override
    public void delete(int id) {
        Brand brandToDelete= brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    @Override
    public void add(AddBrandRequest addBrandRequest) {
        Brand brand=new Brand();
        brand.setName(addBrandRequest.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brandToUpdate = brandRepository.findById(updateBrandRequest.getId()).orElseThrow();
        brandToUpdate.setName(updateBrandRequest.getName());
        brandRepository.save(brandToUpdate);
    }
}
