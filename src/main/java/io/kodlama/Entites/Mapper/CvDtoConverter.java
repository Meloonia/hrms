package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobSeekerCvEntity;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.dto.CvDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CvDtoConverter {

  /*  @Mappings({
            @Mapping(source = "imageUrl", target = "imageUrl"),
    })*/
    JobSeekerCvEntity cvDtoConverter(CvDto jobCvDto);
    JobSeekerEntity  JobSeekerCvDtoConverter(CvDto cvDto);
}
