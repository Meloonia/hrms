package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.EmployerServices;
import io.kodlama.Business.Abstracts.JobAdverstisementServices;
import io.kodlama.Business.Concretes.JobAdvertManager;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import io.kodlama.Entites.dto.EmployerDto;
import io.kodlama.Entites.dto.getAllEmployerDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Employer")
public class EmployerController {

    private final EmployerServices employerServices;
    private final JobAdverstisementServices jobAdvertManager;
    public EmployerController(EmployerServices employerServices, JobAdverstisementServices jobAdvertManager)
    {
        this.employerServices = employerServices;
        this.jobAdvertManager = jobAdvertManager;
    }


        @GetMapping("/v1/getemployer")
    public List<getAllEmployerDto> getallEmployer() {

        return this.employerServices.getAll();
        }

    @PostMapping("/v1/insertemployer")

    public Result insertEmployer(@RequestBody EmployerDto employer) {

        return this.employerServices.insert(employer);

    }


}
