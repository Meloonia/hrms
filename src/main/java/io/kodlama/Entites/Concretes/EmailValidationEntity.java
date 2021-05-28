package io.kodlama.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "email_validations")


public class EmailValidationEntity{


    @Id
    @Column(name = "email_validations_id")

    private long emailValidationsId;

    @Column
    private String email;

    @Column(name ="email_validation_code")
    private String emailValidationCode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "email_validations_id")
    private UserEntity user;

}
