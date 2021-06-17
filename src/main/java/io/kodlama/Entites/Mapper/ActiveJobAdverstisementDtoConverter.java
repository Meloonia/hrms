package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActiveJobAdverstisementDtoConverter {
    List<ActiveJobAdverstisementDto> getAllActiveJobAdvert(List<JobAdverstisementEntity> jobAdverstisementEntities);

}
