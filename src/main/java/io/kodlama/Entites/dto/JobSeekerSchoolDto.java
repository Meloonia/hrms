package io.kodlama.Entites.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerSchoolDto {

    private long UserId;
    private String jobSekerSchool;

    private Date gradiuationYear;
    private String jobSeekerCollageDepartment;
    private Date startYear;


}
