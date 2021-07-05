package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.SystemManagerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.SystemManagerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SystemManagerDtoConverter {

    SystemManagerEntity SystemManagerDtoConvertEntity(SystemManagerDto systemManagerDto);
    UserEntity SystemManagerDtoConverterUserEntity(SystemManagerDto systemManagerDto);
}
