package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Rental;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetListColorResponse;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetListPriceResponse;
import com.tobeto.rent_a_car.services.dtos.rental.responses.GetListRentalResponse;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetListTypeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository  <Rental, Integer> {


    @Query("Select new com.tobeto.rent_a_car.services.dtos.rental.responses.GetListRentalResponse"+
    "(r.id, r.rentalDate, r.returnDate, com.tobeto.rent_a_car.services.dtos.customer.responses.GetListCustomerResponse"+
    "(cus.id, cus.firstName, cus.lastName, cus.age, cus.phone, cus.email), com.tobeto.rent_a_car.services.dtos.car.responses.GetListCarResponse"+
    "(c.id, c.modelYear, c.modelName, c.status, c.price, c.brand, c.color, c.type), com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetListPaymentMethod"+
    "(pm.id, pm.paymentType)) From Rental r "+
    "inner Join r.customer cus "+
    "inner join r.car c "+
    "inner join r.paymentMethod pm "+
    "Where r.rentalDate Between :rentalDate and :returnDate")
    List<GetListRentalResponse>getByDateBetween (@RequestParam LocalDate rentalDate, @RequestParam LocalDate returnDate);

    @Query("Select new com.tobeto.rent_a_car.services.dtos.rental.responses.GetListRentalResponse"+
            "(r.id, r.rentalDate, r.returnDate, com.tobeto.rent_a_car.services.dtos.customer.responses.GetListCustomerResponse"+
            "(cus.id, cus.firstName, cus.lastName, cus.age, cus.phone, cus.email), com.tobeto.rent_a_car.services.dtos.car.responses.GetListCarResponse"+
            "(c.id, c.modelYear, c.modelName, c.status, c.price, c.brand, c.color, c.type), com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetListPaymentMethod"+
            "(pm.id, pm.paymentType)) From Rental r "+
            "inner Join r.customer cus "+
            "inner join r.car c "+
            "inner join r.paymentMethod pm")
    List<GetListRentalResponse>getAllDto();
}