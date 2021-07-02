package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.JobSeekerService;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.AccountDto;
import io.kodlama.Entites.dto.JobSeekerDto;
import io.kodlama.Entites.dto.JobSeekerSchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PatchMapping("/v1/addSchool{userId}")
    public Result addSchool(@PathVariable("userId") long UserId, @RequestBody JobSeekerSchoolDto jobSeekerSchoolDto) {

        return this.jobSeekerService.insertJobSchool(jobSeekerSchoolDto,UserId);
    }
    @PatchMapping("/v1/addaccount{userId}")
    public Result addSchool(@PathVariable("userId") long UserId, @RequestBody AccountDto accountDto) {

        return this.jobSeekerService.insertAccount(accountDto,UserId);
    }


}
