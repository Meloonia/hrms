package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.JobSeekerService;
import io.kodlama.Business.Abstracts.UserManagerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.JobSeekerManagerDao;
import io.kodlama.DataAccess.Abstracts.UserManagerDao;
import io.kodlama.Entites.Concretes.JobSeekerEntity;

import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.JobSeekerDto;
import io.kodlama.Inmemory.Abstracts.Mernis;
import io.kodlama.Inmemory.Concretes.MernisInMemory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    Mernis mernis = new MernisInMemory();

    JobSeekerManagerDao jobSeekerService;
    UserManagerDao userManagerDao;
    UserManagerServices userManager;
    ModelMapper modelMapper;

    @Autowired
    public JobSeekerManager(JobSeekerManagerDao jobSeekerService, UserManagerDao userManagerDao,
      UserManagerServices userManager , ModelMapper modelMapper ) {

        this.jobSeekerService = jobSeekerService;
        this.userManager = userManager;
        this.userManagerDao = userManagerDao;
        this.modelMapper = modelMapper;

    }


    @Override
    public Result insert(JobSeekerDto jobSeeker) {

        try {

            JobSeekerEntity jobSeekerEntity = new JobSeekerEntity();

            jobSeeker = modelMapper.map(jobSeekerEntity,JobSeekerDto.class);
           if (jobSeeker.getUserEmail() != null && jobSeeker.getRePassword() != null &&
                   jobSeeker.getUserPassword() != null && jobSeeker.getJobSeekerName() != null
                    && jobSeeker.getJobSeekerSurname() != null
                    && jobSeeker.getJobSeekerNationalId() != 0
                    && jobSeeker.getBirtday() != 0
                    && jobSeeker.getJobSeekerPhone() != null
                    && jobSeeker.getJobSeekerAdress() != null) {
               // if (mernis.TCNoDogrula(jobSeeker.getJobSeekerNationalId(),
                  //      jobSeeker.getJobSeekerName()
                    //    , jobSeeker.getJobSeekerSurname(), jobSeeker.getBirtday())) {
               JobSeekerDto finalJobSeeker = jobSeeker;
               if (
                      userManagerDao.findAll().stream().noneMatch(u -> u.getUserEmail().equals(finalJobSeeker.getUserEmail()))) {
                    userManagerDao.findAll().stream().noneMatch((u -> u.getUserEmail().equals(jobSeekerEntity.getUser().getUserEmail())));

                   if (jobSeekerService.findAll().stream().noneMatch(j -> j.getJobSeekerNationalId() ==
                                jobSeekerEntity.getJobSeekerNationalId())) {

                           jobSeekerEntity.setJobSeekerAdress(jobSeeker.getJobSeekerAdress());
                           jobSeekerEntity.setJobSeekerPhone(jobSeeker.getJobSeekerPhone());
                           jobSeekerEntity.setJobSeekerNationalId(jobSeeker.getJobSeekerNationalId());
                           jobSeekerEntity.setJobSeekerName(jobSeeker.getJobSeekerName());
                           jobSeekerEntity.setJobSeekerSurname(jobSeeker.getJobSeekerSurname());
                           jobSeekerEntity.setBirtday(jobSeeker.getBirtday());




                            return new SuccessResult(true, "Kullanıcı başarı ile kaydedildi.");
                        } else return new UnsuccessfulResult(false, "Email Kayıtlı");
                    } else return new UnsuccessfulResult(false, "kullanıcı zaten kayıtlı.");

                } //else return new UnsuccessfulResult(false, "Mernis doğrulanamıyor");
           /* } */  else return new UnsuccessfulResult(false,"Alanlar boş bırakılamaz.");

        }

        catch (Exception e) {

            System.out.println(e.getMessage());
            return new UnsuccessfulResult(false,"Kullanıcı eklenemiyor.");

    }

    }

    @Override
    public List<JobSeekerEntity> getAll() {
        return jobSeekerService.findAll();
    }


}
