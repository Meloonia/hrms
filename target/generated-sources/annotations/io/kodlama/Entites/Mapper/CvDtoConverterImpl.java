package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobSeekerCvEntity;
import io.kodlama.Entites.dto.CvDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-06T08:57:05+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class CvDtoConverterImpl implements CvDtoConverter {

    @Override
    public JobSeekerCvEntity cvDtoConverter(CvDto jobCvDto) {
        if ( jobCvDto == null ) {
            return null;
        }

        JobSeekerCvEntity jobSeekerCvEntity = new JobSeekerCvEntity();

        jobSeekerCvEntity.setImageUrl( jobCvDto.getImageUrl() );

        return jobSeekerCvEntity;
    }
}
