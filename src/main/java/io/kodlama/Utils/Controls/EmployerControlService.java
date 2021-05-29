package io.kodlama.Utils.Controls;

import io.kodlama.Entites.dto.EmployerDto;

public interface EmployerControlService {
    boolean nameLenghtControl(EmployerDto employerEntity);
    boolean emailDomainControl(EmployerDto employerEntity);
    boolean emailControl(EmployerDto employerEntity);

}
