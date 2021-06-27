package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.BusinessAreaServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.BusinessAreaDao;

import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import io.kodlama.Entites.Mapper.BusinessSectorDtoConverter;
import io.kodlama.Entites.dto.BusinessSectorDto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusinessAreaManager implements BusinessAreaServices {

 // DataAccesess katmanını enjekte eder.
	private final  BusinessAreaDao businessAreaDao;
	private final BusinessSectorDtoConverter businessSectorDtoConverter;



	public BusinessAreaManager(BusinessAreaDao businessAreaDao,BusinessSectorDtoConverter businessSectorDtoConverter) {

		this.businessAreaDao = businessAreaDao;
		this.businessSectorDtoConverter = businessSectorDtoConverter;


	}

 //Entity katmanından verileri getirir.
	@Override
	public List<BusinessSectorDto> getAll() {

		List<BusinessSectorDto> list = businessSectorDtoConverter.businessSectorListConvertDto(businessAreaDao.findAll());


	return list;	}

	@Override
	public Result insert(BusinessSectorDto businessAreas) {



		if(businessAreaDao.findAll().stream().noneMatch(b -> b.getBusinessSectorName().
				equals(businessAreas.getBusinessSectorName()))) {

			this.businessAreaDao.save(businessSectorDtoConverter.businessSectorConverterDto(businessAreas));
			return new SuccessResult(true,"İş alanı eklendi");
		}
		else return new UnsuccessfulResult(false , "İş alanı zaten mevcut");
	}

	@Override
	public BusinessSectorsEntity getOne(String i) {
		return businessAreaDao.findByBusinessSectorName(i);
	}


}
