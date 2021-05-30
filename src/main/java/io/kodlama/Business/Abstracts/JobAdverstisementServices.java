package io.kodlama.Business.Abstracts;

import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;

import java.util.List;

public interface JobAdverstisementServices {

    List<ActiveJobAdverstisementDto> getAllActiveSectors();
    List<BusinessSectorToEmployerDto> getAllActiveSectorsDate();


}
