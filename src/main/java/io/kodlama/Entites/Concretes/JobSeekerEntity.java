package io.kodlama.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.kodlama.Entites.Abstracts.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_seekers")

public class JobSeekerEntity {
 @Id
 @JoinColumn(name = "job_seeker_id")
 @Column(name = "job_seeker_id")

 private long jobSeekerId;

 @Column(name = "job_seeker_national_id")
 private long jobSeekerNationalId;

 @Column(name = "job_seeker_name")
 private String jobSeekerName;

 @Column(name = "job_seeker_surname")
 private String jobSeekerSurname;

 @Column(name = "job_seeker_phone")
 private String jobSeekerPhone;

 @Column(name = "job_seeker_adress")
 private String jobSeekerAdress;

 @Column(name = "job_seeker_birtday")
 private int birtday;


 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

 private UserEntity user;
}