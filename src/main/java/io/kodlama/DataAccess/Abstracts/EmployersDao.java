package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface EmployersDao extends JpaRepository<EmployerEntity,Long> {
}
