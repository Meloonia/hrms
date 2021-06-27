package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdverstisementEntity , Long> {

   List<JobAdverstisementEntity> findByActiveOrderByActiveDateAsc(boolean isActive);
   List<JobAdverstisementEntity> getAllByActive(boolean active);

}
