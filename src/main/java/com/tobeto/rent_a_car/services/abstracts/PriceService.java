package com.tobeto.rent_a_car.services.abstracts;

import com.tobeto.rent_a_car.entities.Price;
import com.tobeto.rent_a_car.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rent_a_car.services.dtos.price.requests.UpdatePriceRequest;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetAllPricesResponse;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetListPriceResponse;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetPriceResponse;

import java.util.List;

public interface PriceService {

  List<GetAllPricesResponse>getAll();

  GetPriceResponse getById(int id);

  void delete(int id);

  void add(AddPriceRequest addPriceRequest);

  void update(UpdatePriceRequest updatePriceRequest);

  List<GetListPriceResponse> getByOrderByHourlyFee(Double hourlyFee);
  List<GetListPriceResponse> getByOrderByDailyFee(Double dailyFee);
  List<GetListPriceResponse> getByOrderByWeeklyFee(Double weeklyFee);


}