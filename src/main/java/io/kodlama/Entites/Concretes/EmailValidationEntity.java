package io.kodlama.Entites.Concretes;

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
public class EmailValidationEntity implements Serializable {

  //  @PrimaryKeyJoinColumn(name = "user_id" , referencedColumnName = "user_id" )
   @Id
   @Column(name = "user_id")
    private long userId;

    @Column
    private String email;

    @Column(name ="email_validation_code")
    private String emailValidationCode;

    @Id
   @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.LAZY , targetEntity = UserEntity.class)
    private UserEntity user;





  //  public UserEntity getUserEntities() {
     //   return userEntities;
    //}

   // public void setUserEntities(UserEntity userEntities) {
     //   this.userEntities = userEntities;
    //}
}
