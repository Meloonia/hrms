package io.kodlama.Business.Abstracts;

import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;

import java.util.List;

public interface JobAdverstisementServices {

    public List<BusinessSectorToEmployerDto> getActive();
    public List<BusinessSectorToEmployerDto> getActiveDate();


}
