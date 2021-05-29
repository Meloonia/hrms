package io.kodlama.Entites.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobSeekerDto {

    private String userEmail;
    private String userPassword;
    private String rePassword;
    private String jobSeekerName;
    private String jobSeekerSurname;
    private long jobSeekerNationalId;
    private int birtday;
    private String jobSeekerPhone;
    private String jobSeekerAdress;
}
