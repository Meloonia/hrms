package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.BusinessSectorDto;

import java.util.List;
public interface BusinessAreaServices {


	List<BusinessSectorDto> getAll();
	Result insert(BusinessSectorDto businessAreas);


}
