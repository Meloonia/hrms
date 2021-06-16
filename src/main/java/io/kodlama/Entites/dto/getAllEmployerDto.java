package io.kodlama.Entites.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class getAllEmployerDto {
    private String employerName;
    private String employerAdress;
    private String employerWebsite;
    private String employerPhone;
}
