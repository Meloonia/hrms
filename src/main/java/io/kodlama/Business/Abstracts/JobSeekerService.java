package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;

public interface JobSeekerService {

    Result insert(UserEntity user , JobSeekerEntity jobSeekerEntity);

}
