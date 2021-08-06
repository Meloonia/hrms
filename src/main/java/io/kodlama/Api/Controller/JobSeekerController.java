package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.JobSeekerService;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.dto.GithubPatchDto;
import io.kodlama.Entites.dto.LinkedLnPatchDto;
import io.kodlama.Entites.dto.JobSeekerDto;
import io.kodlama.Entites.dto.JobSeekerSchoolDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobseeker")
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;


    public JobSeekerController(JobSeekerService jobSeekerManager) {
        this.jobSeekerService = jobSeekerManager;

    }

    @PostMapping("/v1/insert")
    public Result insert(@RequestBody JobSeekerDto jobSeeker) {

        return this.jobSeekerService.insert(jobSeeker);


    }
    @GetMapping("/v1/getall")

    public List<JobSeekerDto> getAllJobSeeker() {
        return jobSeekerService.getAll();
    }

    @PutMapping("/v1/addSchool/{userId}")
    public Result addSchool(@PathVariable("userId") long UserId, @RequestBody JobSeekerSchoolDto jobSeekerSchoolDto) {

        return this.jobSeekerService.insertJobSchool(jobSeekerSchoolDto,UserId);
    }
    @PutMapping("/v1/linkedlnAccount/{userId}")
    public Result addGithubAccount(@PathVariable("userId") long UserId, @RequestBody LinkedLnPatchDto linkedLnPatchDto) {

        return this.jobSeekerService.LinkedLnUpdate(linkedLnPatchDto,UserId);
    }

    @PutMapping("/v1/githubAccount/{userId}")

    public Result addLinkedLnAccount(@PathVariable("userId") long userId, @RequestBody GithubPatchDto github) {
        return this.jobSeekerService.gitHubUpdate(github,userId);
        }


        @GetMapping("/v1/getAllEntity")
        public List<JobSeekerEntity> getAllEntity() {
        return jobSeekerService.getAllEntity();
        }
}
//githubAccount