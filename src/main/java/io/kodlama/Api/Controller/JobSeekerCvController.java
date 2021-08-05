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
public class JobSeekerCvController {

    private final JobSeekerCvService jobSeekerCvService;


    public JobSeekerCvController(JobSeekerCvManager jobSeekerCvManager) {
        this.jobSeekerCvService = jobSeekerCvManager;
    }

    @PostMapping("/addCv/{userId}/")
    public Result AddCv(@PathVariable( "userId")  long userId, @RequestParam File cvDto) throws IOException {
      return  jobSeekerCvService.addCv(userId,cvDto);

    }
}
