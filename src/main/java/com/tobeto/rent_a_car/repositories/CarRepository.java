package com.tobeto.rent_a_car.repositories;

import com.tobeto.rent_a_car.entities.Car;
import com.tobeto.rent_a_car.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CarRepository extends JpaRepository <Car, Integer> {
    List<Car> findByModelName(String modelName);


    @Query("SELECT new com.tobeto.rent_a_car.services.dtos.car.responses.GetListCarResponse(" +
            "c.id, c.modelYear, c.modelName, c.status, " +
            "new com.tobeto.rent_a_car.services.dtos.price.responses.GetListPriceResponse(" +
            "p.id, p.hourlyFee, p.dailyFee, p.weeklyFee, p.mountlyFee)," +
            "new com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name)," +
            "new com.tobeto.rent_a_car.services.dtos.color.responses.GetListColorResponse(col.id, col.color)," +
            "new com.tobeto.rent_a_car.services.dtos.type.responses.GetListTypeResponse(t.id, t.name)) " +
            "FROM Car c " +
            "INNER JOIN c.price p " +
            "INNER JOIN c.brand b " +
            "INNER JOIN c.color col " +
            "INNER JOIN c.type t " +
            "WHERE c.status = 'Available'")

    List<GetListCarResponse> findByStatus();

    @Query("SELECT new com.tobeto.rent_a_car.services.dtos.car.responses.GetListCarResponse(" +
            "c.id, c.modelYear, c.modelName, c.status, " +
            "new com.tobeto.rent_a_car.services.dtos.price.responses.GetListPriceResponse(" +
            "p.id, p.hourlyFee, p.dailyFee, p.weeklyFee, p.mountlyFee)," +
            "new com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name)," +
            "new com.tobeto.rent_a_car.services.dtos.color.responses.GetListColorResponse(col.id, col.color)," +
            "new com.tobeto.rent_a_car.services.dtos.type.responses.GetListTypeResponse(t.id, t.name)) " +
            "FROM Car c " +
            "INNER JOIN c.price p " +
            "INNER JOIN c.brand b " +
            "INNER JOIN c.color col " +
            "INNER JOIN c.type t " +
            "ORDER BY c.modelYear DESC")

    List<GetListCarResponse>findByOrderBymodelYear();

    @Query("SELECT new com.tobeto.rent_a_car.services.dtos.car.responses.GetListCarResponse(" +
            "c.id, c.modelYear, c.modelName, c.status, " +
            "new com.tobeto.rent_a_car.services.dtos.price.responses.GetListPriceResponse(" +
            "p.id, p.hourlyFee, p.dailyFee, p.weeklyFee, p.mountlyFee)," +
            "new com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name)," +
            "new com.tobeto.rent_a_car.services.dtos.color.responses.GetListColorResponse(col.id, col.color)," +
            "new com.tobeto.rent_a_car.services.dtos.type.responses.GetListTypeResponse(t.id, t.name)) " +
            "FROM Car c " +
            "INNER JOIN c.price p " +
            "INNER JOIN c.brand b " +
            "INNER JOIN c.color col " +
            "INNER JOIN c.type t")
    List<GetListCarResponse> getByBrandAndModelName();


  /*
   @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetListCarResponse" +
            " (c.id, c.brand, c.model, c.year, c.color, c.status, new com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse(cat.id, cat.name))" +
            "FROM Car c INNER JOIN c.category cat WHERE c.year > 2020 ORDER BY c.year DESC")
    List<GetListCarResponse> findOrderByYear();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetListCarResponse" +
            " (c.id, c.brand, c.model, c.year, c.color, c.status, new com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse(cat.id, cat.name))" +
            "FROM Car c INNER JOIN c.category cat WHERE c.brand = 'Fiat' AND c.color = 'Black' ")
    List<GetListCarResponse> findByBrandAndColor();
   */

}
