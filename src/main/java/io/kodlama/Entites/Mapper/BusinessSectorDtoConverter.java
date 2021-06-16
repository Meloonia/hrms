package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import io.kodlama.Entites.dto.BusinessSectorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusinessSectorDtoConverter {


    //@Mapping(source = "businessSectorName", target = "businessSectorName")
    BusinessSectorsEntity businessSectorConverterDto(BusinessSectorDto businessSectorDto);


   //@Mapping(source="businessSectorName" , target ="businessSectorName")

    List<BusinessSectorDto> businessSectorListConvertDto(List<BusinessSectorsEntity> businessSectorsEntity);


}
