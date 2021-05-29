package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.EmployerDto;

import java.util.List;

public interface EmployerServices {

    Result insert(EmployerDto employerEntity);
    List<EmployerEntity> getAll();
}
