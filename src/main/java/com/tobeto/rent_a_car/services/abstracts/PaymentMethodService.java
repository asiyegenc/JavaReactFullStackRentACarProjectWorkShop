package com.tobeto.rent_a_car.services.abstracts;

import com.tobeto.rent_a_car.entities.PaymentMethod;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.requests.AddPaymentMethodRequest;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.requests.UpdatePaymentMethodRequest;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetAllPaymentMethodsResponse;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetListPaymentMethodResponse;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetPaymentMethodResponse;

import java.util.List;

public interface PaymentMethodService {

    List<GetAllPaymentMethodsResponse> getAll();

    //GetPaymentMethodResponse getById(int id);

    void delete (int id);

    void add(AddPaymentMethodRequest addPaymentMethodRequest);

    void update(UpdatePaymentMethodRequest updatePaymentMethodRequest);

    List<GetListPaymentMethodResponse>getByPaymentTypeLike(String paymentType);

    PaymentMethod getById(int id);
}