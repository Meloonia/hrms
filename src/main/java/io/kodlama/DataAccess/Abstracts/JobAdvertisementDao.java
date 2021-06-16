package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdverstisementEntity , Long> {

   List<JobAdverstisementEntity> findByActiveOrderByActiveDateAsc(boolean isActive);

}
