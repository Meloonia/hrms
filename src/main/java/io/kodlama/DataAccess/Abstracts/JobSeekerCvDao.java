package io.kodlama.DataAccess.Abstracts;

import io.kodlama.Entites.Concretes.JobSeekerCvEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerCvDao extends JpaRepository<JobSeekerCvEntity,Long> {

    JobSeekerCvEntity findJobSeekerCvEntityByJobSeekerEntity_User_UserId(long id);

}
