package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.Type;
import com.tobeto.rent_a_car.repositories.TypeRepository;
import com.tobeto.rent_a_car.services.abstracts.TypeService;
import com.tobeto.rent_a_car.services.dtos.type.requests.AddTypeRequest;
import com.tobeto.rent_a_car.services.dtos.type.requests.UpdateTypeRequest;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetAllTypesResponse;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetListTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TypeManager implements TypeService {

    private final TypeRepository typeRepository;

    @Override
    public List<GetAllTypesResponse> getAll() {
        List<Type> typeList = typeRepository.findAll();
        List<GetAllTypesResponse> getAllTypesResponseList = new ArrayList<>();
        for (Type type : typeList) {
            GetAllTypesResponse getAllTypesResponse = new GetAllTypesResponse();
            getAllTypesResponse.setId(type.getId());
            getAllTypesResponse.setName(type.getName());
        }
        return null;
    }

    @Override
    public Type getById(int id) {
        return typeRepository.findById(id).orElseThrow();
    }

    /*
    @Override
    public GetTypeResponse getById(int id) {
        Type typeToId=typeRepository.findById(id).orElseThrow();
        GetTypeResponse getTypeResponse=new GetTypeResponse();
        getTypeResponse.setName(typeToId.getName());
        return getTypeResponse;
    }
    */
    @Override
    public void delete(int id) {
        Type typeToDelete = typeRepository.findById(id).orElseThrow();
        typeRepository.delete(typeToDelete);
    }

    @Override
    public void add(AddTypeRequest addTypeRequest) {

        if (addTypeRequest.getId() <= 0) {
            throw new IllegalArgumentException("Type ID pozitif bir değer olmalıdır.");
        }


        Type type = new Type();
        type.setName(addTypeRequest.getName());
        typeRepository.save(type);
    }

    @Override
    public void update(UpdateTypeRequest updateTypeRequest) {

        if (updateTypeRequest.getName() == null || updateTypeRequest.getName().length() < 2) {
            throw new IllegalArgumentException("Type Name en az 2 karakter olmalıdır.");
        }

        Type typeToUpdate = typeRepository.findById(updateTypeRequest.getId()).orElseThrow();
        typeToUpdate.setName(updateTypeRequest.getName());
        typeRepository.save(typeToUpdate);
    }

    @Override
    public List<GetListTypeResponse> getByName(String name) {
        // return typeRepository.findByType(name);
        return typeRepository.findByType(name).stream().map((type) -> {
            return new GetListTypeResponse(type.getId(), type.getName());
        }).toList();

    }
    //TypeManager clasını implement ettiğimiz için TypeService Clasında tanımlanan her metodu uygulamak zorundadır.
    // onun bir ara birimidir.
}
