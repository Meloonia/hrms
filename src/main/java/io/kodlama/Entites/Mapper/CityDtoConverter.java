package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.CityEntity;
import io.kodlama.Entites.dto.CityDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityDtoConverter {



    CityDto cityDto(CityEntity city);

    List<CityDto> cityList(List<CityEntity> cities);


}
