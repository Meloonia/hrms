package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Set;

public interface EmployersDao extends JpaRepository<EmployerEntity,Long> {


    List<JobAdverstisementEntity> getAllByJobAdverstisementEntitiesOrderByUserEmployerId(long userId);
}
