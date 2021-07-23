package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.JobAdverstisementServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobadvert")
public class JobAdvertController {

    JobAdverstisementServices jobAdverstisementServices;


    private JobAdvertController(JobAdverstisementServices jobAdvertManager) {
        this.jobAdverstisementServices = jobAdvertManager;
    }

    @GetMapping("/v1/getallactivesectors")

    public List<ActiveJobAdverstisementDto> getAllActiveSectors(){
        return jobAdverstisementServices.getAllActiveSectors();
    }

    @GetMapping("/v1/gettallactivesectordate")
    public List<BusinessSectorToEmployerDto> getAllActiveSectorsDate() {
        return jobAdverstisementServices.getAllActiveSectorsDate();
    }

    @PostMapping("/v1/addjobadvert/{userId}")
    public Result addJobAdvert(@PathVariable("userId") long userId ,@RequestBody AddJobAdvertDto addJobAdvertDto) {

        return jobAdverstisementServices.addJobAdvert(userId,addJobAdvertDto);
    }
}
