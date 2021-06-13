package io.kodlama.Entites.dto;

import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessSectorToEmployerDto {

    private String employerName;
    private String businessSectorName;
    private int minSalary;
    private int maxSalary;
    private int openPosition;
    private Date relaseDate;
    private Date activeDate;
    private boolean active;



}
