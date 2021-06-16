package io.kodlama.Api.Controller;

import io.kodlama.Business.Abstracts.BusinessAreaServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.BusinessSectorDto;
import okhttp3.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller olduğunu ve frontend den gelen istek adresini belirtir.
@RestController
@RequestMapping("/api/businessareas")
public class BusinessAreaController {
	
	private final BusinessAreaServices businessAreaServices;
	


	public BusinessAreaController(BusinessAreaServices businessAreaServices) {
		this.businessAreaServices = businessAreaServices;
	}
	//Get adresi.
	@GetMapping("/getall")
	
	public List<BusinessSectorDto> getAll() {
		
		return  businessAreaServices.getAll();
	}


	@PostMapping("/insert")

	public Result insert(@RequestBody BusinessSectorDto businessAreasEntity) {
		return this.businessAreaServices.insert(businessAreasEntity);
	}



}
