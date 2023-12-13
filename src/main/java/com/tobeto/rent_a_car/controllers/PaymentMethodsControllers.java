package com.tobeto.rent_a_car.controllers;

import com.tobeto.rent_a_car.services.abstracts.PaymentMethodService;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.requests.AddPaymentMethodRequest;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.requests.UpdatePaymentMethodRequest;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetAllPaymentMethodsResponse;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetListPaymentMethodResponse;
import com.tobeto.rent_a_car.services.dtos.paymentMethod.responses.GetPaymentMethodResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment_methods")
public class PaymentMethodsControllers {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodsControllers(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }


    @GetMapping
    public List<GetAllPaymentMethodsResponse> getAll() {
        return paymentMethodService.getAll();
    }

  /*  @GetMapping("{id}")
    public GetPaymentMethodResponse getById(@PathVariable int id) {
        return paymentMethodService.getById(id);
    }*/

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        paymentMethodService.delete(id);
    }

    @PostMapping
    public void add(@RequestBody AddPaymentMethodRequest addPaymentMethodRequest) {
        paymentMethodService.add(addPaymentMethodRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        paymentMethodService.update(updatePaymentMethodRequest);
    }

    @GetMapping("paymentType")
    public List<GetListPaymentMethodResponse>getByPaymentType(String paymentType){
        return paymentMethodService.getByPaymentTypeLike(paymentType);
    }
}

/*

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodsControllers(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @GetMapping
    public List<PaymentMethod> getAll() {
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        return paymentMethods;
    }

    @GetMapping("{id}")
    public PaymentMethod getById(@PathVariable int id){
     return  paymentMethodRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody PaymentMethod paymentMethod){
        paymentMethodRepository.save(paymentMethod);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        PaymentMethod paymentMethodToDelete=paymentMethodRepository.findById(id).orElseThrow();
        paymentMethodRepository.delete(paymentMethodToDelete);
    }

    @PutMapping("{id}")
    public PaymentMethod update(@PathVariable int id, @RequestBody PaymentMethod paymentMethod){
       PaymentMethod paymentMethodToUpdate=paymentMethodRepository.findById(id).orElseThrow();
       paymentMethodToUpdate.setPaymentType(paymentMethod.getPaymentType());
       paymentMethodToUpdate.setCardHolderName(paymentMethod.getCardHolderName());
       paymentMethodToUpdate.setCardNumber(paymentMethod.getCardNumber());
       paymentMethodToUpdate.setExpirationDate(paymentMethod.getExpirationDate());
       paymentMethodToUpdate.setCvv(paymentMethod.getCvv());
       paymentMethodToUpdate.setCustomer(paymentMethod.getCustomer());
       return  paymentMethodRepository.save(paymentMethodToUpdate);
    }
 */
