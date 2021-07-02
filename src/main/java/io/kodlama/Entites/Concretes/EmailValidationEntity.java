package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "email_validations")


public class EmailValidationEntity  {


    @Column private boolean validation;

    @Id
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn()
    private UserEntity user;

    @Column
    @NotNull
    @NotBlank
    @Email
    private String email;

    @Column(name ="email_validation_code")
    private String emailValidationCode;


}
