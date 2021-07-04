package io.kodlama.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.kodlama.Entites.Abstracts.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static io.kodlama.Utils.ValidationMessages.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_seekers")
public class JobSeekerEntity{



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "job_seeker_id")
 private long jobSeekerId ;





 @NotNull(message = nationalIdendityNull)
 @NotBlank(message = nationalIdendityblank)
 @Pattern(message = nationalIdendityPattern,regexp = "0-9")
 @Column(name = "job_seeker_national_id",nullable = false)
 private long jobSeekerNationalId;

 @NotNull(message = nameNull)
 @NotBlank(message = nameBlank)
 @Size(message = nameLenght , min = 3)
 @Column(name = "job_seeker_name",nullable = false)
 private String jobSeekerName;

 @NotNull(message = surNameNull)
 @NotBlank(message = surNameNull)
 @Size(min = 3 , message = surNameSize)
 @Column(name = "job_seeker_surname",nullable = false)
 private String jobSeekerSurname;


 @NotNull(message = phoneNull)
 @NotBlank(message = phoneBlank)
 @Size(min = 10,max = 10,message = phoneSize)
 @Column(name = "job_seeker_phone")
 private String jobSeekerPhone;

 @NotNull(message = adressNull)
 @NotBlank(message =adressBlank)

 @Column(name = "job_seeker_adress")
 private String jobSeekerAdress;

 @NotNull(message = birtdayNull)
 @NotBlank(message = birtdayBlank)
 @Size(min =4,max =4 ,message = birtdayBlank)
 @Column(name = "job_seeker_birtday",nullable = false)
 private LocalTime birtday;


 @Column(name = "job_seeker_school")
 private String jobSekerSchool;

 @Column(name = "job_seeker_gradiuation_year")
 private Date gradiuationYear;

 @Column(name = "job_seeker_school_start_year")
 private Date startYear;

 @Column(name = "job_seekers_work_experiences")
 private String jobSeekerExperience;

 @Column(name = "job_seeker_now_job")
 private String jobSeekerNowJob;

 @Column(name = "job_seeker_photo")
 private String jobSeekerPhotoAdress;

 @Column(name = "job_seeker_collage_department")
 private String jobSeekerCollageDepartment;

 @Column(name = "job_seeker_github_adress")
 private String jobSeekerGithubAdress;

 @Column(name = "job_seeker_linkedln_adress")
 private String jobSeekerLinkedlnAdress;

 @Column(name = "job_seeker_desciription")
 private String jobSeekerDesciription;

 /*@Column(name = "user_user_id" , updatable = false,insertable = false)
 private long userId;*/

 @OneToOne( fetch =  FetchType.LAZY , cascade = CascadeType.ALL )
 @JoinColumn(referencedColumnName = "user_id")
 private UserEntity user;


 @OneToMany(mappedBy = "jobSeekerEntity", cascade = CascadeType.ALL)
 Set<JobSeekerCvEntity> jobSeekerCvEntitySet = new HashSet<>();

}