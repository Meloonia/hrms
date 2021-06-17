package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.dto.*;

import java.util.List;

public interface EmployerServices {

    Result insert(EmployerDto employerEntity);
    List<getAllEmployerDto> getAll();

    List<BusinessSectorToEmployerDto> getAllJobAdvert (EmployerEntity employer);
    EmployerEntity getEmployer(long userId);
}
