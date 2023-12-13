package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.PaymentMethod;
import com.tobeto.rent_a_car.repositories.PaymentMethodRepository;
import com.tobeto.rent_a_car.services.abstracts.PaymentMethodService;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.requests.AddPaymentMethodRequest;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.requests.UpdatePaymentMethodRequest;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetAllPaymentMethodsResponse;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetListPaymentMethodResponse;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetPaymentMethodResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentMethodManager implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<GetAllPaymentMethodsResponse> getAll() {
        List<PaymentMethod> paymentMethodList = paymentMethodRepository.findAll();
        List<GetAllPaymentMethodsResponse> getAllPaymentMethodsResponseList = new ArrayList<>();
        for (PaymentMethod paymentMethod : paymentMethodList) {
            GetAllPaymentMethodsResponse getAllPaymentMethodsResponse = new GetAllPaymentMethodsResponse();
            getAllPaymentMethodsResponse.setId(paymentMethod.getId());
            getAllPaymentMethodsResponse.setPaymentType(paymentMethod.getPaymentType());
            getAllPaymentMethodsResponse.setCardHolderName(paymentMethod.getCardHolderName());
            getAllPaymentMethodsResponse.setCardNumber(paymentMethod.getCardNumber());
            getAllPaymentMethodsResponse.setCvv(paymentMethod.getCvv());
            getAllPaymentMethodsResponse.setCustomerId(getAllPaymentMethodsResponse.getCustomerId());
            getAllPaymentMethodsResponseList.add(getAllPaymentMethodsResponse);
        }
        return getAllPaymentMethodsResponseList;
    }
    /*
    @Override
    public GetPaymentMethodResponse getById(int id) {
        PaymentMethod paymentMethodToId=paymentMethodRepository.findById(id).orElseThrow();
        GetPaymentMethodResponse getPaymentMethodResponse=new GetPaymentMethodResponse();
        getPaymentMethodResponse.setPaymentType(paymentMethodToId.getPaymentType());
        getPaymentMethodResponse.setCardHolderName(paymentMethodToId.getCardHolderName());
        getPaymentMethodResponse.setCardNumber(paymentMethodToId.getCardNumber());
        getPaymentMethodResponse.setCvv(paymentMethodToId.getCvv());
        getPaymentMethodResponse.setCustomerId(paymentMethodToId.getCustomer());
        return getPaymentMethodResponse;
    }*/

    @Override
    public void delete(int id) {
        PaymentMethod paymentMethodToDelete = paymentMethodRepository.findById(id).orElseThrow();
        paymentMethodRepository.delete(paymentMethodToDelete);
    }

    @Override
    public void add(AddPaymentMethodRequest addPaymentMethodRequest) {

        if (addPaymentMethodRequest.getPaymentType() == null || addPaymentMethodRequest.getPaymentType().trim().isEmpty()) {
            throw new IllegalArgumentException("Ödeme tipi boş bırakılmamalıdır");
        }

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentType(addPaymentMethodRequest.getPaymentType());
        /*paymentMethod.setCardHolderName(addPaymentMethodRequest.getCardHolderName());
        paymentMethod.setCardNumber(addPaymentMethodRequest.getCardNumber());
        paymentMethod.setExpirationDate(addPaymentMethodRequest.getExpirationDate());
        paymentMethod.setCvv(addPaymentMethodRequest.getCvv());
        paymentMethod.setCustomer(addPaymentMethodRequest.getCustomerId());*/
        paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void update(UpdatePaymentMethodRequest updatePaymentMethodRequest) {


        PaymentMethod paymentMethodToUpdate = paymentMethodRepository.findById(updatePaymentMethodRequest.getId()).orElseThrow();
        updatePaymentMethodRequest.setPaymentType(updatePaymentMethodRequest.getPaymentType());
      /*updatePaymentMethodRequest.setCardHolderName(updatePaymentMethodRequest.getCardHolderName());
      updatePaymentMethodRequest.setCardNumber(updatePaymentMethodRequest.getCardNumber());
      updatePaymentMethodRequest.setExpirationDate(updatePaymentMethodRequest.getExpirationDate());
      updatePaymentMethodRequest.setCvv(updatePaymentMethodRequest.getCvv());
      updatePaymentMethodRequest.setCustomerId(updatePaymentMethodRequest.getCustomerId());*/
        paymentMethodRepository.save(paymentMethodToUpdate);
    }

    @Override
    public List<GetListPaymentMethodResponse> getByPaymentTypeLike(String paymentType) {
        //return paymentMethodRepository.getByPaymentTypeLike(paymentType);
        return paymentMethodRepository.getByPaymentTypeLike(paymentType).stream().map((paymentMethod) -> {
            return new GetListPaymentMethodResponse(paymentMethod.getId(), paymentMethod.getPaymentType());
        }).toList();
    }

    @Override
    public PaymentMethod getById(int id) {
        return paymentMethodRepository.findById(id).orElseThrow();
    }
}
