package com.tobeto.rent_a_car.controllers;

import com.tobeto.rent_a_car.services.abstracts.ColorService;
import com.tobeto.rent_a_car.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent_a_car.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rent_a_car.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rent_a_car.services.dtos.car.responses.GetCarResponse;
import com.tobeto.rent_a_car.services.dtos.color.requests.AddColorRequest;
import com.tobeto.rent_a_car.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetAllColorsResponse;
import com.tobeto.rent_a_car.services.dtos.color.responses.GetColorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //http isteklerine yanıt verir
@RequestMapping("api/colors") //colors tablonun adı
public class ColorsController {
    private final ColorService colorService;

    public ColorsController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public List<GetAllColorsResponse> getAll() {
        return colorService.getAll();
    }

    @GetMapping("{id}")
    public GetColorResponse getById(@PathVariable int id) {
        return colorService.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        colorService.delete(id);
    }
    @PostMapping
    public void add(@RequestBody AddColorRequest addColorRequest) {
        colorService.add(addColorRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateColorRequest updateColorRequest) {
        colorService.update(updateColorRequest);
    }
}


/*

    private final ColorRepository colorRepository; //veritabanı işl yapabilmek için ColorRepositorye bağımlı old gösterir
    public ColorsController(ColorRepository colorRepository){
        this.colorRepository=colorRepository;
    }

    @GetMapping
    public List<Color> getAll(){
        List<Color>colors=colorRepository.findAll();
        return colors;
    }

    @GetMapping("{id}")
    public Color getById (@PathVariable int id) {
        return colorRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Color color){
        colorRepository.save(color);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Color colorToDelete=colorRepository.findById(id).orElseThrow();
    }

    @PutMapping("{id}")
    public Color update(@PathVariable int id, @RequestBody Color color){
        Color colorToUpdate=colorRepository.findById(id).orElseThrow();
        colorToUpdate.setColor(color.getColor());
        return colorRepository.save(colorToUpdate);
    }
 */
