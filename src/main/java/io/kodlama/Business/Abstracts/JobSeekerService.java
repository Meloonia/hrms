package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.dto.*;

import java.util.List;
public interface JobSeekerService {

    Result insert(JobSeekerDto jobSeekerdto);
    List<JobSeekerDto> getAll();
    Result insertJobExperience(JobSeekerExperienceDto jobSeekerExperienceDto);
    Result insertJobSchool(JobSeekerSchoolDto jobSeekerSchoolDto,long UserId);
    Result LinkedLnUpdate(LinkedLnPatchDto linkedLnPatchDto, long userId);
    Result gitHubUpdate(GithubPatchDto githubPatchDto,long userId);
    JobSeekerEntity getById(long id);
    List<JobSeekerEntity> getAllEntity();

}
