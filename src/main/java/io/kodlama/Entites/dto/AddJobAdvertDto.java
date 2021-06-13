package io.kodlama.Entites.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddJobAdvertDto {
    private long Id;
    private String businessSectorName;

    @Temporal(TemporalType.DATE)
    private Date relaseDate;

    @Temporal(TemporalType.DATE)
    private Date activeDate;
    private  int openPosition;
    private int minSalary;
    private int maxSalary;
    private boolean active;
    private String desciription;



}
