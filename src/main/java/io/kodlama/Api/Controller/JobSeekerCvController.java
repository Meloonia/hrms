package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.JobSeekerCvService;
import io.kodlama.Business.Concretes.JobSeekerCvManager;

import io.kodlama.Entites.dto.CvDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/jobseekercv")
public class JobSeekerCvController {

    private final JobSeekerCvService jobSeekerCvService;


    public JobSeekerCvController(JobSeekerCvManager jobSeekerCvManager) {
        this.jobSeekerCvService = jobSeekerCvManager;
    }

    @PostMapping(name = "/v1/addCv")
    public void AddCv(@RequestBody CvDto cvDto) throws IOException {
        jobSeekerCvService.addCv(cvDto);

    }
}
