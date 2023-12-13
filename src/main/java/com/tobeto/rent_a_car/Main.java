package com.tobeto.rent_a_car;


import com.tobeto.rent_a_car.entities.Brand;
import com.tobeto.rent_a_car.services.dtos.brand.responses.GetListBrandResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Brand> brands = new ArrayList<>();

        Brand brand1 = new Brand();
        brand1.setId(1);
        brand1.setName("Audi");
        brands.add(brand1);

        Brand brand2 = new Brand();
        brand2.setId(2);
        brand2.setName("BMW");
        brands.add(brand2);



        // Lambda Expression => Java 8
        brands.forEach((item) -> {
            String name = item.getName();
            System.out.println(name);
        });

        brands.forEach((item) -> System.out.println(item.getId())); // One Line Function

        // STREAM API

        // koleksiyonlar üzerinde işlem yapılmasını kolaylaştırır
        List<GetListBrandResponse> result =
                         brands
                        .stream()
                        .map((brand) -> new GetListBrandResponse(brand.getId(), brand.getName())).toList();



        List<Brand> sortedBrands = brands.stream().sorted( (b1, b2) -> b1.getName().compareTo(b2.getName()) ).toList();
        sortedBrands.forEach((brand) -> System.out.println(brand.getName()));

        System.out.println("*********************");
        List<Brand> sortedBrands2 = brands.stream().sorted(  Comparator.comparing(Brand::getName).thenComparing(Brand::getId)  ).toList();
        sortedBrands2.forEach((brand) -> System.out.println(brand.getName()));

        System.out.println("*********************");

        List<Brand> filteredBrands = brands.stream().filter( (brand) -> brand.getName().length() > 4 ).toList();
        System.out.println(filteredBrands.size());


        List<Brand> filteredBrands2 = brands.stream().filter((brand) -> {
            int minLength = 2;
            return brand.getId() > minLength && brand.getName().equals("Audi");
        }).toList();
        System.out.println(filteredBrands2.size());

        // Multiple Line lambda expressionlarda eğer method bir dönüş tipi bekliyor ise, return keywordu kullanılmalı.
    }

}