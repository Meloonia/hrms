package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.EmployerDto;
import io.kodlama.Entites.dto.JobSeekerDto;
import io.kodlama.Entites.dto.getAllEmployerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployerDtoConverter {

   /* @Mappings({

    })*/
    EmployerEntity insertEmployerDtoConverter(EmployerDto employerDto);

    List<EmployerEntity> listEmployerDtoConverter(List<EmployerEntity> employerEntity);
   /* @Mappings({
            @Mapping(source = "userEmail ",target = "userEmail"),
            @Mapping(source = "userPassword",target = "userPassword"),
            @Mapping(source = "rePassword",target = "rePassword"),
    })*/
    UserEntity insertuserDtoConverter(EmployerDto employerDto);

    List<getAllEmployerDto> listAllEmployer(List<EmployerEntity> employerEntity);


}
