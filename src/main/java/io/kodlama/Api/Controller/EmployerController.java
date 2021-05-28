package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.EmployerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.DataAccess.Abstracts.EmployersDao;
import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
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

    public Result insertEmployer(@RequestBody EmployerEntity employer ,@RequestBody UserEntity user) {

        return this.employerServices.insert(user,employer);

    }

        @GetMapping("/getemployer")
    public List<EmployerEntity> getallEmployer() {

        return this.employerServices.getAll();
        }

}
