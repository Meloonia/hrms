package io.kodlama.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","UserEntity"})
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private long userId;

    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY )
    private Set<SystemManagerEntity> systemManagerEntities = new HashSet<>();


    @OneToMany(mappedBy =  "user" , fetch = FetchType.LAZY )
    private Set<JobSeekerEntity> jobSeekerEntities = new HashSet<>();


    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY )
    private Set<EmployerEntity> employerEntities = new HashSet<>();


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<EmailValidationEntity> emailValidationEntities = new HashSet<>();

    @OneToMany(mappedBy = "userId" ,fetch =FetchType.LAZY )
    private Set<JobAdverstisementEntity> jobAdverstisementEntity = new HashSet();

    @NotNull
    @NotBlank
    @Email
    @Column(name = "user_email")
    private String userEmail;
    @NotNull
    @NotBlank

    @Column(name = "user_password")

    private String userPassword;
    @NotNull
    @NotBlank
    @Column(name = "user_repassword")
    private String rePassword;

    @OneToMany(targetEntity = JobSeekerCvEntity.class)
    Set<JobSeekerCvEntity> jobSeekerCvEntitySet = new HashSet<>();

}

