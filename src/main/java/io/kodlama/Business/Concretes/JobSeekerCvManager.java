package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.JobSeekerCvService;
import io.kodlama.Business.Abstracts.JobSeekerService;
import io.kodlama.Business.Abstracts.UserManagerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.DataAccess.Abstracts.JobSeekerCvDao;

import io.kodlama.Entites.Concretes.JobSeekerCvEntity;
import io.kodlama.Entites.Mapper.CvDtoConverter;


import io.kodlama.Entites.Mapper.JobSeekerConverterToEntity;
import io.kodlama.Entites.dto.CvDto;
import io.kodlama.adapters.UploadImageServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Service
public class JobSeekerCvManager implements JobSeekerCvService {
    private final  JobSeekerCvDao jobSeekerCvDao;
    private final CvDtoConverter cvDtoConverter;
    private final UploadImageServices uploadImageServices;
    private final JobSeekerService jobSeekerService;
    private final UserManagerServices userManagerServices;
    private final JobSeekerConverterToEntity jobSeekerConverterToEntity;


    public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao, CvDtoConverter cvDtoConverter,
                              @Qualifier("cloudinaryAdapter") UploadImageServices cloudinaryAdapter, JobSeekerService jobSeekerService, UserManagerServices userManagerServices, JobSeekerConverterToEntity jobSeekerConverterToEntity) {
        this.jobSeekerCvDao = jobSeekerCvDao;
        this.cvDtoConverter = cvDtoConverter;

        this.uploadImageServices= cloudinaryAdapter;
        this.jobSeekerService = jobSeekerService;
        this.userManagerServices = userManagerServices;
        this.jobSeekerConverterToEntity = jobSeekerConverterToEntity;
    }

    @Override
    public Result addCv(long userId, CvDto cvDto)  {

        JobSeekerCvEntity cvEntity  = jobSeekerCvDao.findJobSeekerCvEntityByJobSeekerEntity_User_UserId(userId);
        cvEntity.setImageUrl(cvDto.getJobSeekerPhotoAdress());
        cvEntity.setJobSeekerEntity(jobSeekerConverterToEntity.jobSeekerUpdateCv(userId,cvDto));

        jobSeekerCvDao.saveAndFlush(cvEntity);
        return new SuccessResult(true,"Kaydedildi");
    }

}
