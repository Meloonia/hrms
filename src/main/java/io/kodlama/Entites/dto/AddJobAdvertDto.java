package io.kodlama.Entites.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddJobAdvertDto {
    private long employerId;
    private String businessSectorName;
    private Date relaseDate = new Date();
    private Date activeDate= new Date();
    private  int openPosition;
}
