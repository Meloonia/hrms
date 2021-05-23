package io.kodlama.Entites.Concretes;

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

    @Column(name = "user_email")
    private String UserEmail;

    @Column(name = "user_password")
    private String UserPassword;

    @Column(name = "user_repassword")
    private String rePassword;
}
