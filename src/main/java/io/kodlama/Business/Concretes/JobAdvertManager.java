package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.JobAdverstisementServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.DataAccess.Abstracts.JobAdvertisementDao;
import io.kodlama.Entites.Mapper.AddJobAdvertDtoConverter;
import io.kodlama.Entites.Mapper.BusinessSectorToEmployerDtoConverter;
import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;
;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobAdvertManager implements JobAdverstisementServices {


    private final JobAdvertisementDao jobAdvertisementDao;
    private final AddJobAdvertDtoConverter addJobAdvertDtoConverter;
    private final BusinessSectorToEmployerDtoConverter businessSectorToEmployerDtoConverter;
    public JobAdvertManager(JobAdvertisementDao jobAdvertisementDao, AddJobAdvertDtoConverter addJobAdvertDtoConverter, BusinessSectorToEmployerDtoConverter businessSectorToEmployerDtoConverter) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.addJobAdvertDtoConverter = addJobAdvertDtoConverter;
        this.businessSectorToEmployerDtoConverter = businessSectorToEmployerDtoConverter;
    }

    @Override
    public Result addJobAdvert(AddJobAdvertDto addJobAdvertDto) {



       jobAdvertisementDao.save(addJobAdvertDtoConverter.insertJobAdvert(addJobAdvertDto));
       return new SuccessResult(true , "veri kaydedildi");
    }

    public List<ActiveJobAdverstisementDto> getAllActiveSectors() {


        return  (List<ActiveJobAdverstisementDto>) addJobAdvertDtoConverter
              .insertJobAdvert((AddJobAdvertDto) jobAdvertisementDao.findByActiveOrderByActiveDateAsc(true)
                       .stream().toList());


    }

    @Override
    public List<BusinessSectorToEmployerDto> getAllActiveSectorsDate() {

        return  businessSectorToEmployerDtoConverter.businessSectorToEmployerDtoConverter(jobAdvertisementDao.findByActiveOrderByActiveDateAsc(true));
    }

}
