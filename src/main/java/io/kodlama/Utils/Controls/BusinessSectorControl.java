package io.kodlama.Utils.Controls;

import io.kodlama.DataAccess.Abstracts.EmployersDao;
import io.kodlama.DataAccess.Abstracts.JobAdvertisementDao;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;

import org.springframework.beans.factory.annotation.Autowired;

public class BusinessSectorControl implements BusinessSectorControlService{

    JobAdvertisementDao jobAdvertisementDao;
    EmployersDao employersDao;
    @Autowired
   public BusinessSectorControl(JobAdvertisementDao jobAdvertisementDao , EmployersDao employersDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.employersDao = employersDao;
    }

    @Override
    public boolean BusinessSectorActive(JobAdverstisementEntity jobAdverstisementEntity) {

        if(jobAdverstisementEntity.isActive()) {
            return true;
        }
        else return false;
    }

}
