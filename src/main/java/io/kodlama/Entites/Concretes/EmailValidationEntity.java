package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "email_validations")
public class EmailValidationEntity {

    @Id
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")

    private long userId;

    @Column
    private String email;

    @Column(name ="email_validation_code")
    private String emailValidationCode;
}
