package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.entities.Car;
import com.tobeto.rent_a_car.entities.Color;
import com.tobeto.rent_a_car.entities.Type;
import com.tobeto.rent_a_car.repositories.CarRepository;
import com.tobeto.rent_a_car.services.abstracts.BrandService;
import com.tobeto.rent_a_car.services.abstracts.CarService;
import com.tobeto.rent_a_car.services.abstracts.ColorService;
import com.tobeto.rent_a_car.services.abstracts.TypeService;
import com.tobeto.rent_a_car.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent_a_car.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rent_a_car.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rent_a_car.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor

public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final BrandService brandService;
    private final ColorService colorService;
    private final TypeService typeService;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> carList = carRepository.findAll();
        List<GetAllCarsResponse> getAllCarsResponseList = new ArrayList<>();
        for (Car car : carList) {
            GetAllCarsResponse getAllCarsResponse = new GetAllCarsResponse();
            getAllCarsResponse.setId(car.getId());
            getAllCarsResponse.setBrand(car.getBrand());
            getAllCarsResponse.setModelName(car.getModelName());
            getAllCarsResponse.setModelYear(car.getModelYear());
            getAllCarsResponse.setColor(car.getColor());
            getAllCarsResponse.setType(car.getType());
            getAllCarsResponse.setPrice(car.getPrice());
            getAllCarsResponse.setStatus(car.getStatus());
            getAllCarsResponseList.add(getAllCarsResponse);
        }
        return getAllCarsResponseList;
    }
    /*
    @Override
    public GetCarResponse getById(int id) {
        Car carToId = carRepository.findById(id).orElseThrow();
        GetCarResponse getCarResponse = new GetCarResponse();
        getCarResponse.setBrand(carToId.getBrand());
        getCarResponse.setModelName(carToId.getModelName());
        getCarResponse.setModelYear(carToId.getModelYear());
        getCarResponse.setColor(carToId.getColor());
        getCarResponse.setType(carToId.getType());
        getCarResponse.setPrice(carToId.getPrice());
        getCarResponse.setStatus(carToId.getStatus());
        return getCarResponse;
    }*/

    @Override
    public void delete(int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @Override
    public void add(AddCarRequest addCarRequest) {

        if (addCarRequest.getBrandId() <= 0) {
            throw new IllegalArgumentException("Marka ID pozitif bir değer olmalıdır.");
        }

        if (addCarRequest.getColorId() < 1 || addCarRequest.getColorId() > 100) {
            throw new IllegalArgumentException("Type id 1 ile 100 arasında olmalıdır.");
        }
        Car car = new Car();
        car.setModelName(addCarRequest.getModelName());
        car.setModelYear(addCarRequest.getModelYear());
        //car.setBrand(addCarRequest.getBrandId());
        Brand brand = brandService.getById(addCarRequest.getBrandId());
        car.setBrand(brand);

        Color color = colorService.getById(addCarRequest.getColorId());
        car.setColor(color);

        Type type = typeService.getById(addCarRequest.getTypeId());
        car.setType(type);
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {

        if (updateCarRequest.getModelName().length() > 1) {
            throw new RuntimeException("Model adı en az 2 karakter olmalıdır.");

        }
        if (updateCarRequest.getTypeId() < 1 || updateCarRequest.getTypeId() > 10) {
            throw new IllegalArgumentException("Type id 1 ile 10 arasında olmalıdır.");
        }

        Car car = new Car();
        car.setModelName(updateCarRequest.getModelName());
        car.setModelYear(updateCarRequest.getModelYear());
        Color color = colorService.getById(updateCarRequest.getColorId());
        car.setColor(color);
        Type type = typeService.getById(updateCarRequest.getTypeId());
        car.setType(type);
        carRepository.save(car);
    }

    @Override
    public List<Car> getByModelName(String modelName) {
        return carRepository.findByModelName(modelName);
    }

    @Override
    public List<GetListCarResponse> getByStatus() {
        //return carRepository.findByStatus();
        return carRepository.findByStatus().stream().map((car) -> {
            return new GetListCarResponse(car.getId(), car.getModelYear(), car.getModelName(), car.getStatus(), car.getPriceId(), car.getBrandId(), car.getColorId(), car.getTypeId());
        }).toList();
    }

    @Override
    public List<GetListCarResponse> getByOrderBymodelYear() {
        //return  carRepository.findByOrderBymodelYear();
        return carRepository.findByOrderBymodelYear().stream()
                .sorted(Comparator.comparing(GetListCarResponse::getModelYear))
                .toList();
    }


    @Override
    public List<GetListCarResponse> getByBrandAndModelName() {
        //return carRepository.getByBrandAndModelName();
        return carRepository.getByBrandAndModelName().stream()
                .filter((car) -> car.getModelName().length() < 5)
                .toList();
    }

    @Override
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow();
    }
}
