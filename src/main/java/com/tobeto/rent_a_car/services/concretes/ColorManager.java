package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.Color;
import com.tobeto.rent_a_car.repositories.ColorRepository;
import com.tobeto.rent_a_car.services.abstracts.ColorService;
import com.tobeto.rent_a_car.services.dtos.color.requests.AddColorRequest;
import com.tobeto.rent_a_car.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetAllColorsResponse;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetListColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private final ColorRepository colorRepository;

    @Override
    public List<GetAllColorsResponse> getAll() {
        List<Color> colorList = colorRepository.findAll();
        List<GetAllColorsResponse> getAllColorsResponsesList = new ArrayList<>();
        for (Color color : colorList) {
            GetAllColorsResponse getAllColorsResponse = new GetAllColorsResponse();
            getAllColorsResponse.setId(color.getId());
            getAllColorsResponse.setColor(color.getColor());
        }
        return getAllColorsResponsesList;
    }


    /*
    @Override
    public GetColorResponse getById(int id) {
        Color colorToId = colorRepository.findById(id).orElseThrow();
        GetColorResponse getColorResponse=new GetColorResponse();
        getColorResponse.setColor(colorToId.getColor());
        return getColorResponse;
    }
    */

    @Override
    public Color getById(int id) {
        return colorRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(AddColorRequest addColorRequest) {

    }

    @Override
    public void update(UpdateColorRequest colorRequest) {

    }

    @Override
    public List<GetListColorResponse> getByColorIdDto(String color) {
        //return colorRepository.findByColorIdDto(color);
        return colorRepository.findByColorIdDto(color).stream()
                .sorted(Comparator.comparing(GetListColorResponse::getId))
                .toList();
    }
}
