package com.tobeto.rent_a_car.services.concretes;

import com.tobeto.rent_a_car.entities.Type;
import com.tobeto.rent_a_car.repositories.TypeRepository;
import com.tobeto.rent_a_car.services.abstracts.TypeService;
import com.tobeto.rent_a_car.services.dtos.type.requests.AddTypeRequest;
import com.tobeto.rent_a_car.services.dtos.type.requests.UpdateTypeRequest;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetAllTypesResponse;
import com.tobeto.rent_a_car.services.dtos.type.responses.GetTypeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeManager implements TypeService {

    private final TypeRepository typeRepository;

    public TypeManager(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<GetAllTypesResponse> getAll() {
        List<Type>typeList = typeRepository.findAll();
        List<GetAllTypesResponse>getAllTypesResponseList=new ArrayList<>();
        for(Type type:typeList){
            GetAllTypesResponse getAllTypesResponse = new GetAllTypesResponse();
            getAllTypesResponse.setId(type.getId());
            getAllTypesResponse.setName(type.getName());
        }
        return null;
    }

    @Override
    public GetTypeResponse getById(int id) {
        Type typeToId=typeRepository.findById(id).orElseThrow();
        GetTypeResponse getTypeResponse=new GetTypeResponse();
        getTypeResponse.setName(typeToId.getName());
        return getTypeResponse;
    }

    @Override
    public void delete(int id) {
        Type typeToDelete=typeRepository.findById(id).orElseThrow();
        typeRepository.delete(typeToDelete);
    }

    @Override
    public void add(AddTypeRequest addTypeRequest) {
    Type type=new Type();
    type.setName(addTypeRequest.getName());
    typeRepository.save(type);
    }

    @Override
    public void update(UpdateTypeRequest updateTypeRequest) {
        Type typeToUpdate =typeRepository.findById(updateTypeRequest.getId()).orElseThrow();
        typeToUpdate.setName(updateTypeRequest.getName());
        typeRepository.save(typeToUpdate);
    }
    //TypeManager clasını implement ettiğimiz için TypeService Clasında tanımlanan her metodu uygulamak zorundadır.
    // onun bir ara birimidir.
}
