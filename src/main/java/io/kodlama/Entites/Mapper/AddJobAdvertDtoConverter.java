package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AddJobAdvertDtoConverter {

    @Mappings({

            @Mapping(source = "relaseDate", target ="relaseDate"),
            @Mapping(source = "activeDate", target ="activeDate"),
            @Mapping(source = "minSalary",target ="minSaray"),
            @Mapping(source = "maxSalary",target = "maxSalary"),
            @Mapping(source = "active",target = "active"),
            @Mapping(source ="desciription",target = "desciription"),
            @Mapping(source ="openPosition",target ="openPosition")
    })
    JobAdverstisementEntity insertJobAdvert(AddJobAdvertDto addJobAdvertDto);


}
