package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.CityServices;
import io.kodlama.Entites.Concretes.CityEntity;
import io.kodlama.Entites.dto.CityDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/Cities")
public class CityController {


    private final CityServices cityServices;


    public CityController( @Qualifier("CityManager") CityServices cityServices) {
        this.cityServices = cityServices;
    }


    @GetMapping("/getCities")
    public List<CityDto> getCityServices() {
        return cityServices.getAllCity()  ;
    }

    @GetMapping("/getcity")
    public List<CityEntity> getAllCity() {return cityServices.getALlCity();}
}
