package com.tobeto.rent_a_car.controllers;

import com.tobeto.rent_a_car.entities.Car;
import com.tobeto.rent_a_car.repositories.CarRepository;
import com.tobeto.rent_a_car.services.abstracts.CarService;
import com.tobeto.rent_a_car.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent_a_car.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rent_a_car.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rent_a_car.services.dtos.car.responses.GetCarResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {


    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<GetAllCarsResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest) {
        carService.add(addCarRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest updateCarRequest) {
        carService.update(updateCarRequest);
    }
}

  /*

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car) {
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Car car) {
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setModelYear(car.getModelYear());
        carToUpdate.setModelName(car.getModelName());
        carToUpdate.setStatus(car.getStatus());
        carToUpdate.setPrice(car.getPrice());
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setColor(car.getColor());
        carToUpdate.setType(car.getType());
        carRepository.save(carToUpdate);
    }
   */