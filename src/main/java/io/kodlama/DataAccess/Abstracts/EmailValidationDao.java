package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.EmailValidationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailValidationDao extends JpaRepository<EmailValidationEntity , Long> {

    EmailValidationEntity getAllByUser_UserId(long id);

}
