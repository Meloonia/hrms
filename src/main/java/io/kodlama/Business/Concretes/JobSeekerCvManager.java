package io.kodlama.Business.Concretes;

import com.cloudinary.utils.ObjectUtils;
import io.kodlama.Business.Abstracts.JobSeekerCvService;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.DataAccess.Abstracts.JobSeekerCvDao;
import io.kodlama.Entites.Concretes.JobSeekerCvEntity;
import io.kodlama.Entites.dto.CvDto;
import io.kodlama.adapters.CloudinaryAdapter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class JobSeekerCvManager implements JobSeekerCvService {
    JobSeekerCvDao jobSeekerCvDao;
    ModelMapper modelMapper;
    CloudinaryAdapter cloudinaryAdapter;

    @Autowired
    public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao,ModelMapper modelMapper,CloudinaryAdapter cloudinaryAdapter) {
        this.jobSeekerCvDao = jobSeekerCvDao;
        this.modelMapper = modelMapper;
        this.cloudinaryAdapter= cloudinaryAdapter;
    }

    @Override
    public Result addCv(CvDto cvDto) throws IOException {

        JobSeekerCvEntity jobSeekerCvEntity = modelMapper.map(cvDto ,JobSeekerCvEntity.class );
            cloudinaryAdapter.CloudinaryAdapter().uploader().upload(cvDto.getImageUrl(), ObjectUtils.emptyMap());
            jobSeekerCvDao.save(jobSeekerCvEntity);


        return new SuccessResult(true,"Kaydedildi");
    }
}
