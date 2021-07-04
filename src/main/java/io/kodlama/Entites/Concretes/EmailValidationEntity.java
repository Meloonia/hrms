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


    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long validationId;

    @Column private boolean validation;


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn()
    private UserEntity user;


    @Column
    @JoinColumn(referencedColumnName = "user_email")
    private String email;

    @Column(name ="email_validation_code")
    private String emailValidationCode;



}
