package com.tobeto.rent_a_car.services.dtos.rental.responses;

import com.tobeto.rent_a_car.entities.Car;
import com.tobeto.rent_a_car.entities.Customer;
import com.tobeto.rent_a_car.entities.PaymentMethod;
import com.tobeto.rent_a_car.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentalResponse {
    private int id;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private int customerId;
    private int  carId;
    private int paymentMethodId;
   public GetListRentalResponse(Rental rental){
        this.carId=rental.getCar().getId();
        this.customerId=rental.getCustomer().getId();
        this.rentalDate=rental.getRentalDate();
        this.returnDate=rental.getReturnDate();
        this.paymentMethodId=rental.getPaymentMethod().getId();
    }
}
