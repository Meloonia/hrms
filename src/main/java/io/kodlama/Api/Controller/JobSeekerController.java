package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.JobSeekerService;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.JobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;

    }

    @PostMapping("/insert")
    public Result insertJobseeker(@RequestBody JobSeekerDto jobSeeker) {

        return this.jobSeekerService.insert(jobSeeker);


    }
    @GetMapping("/getall")

    public List<JobSeekerEntity> getAllJobSeeker() {
        return jobSeekerService.getAll();
    }



}
