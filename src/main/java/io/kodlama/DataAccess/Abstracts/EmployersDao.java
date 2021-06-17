package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployersDao extends JpaRepository<EmployerEntity,Long> {


    List<JobAdverstisementEntity> findEmployerEntityByJobAdverstisementEntities(long id);

}

