package io.kodlama.Entites.dto;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerSchoolDto {


    private String  jobSeekerSchool;

    private Date    gradiuationYear;
    private String  jobSeekerCollageDepartment;
    private Date    startYear;



    }


