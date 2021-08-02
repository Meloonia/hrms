package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.CityServices;
import io.kodlama.DataAccess.Abstracts.CityDao;
import io.kodlama.Entites.Concretes.CityEntity;
import io.kodlama.Entites.Mapper.CityDtoConverter;
import io.kodlama.Entites.dto.CityDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component("CityManager")
public class CityManager implements CityServices {


    private final CityDao cityDao;
    private final CityDtoConverter cityDtoConverter;
    public CityManager(CityDao cityDao, CityDtoConverter cityDtoConverter) {
        this.cityDao = cityDao;
        this.cityDtoConverter = cityDtoConverter;
    }


    @Override
    public List<CityDto> getAllCity() {


        return cityDtoConverter.cityList(cityDao.findAll());

    }

        @Override
    public List<CityEntity> getALlCity() {
        return cityDao
                .findAll();
    }
}
