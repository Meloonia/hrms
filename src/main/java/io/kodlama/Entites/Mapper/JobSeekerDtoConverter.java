package io.kodlama.Entites.Mapper;


import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.JobSeekerDto;
import io.kodlama.Entites.dto.JobSeekerExperienceDto;
import io.kodlama.Entites.dto.JobSeekerSchoolDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface JobSeekerDtoConverter {

   /* @Mappings({
            @Mapping(source = "jobSeekerName;      ",target = "jobSeekerName"),
            @Mapping(source = "jobSeekerSurname;   ",target = "jobSeekerSurname"),
            @Mapping(source = "jobSeekerNationalId;",target = "jobSeekerNationalId"),
            @Mapping(source = "birtday;            ",target = "birtday"),
            @Mapping(source = "jobSeekerPhone;     ",target = "jobSeekerPhone"),
            @Mapping(source = "jobSeekerAdress;    ",target = "jobSeekerAdress")
    })*/
    JobSeekerEntity jobSeekerDtoConverter(JobSeekerDto jobSeekerDto);
/*
    @Mappings({
            @Mapping(source = "userEmail ",target = "userEmail"),
            @Mapping(source = "userPassword",target = "userPassword"),
            @Mapping(source = "rePassword",target = "rePassword"),
    })*/
    UserEntity jobSeekerToUserDtoConverter(JobSeekerDto jobSeekerDto);


    /*@Mappings({
            @Mapping(source = "jobSeekerExperience",target ="jobSeekerExperience")

    })*/
    JobSeekerEntity jobSeekerExperienceDtoConverter(JobSeekerExperienceDto jobSeekerExperienceDto);

  /*  @Mappings({
            @Mapping(source = "jobSeekerSchool",target ="jobSekerSchool"),
            @Mapping(source = "startYear",target ="startYear"),
            @Mapping(source = "gradiuationYear",target ="gradiuationYear"),
            @Mapping(source = "jobSeekerCollageDepartment",target ="jobSeekerCollageDepartment"),
    })*/
    JobSeekerEntity jobSeekerSchoolDtoConverter(JobSeekerSchoolDto jobSeekerSchoolDto);

}
