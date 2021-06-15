package io.kodlama.Entites.dto.ConverterDto;

import io.kodlama.DataAccess.Abstracts.JobAdvertisementDao;
import io.kodlama.DataAccess.Abstracts.UserManagerDao;
import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import org.springframework.stereotype.Service;

@Service
public class AddJobDtoConverter {

    private final JobAdvertisementDao jobAdvertisementDao;
    private final UserManagerDao userManagerDao;

    public AddJobDtoConverter(JobAdvertisementDao jobAdvertisementDao, UserManagerDao userManagerDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.userManagerDao = userManagerDao;
    }

    public JobAdverstisementEntity jobAdverstisementConverter(AddJobAdvertDto addJobAdvertDto) {

        JobAdverstisementEntity jobAdverstisementEntity = new JobAdverstisementEntity();
        jobAdverstisementEntity.setOpenPosition(addJobAdvertDto.getOpenPosition());
        jobAdverstisementEntity.setRelaseDate(addJobAdvertDto.getRelaseDate());
        jobAdverstisementEntity.setActiveDate(addJobAdvertDto.getActiveDate());
        jobAdverstisementEntity.setOpenPosition(addJobAdvertDto.getOpenPosition());
        jobAdverstisementEntity.setMinSaray(addJobAdvertDto.getMinSalary());
        jobAdverstisementEntity.setMaxSalary(addJobAdvertDto.getMaxSalary());
        jobAdverstisementEntity.setActive(addJobAdvertDto.isActive());
        jobAdverstisementEntity.setDesciription(addJobAdvertDto.getDesciription());
        return jobAdverstisementEntity;
    }


}
