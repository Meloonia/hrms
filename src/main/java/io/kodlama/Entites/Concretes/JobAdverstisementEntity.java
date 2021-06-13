package io.kodlama.Entites.Concretes;

import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_advertisement")
public class JobAdverstisementEntity{

    @Id
    @JoinColumn(name = "user_id")
    @Column(name = "user_id")
    private long userId;
    @NotNull
    @NotBlank
    @Column(name = "desciription")
    private String desciription;

    @Column(name="active")
    private boolean active = true;
    @NotNull
    @NotBlank
    @JoinColumn(name = "business_sector")
    @Column(name = "business_sector")

    private int businessSector;

    @Temporal(TemporalType.DATE)
    @NotNull
    @NotBlank
    @Column(name = "relase_date")
    private Date relaseDate;


    @Temporal(TemporalType.DATE)
    @NotNull
    @NotBlank
    @Column(name = "active_date")
    private Date activeDate;
    @NotNull
    @NotBlank
    @Column(name = "min_salary")
    private int minSaray;
    @NotNull
    @NotBlank
    @Column(name = "max_salary")
    private int maxSalary;
    @NotNull
    @NotBlank
    @Column(name = "open_positions")
    private int openPosition;

    @ManyToOne(fetch = FetchType.LAZY )
    private CityEntity city;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.REFRESH)
    private BusinessSectorsEntity businessSectorsEntity;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)

    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private EmployerEntity employer;
}
