package io.kodlama.Entites.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto {
    private String userEmail;
    private String userPassword;
    private String rePassword;
    private String employerName;
    private String employerAdress;
    private String EmployerWebsite;
}
