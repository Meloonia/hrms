package io.kodlama.Entites.Concretes;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class UserEntity {


    @OneToMany(mappedBy = "systemManagerId" , fetch = FetchType.LAZY)
    private Set<SystemManagerEntity> systemManagerEntities = new HashSet<>(0);
    @OneToMany(mappedBy =  "jobSeekerId" , fetch = FetchType.LAZY)
    private Set<JobSeekerEntity> jobSeekerEntities = new HashSet<>(0);
    @OneToMany(mappedBy = "userId" , fetch = FetchType.LAZY)
    private Set<EmployerEntity> employerEntities = new HashSet<>(0);
    @OneToMany(mappedBy = "userId",fetch = FetchType.LAZY)
    private Set<EmailValidationEntity> emailValidationEntities = new HashSet<>(0);

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;


    @Column(name = "user_email")
    private String userEmail;
    @NotNull
    @Column(name = "user_password")
    private String userPassword;
    @NotNull
    @Column(name = "user_repassword")
    private String rePassword;
    @NotNull
    @Column(name = "user_Email_validation")
    private boolean emailValidation;



     /*  @OneToMany(mappedBy = "systemManagerId" , fetch = FetchType.LAZY)

    public Set<SystemManagerEntity> getSystemManagerEntity() {
      return  this.systemManagerEntities;
    }

    @OneToMany(mappedBy =  "jobSeekerId" , fetch = FetchType.LAZY)
    public Set<JobSeekerEntity> getJobSeekerEntity(){
           return this.jobSeekerEntities;
    }

    @OneToMany(mappedBy = "userId" , fetch = FetchType.LAZY)
    public Set<EmployerEntity> getEmployerEntity(){
           return this.employerEntities;
    }

    @OneToMany(mappedBy = "userId",fetch = FetchType.LAZY)
    public Set<EmailValidationEntity> getEmailValidation(){
           return this.emailValidationEntities;
    } /*
     /*  @OneToMany(mappedBy = "parentUser" , fetch =FetchType.LAZY )
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_user_id")
    private UserEntity parentUser;
 */
/*@OneToMany (mappedBy = "systemManagerEntity")
   public Set<SystemManagerEntity> getSystemManagerEntity{
    return this.systemManagerEntities;
    }



    @OneToMany(mappedBy = "jobSeekerEntity")
   private JobSeekerEntity jobSeekerEntity;

    @OneToMany(mappedBy = "emplorEntity")
    private EmployerEntity employerEntity;

    @OneToMany(mappedBy = "emailValidationEntity")
   private EmailValidationEntity emailValidationEntity; */
   }

