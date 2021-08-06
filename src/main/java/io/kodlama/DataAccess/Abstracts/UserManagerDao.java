package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UserManagerDao extends JpaRepository<UserEntity,Long> {

    UserEntity getByUserEmail(String email);
    UserEntity findUserEntityByUserId(long id);
}
