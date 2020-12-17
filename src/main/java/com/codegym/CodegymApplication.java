package com.codegym;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class CodegymApplication {


    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;

    @PostConstruct
    void init(){
        List<Country> countryList= (List<Country>) countryService.findAll();
        if (countryList.isEmpty()){
            Country vietNam= new Country(1L,"Vietnam");
            countryService.save(vietNam);
            countryService.save(new Country("Lao"));
            countryService.save(new Country("Campuchia"));
            countryService.save(new Country("Thailand"));
            countryService.save(new Country("China"));
            countryService.save(new Country("United States of America"));
            countryService.save(new Country("Russia"));
            countryService.save(new Country("Somalia"));
            countryService.save(new Country("United Kingdom"));


            City city=new City();
                city.setId(1L);
                city.setName("Hà Nội");
                city.setCountry(vietNam);
                city.setArea("33586");
                city.setPopulation("8053663");
                city.setGdp("4185000000");
                city.setDescription("Hà Nội (chữ Hán: 河內) là thủ đô của nước CHXHCNVN...");
                cityService.saveCity(city);
            }
        }

    public static void main(String[] args) {
        SpringApplication.run(CodegymApplication.class, args);
    }

}
