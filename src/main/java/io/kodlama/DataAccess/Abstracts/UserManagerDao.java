package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagerDao extends JpaRepository<UserEntity,Long> {

    UserEntity getByUserEmail(String email);


}
