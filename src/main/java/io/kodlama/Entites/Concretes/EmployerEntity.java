package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employers")

public class EmployerEntity {

    @Id
    @Column(name = "employer_id")

    private long employerId;
    @NotNull
    @NotBlank
    @Column(name = "employer_name")
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
    @Column (name = "employer_website")
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

    @ManyToOne( fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.REFRESH , targetEntity = CityEntity.class)
    private CityEntity cityEntity;

    @OneToMany(mappedBy = "employer",fetch = FetchType.LAZY)
    private Set<JobAdverstisementEntity> jobAdverstisementEntities  = new HashSet<>();
}
