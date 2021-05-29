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
    private int openPosition;
    private Date relaseDate = new Date();
    private Date activeDate= new Date();
    private boolean active;

}
