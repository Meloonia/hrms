package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.EmployerBusinessSectorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerBusinessSectorsDao extends JpaRepository<EmployerBusinessSectorsEntity,Long> {
}
