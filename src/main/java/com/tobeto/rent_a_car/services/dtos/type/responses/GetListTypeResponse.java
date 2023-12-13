package com.tobeto.rent_a_car.services.dtos.type.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListTypeResponse {
    private int id;
    private String name;
}
