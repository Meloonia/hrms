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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_seekers")

public class JobSeekerEntity {
 @Id


 @Column(name = "job_seeker_id")
 @GeneratedValue(strategy = GenerationType.AUTO)
 private long jobSeekerId;

 @NotNull
 @NotBlank
 @Column(name = "job_seeker_national_id")
 private long jobSeekerNationalId;
 @NotNull
 @NotBlank
 @Column(name = "job_seeker_name")
 private String jobSeekerName;
 @NotNull
 @NotBlank
 @Column(name = "job_seeker_surname")
 private String jobSeekerSurname;
 @NotNull
 @NotBlank
 @Column(name = "job_seeker_phone")
 private String jobSeekerPhone;
 @NotNull
 @NotBlank
 @Column(name = "job_seeker_adress")
 private String jobSeekerAdress;
 @NotNull
 @NotBlank
 @Column(name = "job_seeker_birtday")
 private int birtday;
 @NotNull
 @NotBlank
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

 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 @JoinColumn(name = "user_id")
 private UserEntity user;

 @OneToMany(targetEntity = JobSeekerCvEntity.class , cascade = CascadeType.ALL)
 Set<JobSeekerCvEntity> jobSeekerCvEntitySet = new HashSet<>();

}