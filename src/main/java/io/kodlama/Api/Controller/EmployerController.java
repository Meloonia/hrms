package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.EmployerServices;
import io.kodlama.Business.Concretes.JobAdvertManager;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import io.kodlama.Entites.dto.EmployerDto;
import io.kodlama.Entites.dto.getAllEmployerDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employer")
public class EmployerController {

    private final EmployerServices employerServices;
    private final JobAdvertManager jobAdvertManager;
    public EmployerController(EmployerServices employerServices, JobAdvertManager jobAdvertManager)
    {
        this.employerServices = employerServices;
        this.jobAdvertManager = jobAdvertManager;
    }


        @GetMapping("/getemployer")
    public List<getAllEmployerDto> getallEmployer() {

        return this.employerServices.getAll();
        }

    @PostMapping("/insertemployer")

    public Result insertEmployer( EmployerDto employer) {

        return this.employerServices.insert(employer);

    }

        @PostMapping("/addJobAdvert")

    public Result insertJobAdvert(@RequestBody AddJobAdvertDto addJobAdvertDto) {

        return this.jobAdvertManager.addJobAdvert( addJobAdvertDto);
        }
}
