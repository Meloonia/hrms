package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.UserEntity;

import java.util.List;

public interface EmployerServices {

    Result insert(UserEntity user , EmployerEntity employerEntity);
    List<EmployerEntity> getAll();
}
