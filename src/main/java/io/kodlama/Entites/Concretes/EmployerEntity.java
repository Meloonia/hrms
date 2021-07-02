package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employers")

public class EmployerEntity{




    @Id
    @Column(name = "employer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employerId;




    @NotNull
    @NotBlank
    @Column(name = "employer_name",nullable = false)
    private String employerName;

    @NotNull
    @NotBlank
    @Column(name = "employer_phone")
    private String employerPhone;

    @NotNull
    @NotBlank
    @Column(name ="employer_adress")
    private String employerAdress;

    @NotNull
    @NotBlank
    @Column (name = "employer_website",nullable = false)
    private String EmployerWebsite;

    @NotNull
    @NotBlank
    @Column (name = "employer_personel_validation")
    private boolean personelValidation;

    @NotNull
    @NotBlank
    @Column(name = "employer_city")
    @JoinColumn(name ="employer_city")
    private int cityId;



    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.REFRESH , targetEntity = CityEntity.class)
    private CityEntity cityEntity;

    @OneToMany(mappedBy = "employer",fetch = FetchType.LAZY)
    private Set<JobAdverstisementEntity> jobAdverstisementEntities  = new HashSet<>();


    @OneToOne( fetch =  FetchType.LAZY , cascade = CascadeType.ALL )
    @JoinColumn(referencedColumnName = "user_id")

    private UserEntity user;


}
