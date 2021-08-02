package io.kodlama.Business.Abstracts;

import io.kodlama.Entites.Concretes.CityEntity;
import io.kodlama.Entites.dto.CityDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityServices {



        List<CityDto> getAllCity();
        List<CityEntity> getALlCity();
}
