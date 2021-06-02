package io.kodlama.Entites.dto;

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
    private int maxSlaray;
    private int openPosition;
    private Date relaseDate;
    private Date activeDate;
    private boolean active;

}
