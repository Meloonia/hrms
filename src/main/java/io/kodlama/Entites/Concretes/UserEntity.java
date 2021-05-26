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

    private Set<SystemManagerEntity> systemManagerEntity  = new HashSet<SystemManagerEntity>();
    private Set<JobSeekerEntity> jobSeekerEntity = new HashSet<JobSeekerEntity>();
    private Set<EmployerEntity> employerEntities = new HashSet<EmployerEntity>();
  //  private Set<EmailValidationEntity> emailValidationEntities = new HashSet<EmailValidationEntity>();

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotNull
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


  /*  @OneToMany(mappedBy = "parentUser" , fetch =FetchType.LAZY )
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_user_id")
    private UserEntity parentUser;
 */
    @OneToMany
    private Set<SystemManagerEntity> getSystemManagerEntity() {
        return this.systemManagerEntity;
    }


    @OneToMany
    private Set<JobSeekerEntity> getJobSeekerEntity() {
        return this.jobSeekerEntity;
    }

    @OneToMany
    private Set<EmployerEntity> getEmployerEntities(){
        return this.employerEntities;
    }

  //  private Set<EmailValidationEntity> getEmailValidationEntity() {
   //    return this.emailValidationEntities;
  //  }

}
