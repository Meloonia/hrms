package io.kodlama.Api.Controller;


import io.kodlama.Business.Abstracts.JobSeekerCvService;
import io.kodlama.Business.Concretes.JobSeekerCvManager;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.CvDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/jobseekercv")
@CrossOrigin
public class JobSeekerCvController {

    private final JobSeekerCvService jobSeekerCvService;


    public JobSeekerCvController(JobSeekerCvManager jobSeekerCvManager) {
        this.jobSeekerCvService = jobSeekerCvManager;
    }

    @PutMapping("/addCv/{userId}/")
    public Result AddCv(@PathVariable( "userId")  long userId, @RequestBody CvDto cvDto) {
      return  jobSeekerCvService.addCv(userId,cvDto);

    }
}
