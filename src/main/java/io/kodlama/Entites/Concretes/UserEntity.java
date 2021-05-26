package io.kodlama.Entites.Concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {


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

    @OneToOne(mappedBy = "parentUser" )
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_user_id")
    private UserEntity parentUser;

    @OneToOne
    private SystemManagerEntity systemManager;

    @OneToOne
    private JobSeekerEntity jobSeekerEntity;

    @OneToOne
    private EmployerEntity employer;

    @OneToOne
    EmailValidationEntity emailValidationEntity;

}
