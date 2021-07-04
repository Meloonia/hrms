package io.kodlama.Entites.Concretes;

import io.kodlama.Utils.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
import static io.kodlama.Utils.ValidationMessages.*;

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




    @NotNull(message = nameNull)
    @NotBlank(message = nameBlank)
    @Size(message = nameLenght,min =3)
    @Column(name = "employer_name",nullable = false)
    private String employerName;

    @NotNull(message = phoneNull)
    @NotBlank(message = phoneBlank)
    @Size(min = 10 , max = 14 ,message = ValidationMessages.employerPhone)
    @Column(name = "employer_phone")
    private String employerPhone;

    @NotNull(message = adressNull)
    @NotBlank(message = adressBlank)
    @Column(name ="employer_adress")
    private String employerAdress;

    @NotNull(message = employerWebSiteNullAndBlank)
    @NotBlank(message = employerWebSiteNullAndBlank)
    @Column (name = "employer_website",nullable = false)
    private String EmployerWebsite;


    @Column (name = "employer_personel_validation")
    private boolean personelValidation;

    @NotNull(message = cityNullAndBlank)
    @NotBlank(message = cityNullAndBlank)
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
