package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.JobSeekerCvService;
import io.kodlama.Business.Concretes.JobSeekerCvManager;

import io.kodlama.Entites.dto.CvDto;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/jobseekercv")
public class JobSeekerCvController {

    private final JobSeekerCvService jobSeekerCvService;


    public JobSeekerCvController(JobSeekerCvManager jobSeekerCvManager) {
        this.jobSeekerCvService = jobSeekerCvManager;
    }

    @PostMapping(name = "/v1/addCv")
    public void AddCv(@RequestParam("file") CvDto cvDto) throws IOException {
        jobSeekerCvService.addCv(cvDto);

    }
}
