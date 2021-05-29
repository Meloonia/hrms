package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employers")

public class EmployerEntity {

    @JoinColumn(name = "employer_id")
    @Id
    @Column(name = "employer_id")

    private long employerId;

    @Column(name = "employer_name")
    private String employerName;

    @Column(name = "employer_phone")
    private String employerPhone;

    @Column(name ="employer_adress")
    private String employerAdress;

    @Column (name = "employer_website")
    private String EmployerWebsite;

    @Column (name = "employer_personel_validation")
    private boolean personelValidation;

    @ManyToOne( fetch =  FetchType.LAZY, cascade = CascadeType.ALL)

    private UserEntity user;

}
