package io.kodlama.Business.Concretes;

import com.cloudinary.utils.ObjectUtils;
import io.kodlama.Business.Abstracts.JobSeekerCvService;
import io.kodlama.Business.Abstracts.JobSeekerService;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.DataAccess.Abstracts.JobSeekerCvDao;

import io.kodlama.Entites.Concretes.JobSeekerCvEntity;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Mapper.CvDtoConverter;


import io.kodlama.adapters.UploadImageServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
@CrossOrigin
@Service
public class JobSeekerCvManager implements JobSeekerCvService {
    private final  JobSeekerCvDao jobSeekerCvDao;
    private final CvDtoConverter cvDtoConverter;
    private final UploadImageServices uploadImageServices;
    private final JobSeekerService jobSeekerService;


    public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao, CvDtoConverter cvDtoConverter,
                              @Qualifier("cloudinaryAdapter") UploadImageServices cloudinaryAdapter, JobSeekerService jobSeekerService) {
        this.jobSeekerCvDao = jobSeekerCvDao;
        this.cvDtoConverter = cvDtoConverter;

        this.uploadImageServices= cloudinaryAdapter;
        this.jobSeekerService = jobSeekerService;
    }

    @Override
    public Result addCv(long userId, File cvDto) throws IOException {

     //   JobSeekerCvEntity cvEntity = jobSeekerCvDao.findJobSeekerCvEntityByJobSeekerEntity_User_UserId(userId);

     //   if(cvEntity == null) {

            JobSeekerCvEntity cvEntity1  = new JobSeekerCvEntity();
            cvEntity1.setJobSeekerEntity(jobSeekerService.getById((int) userId));
            Map uploadResult =
                    uploadImageServices.CloudinaryAdapter().uploader().upload(cvDto, ObjectUtils.emptyMap());
            cvEntity1.setImageUrl((String) uploadResult.get("url"));
            jobSeekerCvDao.save(cvEntity1);

     //   }

   /*  //   else {

            JobSeekerCvEntity cvEntitiy = jobSeekerCvDao.findJobSeekerCvEntityByJobSeekerEntity_User_UserId(userId);

            Map uploadResult =
                uploadImageServices.CloudinaryAdapter().uploader().upload(cvDto, ObjectUtils.emptyMap());
            cvEntity.setImageUrl((String) uploadResult.get("url"));
            jobSeekerCvDao.save(cvEntity);

        }*/

  // File file  = new File(cvDto.getImageUrl());



        return new SuccessResult(true,"Kaydedildi");
    }
}
