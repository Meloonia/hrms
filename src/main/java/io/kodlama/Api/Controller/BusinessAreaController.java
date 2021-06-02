package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.BusinessAreaServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import io.kodlama.Entites.dto.BusinessSectorDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Controller olduğunu ve frontend den gelen istek adresini belirtir.
@RestController
@RequestMapping("/api/businessareas")
public class BusinessAreaController {
	
	private BusinessAreaServices businessAreaServices;
	
	@Autowired
	public BusinessAreaController(BusinessAreaServices businessAreaServices) {
		super();
		this.businessAreaServices = businessAreaServices;
	}

	public BusinessAreaController() {}
	//Get adresi.
	@GetMapping("/getall")
	
	public List<BusinessSectorDto> getAll() {
		
		return businessAreaServices.getAll();
	}


	@PostMapping("/insert")

	public Result insert(BusinessSectorDto businessAreasEntity) {
		return this.businessAreaServices.insert(businessAreasEntity);
	}



}
