package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.JobSeekerDto;
import io.kodlama.Entites.dto.JobSeekerExperienceDto;
import io.kodlama.Entites.dto.JobSeekerSchoolDto;
import io.kodlama.Entites.dto.LinkedLnPatchDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T21:40:29+0300",
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
    public LinkedLnPatchDto jobSeekerDtoConverterToEntity(JobSeekerEntity jobSeekerEntity) {
        if ( jobSeekerEntity == null ) {
            return null;
        }

        LinkedLnPatchDto linkedLnPatchDto = new LinkedLnPatchDto();

        linkedLnPatchDto.setJobSeekerLinkedlnAdress( jobSeekerEntity.getJobSeekerLinkedlnAdress() );

        return linkedLnPatchDto;
    }

    @Override
    public List<JobSeekerDto> getAllJobSeekerDtoConverter(List<JobSeekerEntity> jobSeekerEntityList) {
        if ( jobSeekerEntityList == null ) {
            return null;
        }

        List<JobSeekerDto> list = new ArrayList<JobSeekerDto>( jobSeekerEntityList.size() );
        for ( JobSeekerEntity jobSeekerEntity : jobSeekerEntityList ) {
            list.add( jobSeekerEntityToJobSeekerDto( jobSeekerEntity ) );
        }

        return list;
    }

    protected JobSeekerDto jobSeekerEntityToJobSeekerDto(JobSeekerEntity jobSeekerEntity) {
        if ( jobSeekerEntity == null ) {
            return null;
        }

        JobSeekerDto jobSeekerDto = new JobSeekerDto();

        jobSeekerDto.setJobSeekerName( jobSeekerEntity.getJobSeekerName() );
        jobSeekerDto.setJobSeekerSurname( jobSeekerEntity.getJobSeekerSurname() );
        jobSeekerDto.setJobSeekerNationalId( jobSeekerEntity.getJobSeekerNationalId() );
        jobSeekerDto.setBirtday( jobSeekerEntity.getBirtday() );
        jobSeekerDto.setJobSeekerPhone( jobSeekerEntity.getJobSeekerPhone() );
        jobSeekerDto.setJobSeekerAdress( jobSeekerEntity.getJobSeekerAdress() );

        return jobSeekerDto;
    }
}
