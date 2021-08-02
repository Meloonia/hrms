package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.BusinessAreaServices;
import io.kodlama.Business.Abstracts.EmployerServices;
import io.kodlama.Business.Abstracts.JobAdverstisementServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.DataAccess.Abstracts.CityDao;
import io.kodlama.DataAccess.Abstracts.EmployersDao;
import io.kodlama.DataAccess.Abstracts.JobAdvertisementDao;
import io.kodlama.Entites.Concretes.*;
import io.kodlama.Entites.Mapper.ActiveJobAdverstisementDtoConverter;
import io.kodlama.Entites.Mapper.AddJobAdvertDtoConverter;
import io.kodlama.Entites.Mapper.BusinessSectorToEmployerDtoConverter;
import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdverstisementServices {

    private final EmployerServices employerManager;
    private final JobAdvertisementDao jobAdvertisementDao;
    private final AddJobAdvertDtoConverter addJobAdvertDtoConverter;
    private final BusinessSectorToEmployerDtoConverter businessSectorToEmployerDtoConverter;
    private final BusinessAreaServices businessAreaManager;
    private final ActiveJobAdverstisementDtoConverter activeJobAdverstisementDtoConverter;
    private final EmployersDao employersDao;
    private final CityDao cityDao;
    public JobAdvertManager(EmployerServices employerManager, JobAdvertisementDao jobAdvertisementDao,
                            AddJobAdvertDtoConverter addJobAdvertDtoConverter,
                            BusinessSectorToEmployerDtoConverter businessSectorToEmployerDtoConverter,
                            BusinessAreaServices businessAreaManager,
                            ActiveJobAdverstisementDtoConverter activeJobAdverstisementDtoConverter, EmployersDao employersDao, CityDao cityDao) {
        this.employerManager = employerManager;
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.addJobAdvertDtoConverter = addJobAdvertDtoConverter;
        this.businessSectorToEmployerDtoConverter = businessSectorToEmployerDtoConverter;
        this.businessAreaManager = businessAreaManager;
        this.activeJobAdverstisementDtoConverter = activeJobAdverstisementDtoConverter;
        this.employersDao = employersDao;
        this.cityDao = cityDao;
    }



    public List<ActiveJobAdverstisementDto> getAllActiveSectors() {



        return  activeJobAdverstisementDtoConverter.getAllActiveJobAdvert(jobAdvertisementDao.getAllByActive(true));


    }

    @Override
    public List<BusinessSectorToEmployerDto> getAllActiveSectorsDate() {

        return  businessSectorToEmployerDtoConverter.businessSectorToEmployerDtoConverter(jobAdvertisementDao.findByActiveOrderByActiveDateAsc(true));
    }

    @Override
    public Result addJobAdvert(Long userId, AddJobAdvertDto addJobAdvertDto) {

        JobAdverstisementEntity jobAdverstisementEntity = addJobAdvertDtoConverter.insertJobAdvert(addJobAdvertDto);
        EmployerEntity  employer = employersDao.getEmployerEntityByUser_UserId(userId);
        BusinessSectorsEntity businessSectorsEntity = businessAreaManager.getOne(addJobAdvertDto.getBusinessSectorName());
        UserEntity user = employer.getUser();
        CityEntity city = cityDao.findByCityName(addJobAdvertDto.getCityName());
        jobAdverstisementEntity.setCityEntites(city);
        jobAdverstisementEntity.setEmployer(employer);
        jobAdverstisementEntity.setBusinessSectorsEntity(businessSectorsEntity);
        jobAdverstisementEntity.setUserEntity(user);
        jobAdvertisementDao.save(jobAdverstisementEntity);
        return new SuccessResult(true , "veri kaydedildi");
    }



}
