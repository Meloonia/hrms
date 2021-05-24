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
    private long UserId;

    @NotNull
    @Column(name = "user_email")
    private String UserEmail;
    @NotNull
    @Column(name = "user_password")
    private String UserPassword;
    @NotNull
    @Column(name = "user_repassword")
    private String rePassword;
    @NotNull
    @Column(name = "user_Email_validation")
    private boolean emailValidation;

}
