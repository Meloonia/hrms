package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.BusinessAreaServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.BusinessAreaDao;
import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessAreaManager implements BusinessAreaServices {

 // DataAccesess katmanını enjekte eder.
	private BusinessAreaDao businessAreaDao;
	
	@Autowired
	public BusinessAreaManager(BusinessAreaDao businessAreaDao) {
		super();
		this.businessAreaDao = businessAreaDao;
	}

 //Entity katmanından verileri getirir.
	@Override
	public List<BusinessSectorsEntity> getAll() {
	
		return businessAreaDao.findAll();
		
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



}
