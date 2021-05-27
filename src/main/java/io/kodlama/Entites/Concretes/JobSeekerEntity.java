package io.kodlama.Entites.Concretes;

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
//@PrimaryKeyJoinColumn(name = "job_seeker_id" , referencedColumnName = "user_id" )
public class JobSeekerEntity implements Serializable {

   @Id
   @Column(name = "job_seeker_id")
    private long jobSeekerId;

    @Column(name= "job_seeker_national_id")
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

    @Id
    @ManyToOne ( fetch =  FetchType.LAZY , targetEntity = UserEntity.class )
    @JoinColumn(name = "job_seeker_id" , referencedColumnName = "user_id" )
    private UserEntity user;

    //public JobSeekerEntity(UserEntity user) {
      //  this.user = user;
     //   this.jobSeekerId = user.getUserId();
   // }

}
