package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;

import java.util.List;

public interface JobAdverstisementServices {

    List<AddJobAdvertDto> getAllActiveSectors();
    List<BusinessSectorToEmployerDto> getAllActiveSectorsDate();
    Result addJobAdvert(AddJobAdvertDto addJobAdvertDto);

}
