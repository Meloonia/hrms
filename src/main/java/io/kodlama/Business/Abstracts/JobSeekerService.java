package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.AccountDto;
import io.kodlama.Entites.dto.JobSeekerDto;
import io.kodlama.Entites.dto.JobSeekerExperienceDto;
import io.kodlama.Entites.dto.JobSeekerSchoolDto;

import java.util.List;

public interface JobSeekerService {

    Result insert(JobSeekerDto jobSeekerdto);
    List<JobSeekerEntity> getAll();
    Result insertJobExperience(JobSeekerExperienceDto jobSeekerExperienceDto);
    Result insertJobSchool(JobSeekerSchoolDto jobSeekerSchoolDto,long UserId);
    Result insertAccount(AccountDto accountDto,long userId);


}
