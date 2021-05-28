package io.kodlama.Entites.Concretes;

import io.kodlama.Entites.Abstracts.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employers")

public class EmployerEntity implements Serializable {

    @Id
    @Column(name = "employer_id")

    private long employerId;

    @Column(name = "employer_name")
    private String employerName;

    @Column(name = "employer_email")
    private String employerEmail;

    @Column(name = "employer_phone")
    private String employerPhone;

    @Column(name ="employer_adress")
    private String employerAdress;

    @Column (name = "employer_website")
    private String EmployerWebsite;

  @ManyToOne( fetch =  FetchType.LAZY)
  @PrimaryKeyJoinColumn(name = "employer_id")
   private UserEntity user;


}
