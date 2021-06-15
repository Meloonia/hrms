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


    @OneToMany(fetch = FetchType.LAZY )
    private Set<EmployerEntity> employerEntities = new HashSet<>();


    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private EmailValidationEntity emailValidationEntities;

    @OneToMany(mappedBy = "userEntity" ,fetch =FetchType.LAZY )
    private Set<JobAdverstisementEntity> jobAdverstisementEntity = new HashSet();

    @NotNull
    @NotBlank
    @Email
    @Column(name = "user_email",nullable = false)
    private String userEmail;
    @NotNull
    @NotBlank

    @Column(name = "user_password",nullable = false)

    private String userPassword;
    @NotNull
    @NotBlank
    @Column(name = "user_repassword",nullable = false)
    private String rePassword;

    @OneToMany(mappedBy = "user")
    Set<JobSeekerCvEntity> jobSeekerCvEntitySet = new HashSet<>();

}

