package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import io.kodlama.Entites.dto.BusinessSectorDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;

import java.util.List;
public interface BusinessAreaServices {

	List<BusinessSectorDto> getAll();
	Result insert(BusinessSectorsEntity businessAreas);
	public List<ActiveJobAdverstisementDto> getAllActiveSectors();
	List<BusinessSectorToEmployerDto> getAllActiveSectorsDate();

}
