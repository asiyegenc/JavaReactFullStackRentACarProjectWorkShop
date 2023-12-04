package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.Price;
import com.tobeto.rent_a_car.repositories.PriceRepository;
import com.tobeto.rent_a_car.services.abstracts.PriceService;
import com.tobeto.rent_a_car.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rent_a_car.services.dtos.price.requests.UpdatePriceRequest;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetAllPricesResponse;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetPriceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceManager implements PriceService {

    private final PriceRepository priceRepository;

    public PriceManager(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<GetAllPricesResponse> getAll() {

        List<Price> priceList = priceRepository.findAll();
        List<GetAllPricesResponse> getAllPricesResponseList =new ArrayList<>();
        for (Price price : priceList) {
            GetAllPricesResponse getAllPricesResponse = new GetAllPricesResponse();
            getAllPricesResponse.setId(price.getId());
            getAllPricesResponse.setHourlyFee(price.getHourlyFee());
            getAllPricesResponse.setDailyFee(price.getDailyFee());
            getAllPricesResponse.setWeeklyFee(price.getWeeklyFee());
            getAllPricesResponse.setMountlyFee(price.getMountlyFee());
            getAllPricesResponseList.add(getAllPricesResponse);
        }
        return getAllPricesResponseList;
    }

    @Override
    public GetPriceResponse getById(int id) {
        Price priceToId=priceRepository.findById(id).orElseThrow();
        GetPriceResponse getPriceResponse=new GetPriceResponse();
        getPriceResponse.setHourlyFee(priceToId.getHourlyFee());
        getPriceResponse.setDailyFee(priceToId.getDailyFee());
        getPriceResponse.setWeeklyFee(priceToId.getWeeklyFee());
        getPriceResponse.setMountlyFee(priceToId.getMountlyFee());
        return getPriceResponse;
    }

    @Override
    public void delete(int id) {
        Price priceToDelete = priceRepository.findById(id).orElseThrow();
        priceRepository.delete(priceToDelete);

    }

    @Override
    public void add(AddPriceRequest addPriceRequest) {
        Price price=new Price();
        price.setHourlyFee(addPriceRequest.getHourlyFee());
        price.setDailyFee(addPriceRequest.getDailyFee());
        price.setWeeklyFee(addPriceRequest.getWeeklyFee());
        price.setMountlyFee(addPriceRequest.getMountlyFee());
        priceRepository.save(price);
    }

    @Override
    public void update(UpdatePriceRequest updatePriceRequest) {
        Price priceToUpdate=priceRepository.findById(updatePriceRequest.getId()).orElseThrow();
        priceToUpdate.setHourlyFee(updatePriceRequest.getHourlyFee());
        priceToUpdate.setDailyFee(updatePriceRequest.getDailyFee());
        priceToUpdate.setWeeklyFee(updatePriceRequest.getWeeklyFee());
        priceToUpdate.setMountlyFee(updatePriceRequest.getMountlyFee());
        priceRepository.save(priceToUpdate);
    }
}
