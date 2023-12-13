package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.Car;
import com.tobeto.rent_a_car.entities.Customer;
import com.tobeto.rent_a_car.entities.PaymentMethod;
import com.tobeto.rent_a_car.entities.Rental;
import com.tobeto.rent_a_car.repositories.RentalRepository;
import com.tobeto.rent_a_car.services.abstracts.CarService;
import com.tobeto.rent_a_car.services.abstracts.CustomerService;
import com.tobeto.rent_a_car.services.abstracts.PaymentMethodService;
import com.tobeto.rent_a_car.services.abstracts.RentalService;
import com.tobeto.rent_a_car.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rent_a_car.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetListRentalResponse;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final CustomerService customerService;
    private final CarService carService;
    private final PaymentMethodService paymentMethodService;

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

        if (addRentalRequest.getRentalDate() == null || addRentalRequest.getReturnDate().isBefore(addRentalRequest.getRentalDate())) {
            throw new IllegalArgumentException("İade tarihi boş olamaz ve kiralama tarihinden önce olamaz.");
        }


        Rental rental = new Rental();
        rental.setRentalDate(addRentalRequest.getRentalDate());
        rental.setReturnDate(addRentalRequest.getReturnDate());
        //rental.setCustomer(addRentalRequest.getCustomerId());
        //rental.setCar(addRentalRequest.getCarId());
        Customer customer = customerService.getById(addRentalRequest.getCustomerId());
        rental.setCustomer(customer);

        Car car = carService.getById(addRentalRequest.getCarId());
        rental.setCar(car);

        PaymentMethod paymentMethod = paymentMethodService.getById(addRentalRequest.getPaymentMethodId());
        rental.setCar(car);

        rentalRepository.save(rental);

    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest) {
        Rental rentalToUpdate = rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();
        rentalToUpdate.setRentalDate(updateRentalRequest.getRentalDate());
        rentalToUpdate.setReturnDate(updateRentalRequest.getReturnDate());
        //rentalToUpdate.setCustomer(updateRentalRequest.getCustomerId());
        Customer customer = customerService.getById(updateRentalRequest.getCustomerId());
        rentalToUpdate.setCustomer(customer);

        Car car = carService.getById(updateRentalRequest.getCarId());
        rentalToUpdate.setCar(car);

        PaymentMethod paymentMethod = paymentMethodService.getById(updateRentalRequest.getPaymentMethodId());
        rentalToUpdate.setCar(car);

        rentalRepository.save(rentalToUpdate);

    }


    @Override
    public List<GetListRentalResponse> getAllDto() {
        return rentalRepository.findAll().stream().map(rental -> new GetListRentalResponse(rental)).toList();
    }

    @Override
    public List<GetListRentalResponse> getByDateBetween(LocalDate rentalDate, LocalDate returnDate) {
        //return rentalRepository.getByDateBetween(rentalDate, returnDate);
        return rentalRepository.getByDateBetween(rentalDate, returnDate).stream()
                .sorted(Comparator.comparing(GetListRentalResponse::getRentalDate))
                .toList();

    }
}
