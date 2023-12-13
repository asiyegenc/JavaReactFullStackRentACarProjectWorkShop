package com.tobeto.rent_a_car.controllers;

import com.tobeto.rent_a_car.services.abstracts.TypeService;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetRentalResponse;
import com.tobeto.rent_a_car.services.dtos.type.requests.AddTypeRequest;
import com.tobeto.rent_a_car.services.dtos.type.requests.UpdateTypeRequest;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetAllTypesResponse;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetListTypeResponse;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetTypeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/types")
public class TypesController {
    private final TypeService typeService;

    public TypesController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    List<GetAllTypesResponse>getAll(){
        return typeService.getAll();
    }

    /*@GetMapping("{id}")
    public GetTypeResponse getById(@PathVariable int id){
        return typeService.getById(id);
    }*/

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        typeService.delete(id);
    }

    @PostMapping
    public void add(@RequestBody AddTypeRequest addTypeRequest){
        typeService.add(addTypeRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateTypeRequest updateTypeRequest){
        typeService.update(updateTypeRequest);
    }

    @GetMapping("type")
    public List<GetListTypeResponse>getByType(String name){
        return typeService.getByName(name);
    }


}

/*
    private final TypeRepository typeRepository;

    public TypesController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping
    public List<Type> getAll() {
        List<Type>types=typeRepository.findAll();
        return types;
    }

    @GetMapping("{id}")
    public Type getById(@PathVariable int id){
        return typeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Type type){
        typeRepository.save(type);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Type typeToDelete = typeRepository.findById(id).orElseThrow();
        typeRepository.delete(typeToDelete);
    }

    @PutMapping("{id}")
    public Type update(@PathVariable int id, @RequestBody Type type){
        Type typeToUpdate=typeRepository.findById(id).orElseThrow();
        typeToUpdate.setName(type.getName());
        return typeRepository.save(typeToUpdate);

 */