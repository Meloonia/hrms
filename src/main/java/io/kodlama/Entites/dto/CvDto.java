package io.kodlama.Entites.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

    private String jobSeekerName;
    private String jobSeekerSurname;
    private String jobSeekerSchool;
    private String gradiuationYear;
    private String schoolStartyear;
    private String jobSeekerExperience;
    private String nowJob = null;
    private String jobSeekerCollageDepartment;
    private String jobSeekerGithubAdress;
    private String jobSeekerLinkedlnAdress;
    private String jobSeekerDesciription;
    private String jobSeekerPhotoAdress;



}
