package io.kodlama.Entites.Concretes;

import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import static io.kodlama.Utils.ValidationMessages.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_advertisement")
public class JobAdverstisementEntity {

    @Id
    @Column(name = "job_advert_id")
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
    @DateTimeFormat(pattern = "dd-MM-yyyy")
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

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn()
    private BusinessSectorsEntity businessSectorsEntity;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")

    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private EmployerEntity employer;
}
