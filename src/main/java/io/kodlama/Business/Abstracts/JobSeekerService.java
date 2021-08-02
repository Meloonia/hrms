package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.*;

import java.util.List;
public interface JobSeekerService {

    Result insert(JobSeekerDto jobSeekerdto);
    List<JobSeekerDto> getAll();
    Result insertJobExperience(JobSeekerExperienceDto jobSeekerExperienceDto);
    Result insertJobSchool(JobSeekerSchoolDto jobSeekerSchoolDto,long UserId);
    public Result LinkedLnUpdate(LinkedLnPatchDto linkedLnPatchDto, long userId);
    public Result gitHubUpdate(GithubPatchDto githubPatchDto,long userId);

}
