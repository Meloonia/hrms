package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementDao extends JpaRepository<JobAdverstisementEntity , Long> {
}
