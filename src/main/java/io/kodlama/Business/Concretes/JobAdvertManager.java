package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.JobAdverstisementServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.DataAccess.Abstracts.JobAdvertisementDao;
import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.Mapper.AddJobAdvertDtoConverter;
import io.kodlama.Entites.Mapper.BusinessSectorToEmployerDtoConverter;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdverstisementServices {

    private final EmployerManager employerManager;
    private final JobAdvertisementDao jobAdvertisementDao;
    private final AddJobAdvertDtoConverter addJobAdvertDtoConverter;
    private final BusinessSectorToEmployerDtoConverter businessSectorToEmployerDtoConverter;
    private final BusinessAreaManager businessAreaManager;
    public JobAdvertManager(EmployerManager employerManager, JobAdvertisementDao jobAdvertisementDao, AddJobAdvertDtoConverter addJobAdvertDtoConverter, BusinessSectorToEmployerDtoConverter businessSectorToEmployerDtoConverter, BusinessAreaManager businessAreaManager) {
        this.employerManager = employerManager;
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.addJobAdvertDtoConverter = addJobAdvertDtoConverter;
        this.businessSectorToEmployerDtoConverter = businessSectorToEmployerDtoConverter;
        this.businessAreaManager = businessAreaManager;
    }

    @Override
    public Result addJobAdvert(AddJobAdvertDto addJobAdvertDto) {

            employerManager.getEmployer(addJobAdvertDto.getId());
        JobAdverstisementEntity jobAdverstisementEntity = addJobAdvertDtoConverter.insertJobAdvert(addJobAdvertDto);
        jobAdverstisementEntity.setEmployer(employerManager.getEmployer(addJobAdvertDto.getId()));
        jobAdverstisementEntity.setBusinessSectorsEntity(businessAreaManager.getOne(addJobAdvertDto.getBusinessSectorName()));
       jobAdvertisementDao.save(jobAdverstisementEntity);
       return new SuccessResult(true , "veri kaydedildi");
    }

    public List<AddJobAdvertDto> getAllActiveSectors() {



        return  addJobAdvertDtoConverter.getAllActiveJobAdvert(jobAdvertisementDao.getAllByActive(true));


    }

    @Override
    public List<BusinessSectorToEmployerDto> getAllActiveSectorsDate() {

        return  businessSectorToEmployerDtoConverter.businessSectorToEmployerDtoConverter(jobAdvertisementDao.findByActiveOrderByActiveDateAsc(true));
    }

}
