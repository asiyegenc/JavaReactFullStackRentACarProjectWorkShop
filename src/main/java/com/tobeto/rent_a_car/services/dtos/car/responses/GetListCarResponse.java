package com.tobeto.rent_a_car.services.dtos.car.responses;

import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.entities.Color;
import com.tobeto.rent_a_car.entities.Price;
import com.tobeto.rent_a_car.entities.Type;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetListColorResponse;
import com.tobeto.rent_a_car.services.dtos.price.responses.GetListPriceResponse;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetListTypeResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCarResponse {
    private int id;
    private int modelYear;
    private String modelName;
    private String status;
    private GetListPriceResponse priceId;
    private GetListBrandResponse brandId;
    private GetListColorResponse colorId;
    private GetListTypeResponse typeId;
}
