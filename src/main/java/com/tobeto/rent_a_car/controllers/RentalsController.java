package com.tobeto.rent_a_car.controllers;

import com.tobeto.rent_a_car.services.abstracts.RentalService;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetAllPricesResponse;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetPriceResponse;
import com.tobeto.rent_a_car.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rent_a_car.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetRentalResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    private final RentalService rentalService;

    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<GetAllRentalsResponse>getAll(){
        return rentalService.getAll();
    }

    @GetMapping("{id}")
    public GetRentalResponse getById(int id){
        return rentalService.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalService.delete(id);
    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest addRentalRequest){
        rentalService.add(addRentalRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentalRequest updateRentalRequest){
        rentalService.update(updateRentalRequest);
    }
}

/*

    private final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping
    public List<Rental>getAll(){
    List<Rental>rentals=rentalRepository.findAll();
    return rentals;
    }

    @GetMapping("{id}")
    public Rental getById(@PathVariable int id){
        return rentalRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rental rental){
        rentalRepository.save(rental);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Rental rentalToDelete=rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @PutMapping("{id}")
    public Rental update(@PathVariable int id, @RequestBody Rental rental){
        Rental rentalToUpdate=rentalRepository.findById(id).orElseThrow();
        rentalToUpdate.setRentalDate(rental.getRentalDate());
        rentalToUpdate.setReturnDate(rental.getReturnDate());
        rentalToUpdate.setCustomer(rentalToUpdate.getCustomer());
        rentalToUpdate.setCar(rental.getCar());
        rentalToUpdate.setPaymentMethod(rental.getPaymentMethod());
        return rentalRepository.save(rental);
    }
 */