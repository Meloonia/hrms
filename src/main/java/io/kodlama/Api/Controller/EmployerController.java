package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.EmployerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.DataAccess.Abstracts.EmployersDao;
import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import io.kodlama.Entites.dto.EmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employer")
public class EmployerController {

    private EmployerServices employerServices;
    @Autowired
    public EmployerController(EmployerServices employerServices)
    {
        this.employerServices = employerServices;
    }

    @PostMapping("/insertemployer")

    public Result insertEmployer(@RequestBody EmployerDto employer) {

        return this.employerServices.insert(employer);

    }

        @GetMapping("/getemployer")
    public List<EmployerEntity> getallEmployer() {

        return this.employerServices.getAll();
        }

        @PostMapping("/addJobAdvert")

    public Result insertJobAdvert(AddJobAdvertDto addJobAdvertDto) {

        return this.employerServices.addJobAdvert( addJobAdvertDto);
        }
}
