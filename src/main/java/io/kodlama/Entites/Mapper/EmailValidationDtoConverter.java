package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.EmailValidationEntity;
import io.kodlama.Entites.dto.EmailValidationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmailValidationDtoConverter {

    @Mappings({
            @Mapping(source = "email",target ="email"),
            @Mapping(source = "validation",target ="validation")
    })
    EmailValidationEntity emailValidationDtoConverter(EmailValidationDto emailValidationDto);

}
