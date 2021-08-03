package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.CityEntity;
import io.kodlama.Entites.dto.CityDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T21:40:30+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class CityDtoConverterImpl implements CityDtoConverter {

    @Override
    public CityDto cityDto(CityEntity city) {
        if ( city == null ) {
            return null;
        }

        CityDto cityDto = new CityDto();

        cityDto.setCityId( city.getCityId() );
        cityDto.setCityName( city.getCityName() );

        return cityDto;
    }

    @Override
    public List<CityDto> cityList(List<CityEntity> cities) {
        if ( cities == null ) {
            return null;
        }

        List<CityDto> list = new ArrayList<CityDto>( cities.size() );
        for ( CityEntity cityEntity : cities ) {
            list.add( cityDto( cityEntity ) );
        }

        return list;
    }
}
