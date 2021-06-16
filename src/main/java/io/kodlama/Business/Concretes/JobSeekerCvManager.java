package io.kodlama.Business.Concretes;

import com.cloudinary.utils.ObjectUtils;
import io.kodlama.Business.Abstracts.JobSeekerCvService;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.DataAccess.Abstracts.JobSeekerCvDao;

import io.kodlama.Entites.Mapper.CvDtoConverter;
import io.kodlama.Entites.dto.CvDto;
import io.kodlama.adapters.CloudinaryAdapter;

import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class JobSeekerCvManager implements JobSeekerCvService {
    private final  JobSeekerCvDao jobSeekerCvDao;
  private final CvDtoConverter cvDtoConverter;
    private final   CloudinaryAdapter cloudinaryAdapter;


    public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao, CvDtoConverter cvDtoConverter, CloudinaryAdapter cloudinaryAdapter) {
        this.jobSeekerCvDao = jobSeekerCvDao;
        this.cvDtoConverter = cvDtoConverter;

        this.cloudinaryAdapter= cloudinaryAdapter;
    }

    @Override
    public Result addCv(CvDto cvDto) throws IOException {


        cloudinaryAdapter.CloudinaryAdapter().uploader().upload(cvDto.getImageUrl(), ObjectUtils.emptyMap());
            jobSeekerCvDao.save(cvDtoConverter.cvDtoConverter(cvDto));

        return new SuccessResult(true,"Kaydedildi");
    }
}
