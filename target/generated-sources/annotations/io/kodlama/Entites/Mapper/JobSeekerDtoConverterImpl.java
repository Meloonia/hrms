package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.AccountDto;
import io.kodlama.Entites.dto.JobSeekerDto;
import io.kodlama.Entites.dto.JobSeekerExperienceDto;
import io.kodlama.Entites.dto.JobSeekerSchoolDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T13:13:02+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class JobSeekerDtoConverterImpl implements JobSeekerDtoConverter {

    @Override
    public JobSeekerEntity jobSeekerDtoConverter(JobSeekerDto jobSeekerDto) {
        if ( jobSeekerDto == null ) {
            return null;
        }

        JobSeekerEntity jobSeekerEntity = new JobSeekerEntity();

        jobSeekerEntity.setJobSeekerNationalId( jobSeekerDto.getJobSeekerNationalId() );
        jobSeekerEntity.setJobSeekerName( jobSeekerDto.getJobSeekerName() );
        jobSeekerEntity.setJobSeekerSurname( jobSeekerDto.getJobSeekerSurname() );
        jobSeekerEntity.setJobSeekerPhone( jobSeekerDto.getJobSeekerPhone() );
        jobSeekerEntity.setJobSeekerAdress( jobSeekerDto.getJobSeekerAdress() );
        jobSeekerEntity.setBirtday( jobSeekerDto.getBirtday() );

        return jobSeekerEntity;
    }

    @Override
    public UserEntity jobSeekerToUserDtoConverter(JobSeekerDto jobSeekerDto) {
        if ( jobSeekerDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserEmail( jobSeekerDto.getUserEmail() );
        userEntity.setUserPassword( jobSeekerDto.getUserPassword() );
        userEntity.setRePassword( jobSeekerDto.getRePassword() );

        return userEntity;
    }

    @Override
    public JobSeekerEntity jobSeekerExperienceDtoConverter(JobSeekerExperienceDto jobSeekerExperienceDto) {
        if ( jobSeekerExperienceDto == null ) {
            return null;
        }

        JobSeekerEntity jobSeekerEntity = new JobSeekerEntity();

        jobSeekerEntity.setJobSeekerExperience( jobSeekerExperienceDto.getJobSeekerExperience() );

        return jobSeekerEntity;
    }

    @Override
    public JobSeekerEntity jobSeekerSchoolDtoConverter(JobSeekerSchoolDto jobSeekerSchoolDto) {
        if ( jobSeekerSchoolDto == null ) {
            return null;
        }

        JobSeekerEntity jobSeekerEntity = new JobSeekerEntity();

        jobSeekerEntity.setGradiuationYear( jobSeekerSchoolDto.getGradiuationYear() );
        jobSeekerEntity.setStartYear( jobSeekerSchoolDto.getStartYear() );
        jobSeekerEntity.setJobSeekerCollageDepartment( jobSeekerSchoolDto.getJobSeekerCollageDepartment() );

        return jobSeekerEntity;
    }

    @Override
    public AccountDto jobSeekerDtoConverterToEntity(JobSeekerEntity jobSeekerEntity) {
        if ( jobSeekerEntity == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setJobSeekerLinkedlnAdress( jobSeekerEntity.getJobSeekerLinkedlnAdress() );
        accountDto.setJobSeekerGithubAdress( jobSeekerEntity.getJobSeekerGithubAdress() );

        return accountDto;
    }
}
