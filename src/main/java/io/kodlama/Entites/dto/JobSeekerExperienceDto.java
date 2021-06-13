package io.kodlama.Entites.dto;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Data
@AllArgsConstructor

public class JobSeekerExperienceDto {

    private long userId;
    private String jobSeekerExperience;



}
