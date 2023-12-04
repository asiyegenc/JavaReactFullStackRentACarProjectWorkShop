package com.tobeto.rent_a_car.controllers;

import com.tobeto.rent_a_car.services.abstracts.PriceService;
import com.tobeto.rent_a_car.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rent_a_car.services.dtos.price.requests.UpdatePriceRequest;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetAllPricesResponse;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetPriceResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prices")
public class PricesController {

    private final PriceService priceService;

    public PricesController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public List<GetAllPricesResponse>getAll(){
      return priceService.getAll();
    }

    @GetMapping("{id}")
    public GetPriceResponse getById(@PathVariable int id) {
        return priceService.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        priceService.delete(id);
    }


    @PostMapping
    public void add(@RequestBody AddPriceRequest addPriceRequest) {
        priceService.add(addPriceRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdatePriceRequest updatePriceRequest) {
        priceService.update(updatePriceRequest);
    }
}


/*

    private final PriceRepository priceRepository;

    public PricesController(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @GetMapping
    public List<Price> getAll() {
        List<Price> prices = priceRepository.findAll();
        return prices;
    }

    @GetMapping("{id}")
    public Price getById(@PathVariable int id) {
        return priceRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@PathVariable int id, @RequestBody Price price){
        priceRepository.save(price);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Price priceToDelete=priceRepository.findById(id).orElseThrow();
        priceRepository.delete(priceToDelete);
    }

    @PutMapping("{id}")
    public Price update(@PathVariable int id, @RequestBody Price price){
        Price priceToUpdate=priceRepository.findById(id).orElseThrow();
        priceToUpdate.setHourlyFee(price.getHourlyFee());
        priceToUpdate.setDailyFee(price.getDailyFee());
        priceToUpdate.setWeeklyFee(price.getWeeklyFee());
        priceToUpdate.setMountlyFee(price.getMountlyFee());
        return priceRepository.save(priceToUpdate);
    }
 */
