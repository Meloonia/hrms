package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerManagerDao extends JpaRepository<JobSeekerEntity , Long> {
}
