package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.BusinessAreaServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.BusinessAreaDao;
import io.kodlama.DataAccess.Abstracts.JobAdvertisementDao;
import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import io.kodlama.Entites.dto.BusinessSectorDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessAreaManager implements BusinessAreaServices {

 // DataAccesess katmanını enjekte eder.
	private  BusinessAreaDao businessAreaDao;
	private JobAdvertisementDao jobAdvertisementDao;
	private final ModelMapper modelMapper;


	@Autowired
	public BusinessAreaManager(BusinessAreaDao businessAreaDao,
	 JobAdvertisementDao jobAdvertisementDao , ModelMapper modelMapper) {
		super();
		this.businessAreaDao = businessAreaDao;
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper = modelMapper;

	}

 //Entity katmanından verileri getirir.
	@Override
	public List<BusinessSectorDto> getAll() {
		BusinessSectorDto businessSectorDto = new BusinessSectorDto();
		List<BusinessSectorDto> liste = new ArrayList<>();
		BusinessSectorsEntity businessSectorsEntity= new BusinessSectorsEntity();

		modelMapper.map(businessSectorsEntity,BusinessSectorDto.class);

		for(BusinessSectorsEntity list : businessAreaDao.findAll()) {
			modelMapper.map(list,BusinessSectorDto.class);
			liste.add(modelMapper.map(list,BusinessSectorDto.class));

		}
		return liste.stream().toList();
	}

	@Override
	public Result insert(BusinessSectorDto businessAreas) {

		BusinessSectorsEntity businessSectorsEntity = modelMapper.map(businessAreas,BusinessSectorsEntity.class);

		if(businessAreaDao.findAll().stream().noneMatch(b -> b.getBusinessSectorName().
				equals(businessAreas.getBusinessSectorName()))) {

			this.businessAreaDao.save(businessSectorsEntity);
			return new SuccessResult(true,"İş alanı eklendi");
		}
		else return new UnsuccessfulResult(false , "İş alanı zaten mevcut");
	}



}
