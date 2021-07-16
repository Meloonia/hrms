package io.kodlama.Business.Concretes;

import com.cloudinary.utils.ObjectUtils;
import io.kodlama.Business.Abstracts.JobSeekerCvService;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.DataAccess.Abstracts.JobSeekerCvDao;

import io.kodlama.Entites.Mapper.CvDtoConverter;
import io.kodlama.Entites.dto.CvDto;
import io.kodlama.adapters.CloudinaryAdapter;

import io.kodlama.adapters.UploadImageServices;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.IOException;
@Service
public class JobSeekerCvManager implements JobSeekerCvService {
    private final  JobSeekerCvDao jobSeekerCvDao;
  private final CvDtoConverter cvDtoConverter;
    private final UploadImageServices uploadImageServices;


    public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao, CvDtoConverter cvDtoConverter,
                              UploadImageServices cloudinaryAdapter) {
        this.jobSeekerCvDao = jobSeekerCvDao;
        this.cvDtoConverter = cvDtoConverter;

        this.uploadImageServices= cloudinaryAdapter;
    }

    @Override
    public Result addCv(CvDto cvDto) throws IOException {

    File file  = new File(cvDto.getImageUrl());


        uploadImageServices.CloudinaryAdapter().uploader().upload(file, ObjectUtils.emptyMap());
            jobSeekerCvDao.save(cvDtoConverter.cvDtoConverter(cvDto));

        return new SuccessResult(true,"Kaydedildi");
    }
}
