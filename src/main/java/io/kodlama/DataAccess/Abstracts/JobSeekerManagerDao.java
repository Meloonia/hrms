package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobSeekerManagerDao extends JpaRepository<JobSeekerEntity , Long> {

    List<JobSeekerEntity> getAllByGradiuationYear();
}
