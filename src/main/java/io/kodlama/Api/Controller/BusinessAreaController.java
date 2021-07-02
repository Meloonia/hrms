package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.BusinessAreaServices;
import io.kodlama.Business.Concretes.BusinessAreaManager;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.BusinessSectorDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller olduğunu ve frontend den gelen istek adresini belirtir.
@RestController
@RequestMapping("/api/v1/businessareas")
public class BusinessAreaController {
	
	private final BusinessAreaServices businessAreaServices;
	


	public BusinessAreaController(BusinessAreaServices businessAreaManager) {
		this.businessAreaServices = businessAreaManager;
	}
	//Get adresi.
	@GetMapping("/v1/getall")
	
	public List<BusinessSectorDto> getAll() {
		
		return  businessAreaServices.getAll();
	}


	@PostMapping("/v1/insert")

	public Result insert(@RequestBody BusinessSectorDto businessAreasEntity) {
		return this.businessAreaServices.insert(businessAreasEntity);
	}



}
