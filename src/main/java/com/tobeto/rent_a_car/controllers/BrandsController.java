package com.tobeto.rent_a_car.controllers;

import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.services.abstracts.BrandService;
import com.tobeto.rent_a_car.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rent_a_car.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetAllBrandsResponse;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetBrandResponse;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.rent_a_car.services.dtos.car.requests.UpdateCarRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
//Bu classın sorumluluğu gelen isteği kontrol etmek ve yönlendirmek

    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
        //clasın BrandService bağımlılığını yaptık ve sonra yapıcı bloğunu oluşturduk.
    }
    @GetMapping
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        brandService.delete(id);
    }
    @PostMapping
    public void add(@RequestBody AddBrandRequest addBrandRequest){
        brandService.add(addBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        brandService.update(updateBrandRequest);
    }

    @GetMapping("name")
    public List<Brand>getByName(@RequestParam String name){
        return brandService.getByName(name);
    }

    @GetMapping("namedto")
    public List<GetListBrandResponse>getByNameDto(){
        return brandService.getByNameDto();
    }
}


/*
 private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping  // entitilerin direk dışarıya açılması yanlış
    public List<Brand> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }  //bunu  yerine DTO nesneleri kullanılmalı

    @GetMapping("{id}")
    public Brand getById (@PathVariable int id) {
        return brandRepository.findById(id).orElseThrow();
        //Optional => Optional olarak Brand
        //Verilen id ile bir veri varsa (@PathVariable int id kısmı bunu dememizi sağlar) onu döndür, yoksa exception fırlat.
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Brand brandToDelete=brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    @PutMapping("{id}")
    public Brand update(@PathVariable int id, @RequestBody Brand brand){
        Brand brandToUpdate = brandRepository.findById(id).orElseThrow();
        brandToUpdate.setName(brand.getName());
        return brandRepository.save(brandToUpdate);
    }
 */