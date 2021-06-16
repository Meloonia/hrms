package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface BusinessSectorToEmployerDtoConverter {

    @Mappings({
            @Mapping(source = "minSalary",target="minSaray"),
            @Mapping(source = "maxSalary",target="maxSalary"),
            @Mapping(source = "openPosition",target="openPosition"),
            @Mapping(source = "relaseDate",target="relaseDate"),
            @Mapping(source = "activeDate",target="activeDate"),
            @Mapping(source = "active",target="active"),
    })
    List<BusinessSectorToEmployerDto> businessSectorToEmployerDtoConverter(List<JobAdverstisementEntity> businessSectorToEmployerDto);
}
