package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.BusinessAreaServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.BusinessAreaDao;
import io.kodlama.DataAccess.Abstracts.JobAdvertisementDao;
import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import io.kodlama.Entites.dto.BusinessSectorDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
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
		businessSectorsEntity= modelMapper.map(businessSectorDto , BusinessSectorsEntity.class);

		for(BusinessSectorsEntity list : businessAreaDao.findAll()) {

			liste.add(modelMapper.map(liste , (Type) BusinessSectorDto.class));

		}
		return liste.stream().toList();
	}

	@Override
	public Result insert(BusinessSectorsEntity businessAreas) {

		if(businessAreaDao.findAll().stream().noneMatch(b -> b.getBusinessSectorName().
				equals(businessAreas.getBusinessSectorName()))) {

			this.businessAreaDao.save(businessAreas);
			return new SuccessResult(true,"İş alanı eklendi");
		}
		else return new UnsuccessfulResult(false , "İş alanı zaten mevcut");
	}

	@Override

	public List<ActiveJobAdverstisementDto> getAllActiveSectors() {

		JobAdverstisementEntity jobAdverstisementEntity = new JobAdverstisementEntity();
		ActiveJobAdverstisementDto jobAdverstisementDto = new ActiveJobAdverstisementDto();
		jobAdverstisementEntity = modelMapper.map(jobAdverstisementDto,JobAdverstisementEntity.class);

		List<ActiveJobAdverstisementDto> list = new ArrayList<>();

		for (JobAdverstisementEntity job: jobAdvertisementDao.findAll()) {

			if(job.isActive()) {
				list.add((ActiveJobAdverstisementDto) list);
			}
		}

	return list.stream().toList();
	}

	@Override
	public List<BusinessSectorToEmployerDto> getAllActiveSectorsDate() {
		return null;
	}


}
