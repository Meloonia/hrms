package io.kodlama.Entites.Concretes;

import io.kodlama.Entites.Abstracts.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_seekers")
public class JobSeekerEntity implements UsersEntity {

    @Id

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

    @OneToOne
    @PrimaryKeyJoinColumn(name = "fk_user_id" , referencedColumnName = "user_id" )
    private UserEntity user;

    public JobSeekerEntity(UserEntity user) {
        this.user = user;
        this.jobSeekerId = user.getUserId();
    }

}
