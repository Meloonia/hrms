package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.JobSeekerCvService;
import io.kodlama.Business.Concretes.JobSeekerCvManager;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class JobSeekerCvController {

    private final JobSeekerCvService jobSeekerCvService;

    @Autowired
    public JobSeekerCvController(JobSeekerCvManager jobSeekerCvManager) {
        this.jobSeekerCvService = jobSeekerCvManager;
    }

    @PostMapping(name = "/addCv")
    public void AddCv(@RequestBody CvDto cvDto) throws IOException {
        jobSeekerCvService.addCv(cvDto);

    }
}
