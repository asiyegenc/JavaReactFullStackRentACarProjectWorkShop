package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Price;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetAllPricesResponse;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetListPriceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PriceRepository extends JpaRepository <Price, Integer> {

    @Query("SELECT new com.tobeto.rent_a_car.services.dtos.price.responses.GetListPriceResponse(p.id, p.hourlyFee, p.dailyFee, p.weeklyFee, p.mountlyFee)"+
            "FROM Price p ORDER BY p.hourlyFee Desc")
    List<GetListPriceResponse> getByDOrderByHourlyFee();

    @Query("SELECT new com.tobeto.rent_a_car.services.dtos.price.responses.GetListPriceResponse(p.id, p.hourlyFee, p.dailyFee, p.weeklyFee, p.mountlyFee)"+
            "FROM Price p ORDER BY p.dailyFee Desc")
    List<GetListPriceResponse> getByDOrderByDailyFee();

    @Query("SELECT new com.tobeto.rent_a_car.services.dtos.price.responses.GetListPriceResponse(p.id, p.hourlyFee, p.dailyFee, p.weeklyFee, p.mountlyFee)"+
            "FROM Price p ORDER BY p.weeklyFee Desc")
    List<GetListPriceResponse> getByDOrderByWeeklyFee();


}
