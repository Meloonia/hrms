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


    private long userId;

    @Column
    private String email;

    @Column(name ="email_validation_code")
    private String emailValidationCode;

    @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne
    private UserEntity user;

    public EmailValidationEntity(UserEntity user) {
        this.userId = user.getUserId();
        this.user = user;
    }


}
