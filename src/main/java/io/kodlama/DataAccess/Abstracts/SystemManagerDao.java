package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.SystemManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemManagerDao extends JpaRepository<SystemManagerEntity, Integer> {
}
