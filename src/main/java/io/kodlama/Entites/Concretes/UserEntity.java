package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static io.kodlama.Utils.ValidationMessages.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements Serializable  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private long userId;

    @OneToOne(mappedBy = "user" , fetch = FetchType.LAZY )
    private SystemManagerEntity systemManagerEntity;


    @OneToOne(mappedBy =  "user" , fetch = FetchType.LAZY )
    private JobSeekerEntity jobSeekerEntity;


    @OneToOne(fetch = FetchType.LAZY ,mappedBy = "user")
    private EmployerEntity employerEntity;


    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private EmailValidationEntity emailValidationEntities;

    @OneToMany(mappedBy = "userEntity" ,fetch =FetchType.LAZY )
    private Set<JobAdverstisementEntity> jobAdverstisementEntity = new HashSet();

    @NotNull(message = emailNull)
    @NotBlank(message = emailBlank)


    @Column(name = "user_email",nullable = false)
    private String userEmail;
    @NotNull(message = emailNull)
    @NotBlank(message = emailBlank)

    @Column(name = "user_password",nullable = false)
    @NotNull(message = passwordNull)
    @NotBlank(message = passwordBlank)
    @Size(min = 8 , message = passwordSize)
    private String userPassword;

    @NotNull(message = passwordNull)
    @NotBlank(message = passwordBlank)
    @Size(min = 8 , message = passwordSize)
    @Column(name = "user_repassword",nullable = false)
    private String rePassword;

    @Column(name = "role")
    private String role;


}

