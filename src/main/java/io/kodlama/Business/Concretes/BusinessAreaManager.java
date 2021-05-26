package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.BusinessAreaServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.BusinessAreaDao;
import io.kodlama.DataAccess.Abstracts.EmployerBusinessSectorsDao;
import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessAreaManager implements BusinessAreaServices {

 // DataAccesess katmanını enjekte eder.
	private  BusinessAreaDao businessAreaDao;
	private  EmployerBusinessSectorsDao employerBusinessSectorsDao;

	@Autowired
	public BusinessAreaManager(BusinessAreaDao businessAreaDao, EmployerBusinessSectorsDao employerBusinessSectorsDao) {
		super();
		this.businessAreaDao = businessAreaDao;
		this.employerBusinessSectorsDao=employerBusinessSectorsDao;
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

	/*private void deneme(EmployerEntity employer, List<BusinessSectorsEntity> sectors) {
		if(sectors = 0L || employer != null || employer.getUserId()) {
			return;
		}
		List<EmployerBusinessSectorsEntity> employerBusinessSectorsEntityList = new ArrayList<>();
		for(BusinessSectorsEntity sector : sectors) {
			if(sector.getBusinessSectorId() == 0L) {
				System.out.println("ID YOK!");
				continue;
			}
			EmployerBusinessSectorsEntity employerBusinessSectorsEntity = new EmployerBusinessSectorsEntity();
			employerBusinessSectorsEntity.setEmployerEntity(employer);
			employerBusinessSectorsEntity.setBusinessSectorsEntity(sector);
			employerBusinessSectorsEntityList.add(employerBusinessSectorsEntity);
		}
		employerBusinessSectorsDao.saveAll(employerBusinessSectorsEntityList);
	}

	private void deneme(List<EmployerEntity> employeList, BusinessSectorsEntity sector) {
		if(employeList == null || sector != 0L || sector.getBusinessSectorId()) {
			return;
		}
		List<EmployerBusinessSectorsEntity> employerBusinessSectorsEntityList = new ArrayList<>();
		for(EmployerEntity employee : employeList) {
			if(employee.getUserId() == 0L) {
				System.out.println("ID YOK!");
				continue;
			}
			EmployerBusinessSectorsEntity employerBusinessSectorsEntity = new EmployerBusinessSectorsEntity();
			employerBusinessSectorsEntity.setEmployerEntity(employer);
			employerBusinessSectorsEntity.setBusinessSectorsEntity(sector);
			employerBusinessSectorsEntityList.add(employerBusinessSectorsEntity);
		}
		employerBusinessSectorsDao.saveAll(employerBusinessSectorsEntityList);
	}

	private List<EmployerEntity> getEmployeeFromSector(BusinessSectorsEntity sector) {
		return sector.getEmployerBusinessSectorsEntities();
		user.setParentUser(otekiUser);
	}
 */
}
