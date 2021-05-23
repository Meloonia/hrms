package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.JobSeekerService;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;

    }

    @PostMapping("/insert")
    public Result insertJobseeker(UserEntity user, JobSeekerEntity jobSeeker) {

        return this.jobSeekerService.insert( user,jobSeeker);


    }




}
