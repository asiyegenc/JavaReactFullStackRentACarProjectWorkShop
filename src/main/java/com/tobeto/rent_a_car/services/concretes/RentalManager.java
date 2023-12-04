package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.Rental;
import com.tobeto.rent_a_car.repositories.RentalRepository;
import com.tobeto.rent_a_car.services.abstracts.RentalService;
import com.tobeto.rent_a_car.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rent_a_car.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetRentalResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;

    public RentalManager(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<GetAllRentalsResponse> getAll() {

        List<Rental> rentalList = rentalRepository.findAll();
        List<GetAllRentalsResponse> getAllRentalsResponseList = new ArrayList<>();
        for (Rental rental : rentalList) {
            GetAllRentalsResponse getAllRentalsResponse = new GetAllRentalsResponse();
            getAllRentalsResponse.setId(rental.getId());
            getAllRentalsResponse.setRentalDate(rental.getRentalDate());
            getAllRentalsResponse.setReturnDate(rental.getReturnDate());
            getAllRentalsResponse.setCustomerId(rental.getCustomer());
            getAllRentalsResponse.setCarId(getAllRentalsResponse.getCarId());
            getAllRentalsResponse.setPaymentMethodId(getAllRentalsResponse.getPaymentMethodId());
        }
        return getAllRentalsResponseList;
    }

    @Override
    public GetRentalResponse getById(int id) {
        Rental rentalToId = rentalRepository.findById(id).orElseThrow();
        GetRentalResponse getRentalResponse = new GetRentalResponse();
        getRentalResponse.setRentalDate(rentalToId.getRentalDate());
        getRentalResponse.setReturnDate(rentalToId.getReturnDate());
        getRentalResponse.setCustomerId(rentalToId.getCustomer());
        getRentalResponse.setCarId(rentalToId.getCar());
        getRentalResponse.setPaymentMethodId(rentalToId.getPaymentMethod());
        return getRentalResponse;
    }

    @Override
    public void delete(int id) {
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);

    }

    @Override
    public void add(AddRentalRequest addRentalRequest) {
        Rental rental= new Rental();
        rental.setRentalDate(addRentalRequest.getRentalDate());
        rental.setReturnDate(addRentalRequest.getReturnDate());
        rental.setCustomer(addRentalRequest.getCustomerId());
        rental.setCar(addRentalRequest.getCarId());
        rental.setPaymentMethod(addRentalRequest.getPaymentMethodId());
        rentalRepository.save(rental);

    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest) {
        Rental rentalToUpdate=rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();
        rentalToUpdate.setRentalDate(updateRentalRequest.getRentalDate());
        rentalToUpdate.setReturnDate(updateRentalRequest.getReturnDate());
        rentalToUpdate.setCustomer(updateRentalRequest.getCustomerId());
        rentalToUpdate.setCar(updateRentalRequest.getCarId());
        rentalToUpdate.setPaymentMethod(updateRentalRequest.getPaymentMethodId());
        rentalRepository.save(rentalToUpdate);

    }
}
