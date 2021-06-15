package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.JobAdverstisementServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.DataAccess.Abstracts.JobAdvertisementDao;
import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;

import io.kodlama.Entites.dto.ConverterDto.ActiveJobAdvertisementDtoConverter;
import io.kodlama.Entites.dto.ConverterDto.AddJobDtoConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobAdvertManager implements JobAdverstisementServices {

    private final ModelMapper modelMapper;
    private final JobAdvertisementDao jobAdvertisementDao;
    private final AddJobDtoConverter jobDtoConverter;
    private final ActiveJobAdvertisementDtoConverter activeJobAdvertisementDtoConverter;
    @Autowired
    private  JobAdvertManager(ModelMapper modelMapper , JobAdvertisementDao jobAdvertisementDao,
                              ActiveJobAdvertisementDtoConverter activeJobAdvertisementDtoConverter, AddJobDtoConverter addJobDtoConverter) {
        this.modelMapper=modelMapper;
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.jobDtoConverter = addJobDtoConverter;
        this.activeJobAdvertisementDtoConverter = activeJobAdvertisementDtoConverter;
    }


        @Override
    public Result addJobAdvert(AddJobAdvertDto addJobAdvertDto) {

        //JobAdverstisementEntity jobAdverstisementEntity = modelMapper.map(addJobAdvertDto,JobAdverstisementEntity.class);

       jobAdvertisementDao.save(jobDtoConverter.jobAdverstisementConverter(addJobAdvertDto));
       return new SuccessResult(true , "veri kaydedildi");
    }

    public List<ActiveJobAdverstisementDto> getAllActiveSectors() {


        ActiveJobAdverstisementDto jobAdverstisementDto = new ActiveJobAdverstisementDto();
        JobAdverstisementEntity jobAdverstisementEntity  = modelMapper.map(jobAdverstisementDto,JobAdverstisementEntity.class);

        List<ActiveJobAdverstisementDto> list = new ArrayList<>();

        for (JobAdverstisementEntity job: jobAdvertisementDao.findAll()) {

            if(job.isActive()) {
                list.add((modelMapper.map(list , ActiveJobAdverstisementDto.class)));
            }
        }

        return list;


    }

    @Override
    public List<BusinessSectorToEmployerDto> getAllActiveSectorsDate() {

        JobAdverstisementEntity jobAdverstisementEntity = new JobAdverstisementEntity();
        BusinessSectorToEmployerDto businessSectorToEmployerDto = new BusinessSectorToEmployerDto();
        jobAdverstisementEntity = modelMapper.map(businessSectorToEmployerDto,JobAdverstisementEntity.class);


        List<BusinessSectorToEmployerDto> list = new ArrayList<>();

        for (JobAdverstisementEntity job: jobAdvertisementDao.findAll()) {

            if(true) {
                list.add((modelMapper.map(list , BusinessSectorToEmployerDto.class)));
            }
        }
        return list.stream().toList();
    }

}
