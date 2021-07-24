package io.kodlama.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.Optional;

import static io.kodlama.Utils.ValidationMessages.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_advertisement")
public class JobAdverstisementEntity {

    @Id
    @Column(name = "job_advert_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jobAdvertId;

    @NotNull(message = jobAdvertNull)
    @NotBlank(message = jobAdvertBlank)
    @Column(name = "desciription",nullable = false)
    private String desciription;

    @Column(name="active")
    private boolean active;

    @Temporal(TemporalType.DATE)
    @NotNull(message = jobAdvertRelaseDateNull)
    @NotBlank(message = jobAdvertRelaseDateblank)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "relase_date")
    private Date relaseDate;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @NotNull(message = jobAdvertActiveDateNull)
    @NotBlank(message = jobAdvertActiveDateblank)
    @Column(name = "active_date")
    private Date activeDate;

    @NotNull(message = jobAdvertMinSalaryNullAndBlank)
    @NotBlank(message = jobAdvertMinSalaryNullAndBlank)
    @Column(name = "min_salary")
    private int minSalary;

    @NotNull(message = jobAdvertMaxSalaryNullAndBlank)
    @NotBlank(message = jobAdvertMaxSalaryNullAndBlank)
    @Column(name = "max_salary")
    private int maxSalary;

    @NotNull(message = jobAdvertOpenPositionNullAndBlank)
    @NotBlank(message = jobAdvertOpenPositionNullAndBlank)
    @Column(name = "open_positions")
    private int openPosition;

    @NotBlank(message = "Boş geçilemez")
    @NotNull(message = "Boş geçilemez")
    @Column(name = "work_type")
    private String workType;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "city_city_id")
    private CityEntity cityEntites;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name ="business_sectors_entity_business_sector_id")
    private BusinessSectorsEntity businessSectorsEntity;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")

    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "employer_employer_id")
    private EmployerEntity employer;
}
