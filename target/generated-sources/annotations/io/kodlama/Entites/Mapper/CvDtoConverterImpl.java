package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobSeekerCvEntity;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.dto.CvDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-06T14:25:40+0300",
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

        return jobSeekerCvEntity;
    }

    @Override
    public JobSeekerEntity JobSeekerCvDtoConverter(CvDto cvDto) {
        if ( cvDto == null ) {
            return null;
        }

        JobSeekerEntity jobSeekerEntity = new JobSeekerEntity();

        jobSeekerEntity.setJobSeekerName( cvDto.getJobSeekerName() );
        jobSeekerEntity.setJobSeekerSurname( cvDto.getJobSeekerSurname() );
        jobSeekerEntity.setGradiuationYear( cvDto.getGradiuationYear() );
        jobSeekerEntity.setJobSeekerExperience( cvDto.getJobSeekerExperience() );
        jobSeekerEntity.setJobSeekerPhotoAdress( cvDto.getJobSeekerPhotoAdress() );
        jobSeekerEntity.setJobSeekerCollageDepartment( cvDto.getJobSeekerCollageDepartment() );
        jobSeekerEntity.setJobSeekerGithubAdress( cvDto.getJobSeekerGithubAdress() );
        jobSeekerEntity.setJobSeekerLinkedlnAdress( cvDto.getJobSeekerLinkedlnAdress() );
        jobSeekerEntity.setJobSeekerDesciription( cvDto.getJobSeekerDesciription() );

        return jobSeekerEntity;
    }
}
