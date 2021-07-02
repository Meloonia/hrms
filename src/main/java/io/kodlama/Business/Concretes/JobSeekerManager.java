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
import io.kodlama.Entites.Mapper.JobSeekerDtoConverter;
import io.kodlama.Entites.dto.AccountDto;
import io.kodlama.Entites.dto.JobSeekerDto;
import io.kodlama.Entites.dto.JobSeekerExperienceDto;
import io.kodlama.Entites.dto.JobSeekerSchoolDto;
import io.kodlama.Inmemory.Abstracts.Mernis;
import io.kodlama.Inmemory.Concretes.MernisInMemory;

import io.kodlama.Utils.Controls.JobSeekerControl;

import io.kodlama.Utils.Controls.JobSeekerControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    Mernis fakeMernis = new MernisInMemory();
  private final JobSeekerControlService jobSeekerControl;
  private final JobSeekerManagerDao jobSeekerService;
  private final UserManagerDao userManagerDao;
  private final UserManagerServices userManager;
  private final JobSeekerDtoConverter jobSeekerDtoConverter;

    @Autowired
    public JobSeekerManager(JobSeekerManagerDao jobSeekerService, UserManagerDao userManagerDao,
                            UserManagerServices userManager,
                            JobSeekerControlService jobSeekerControl, JobSeekerDtoConverter jobSeekerDtoConverter) {

        this.jobSeekerService = jobSeekerService;
        this.userManager = userManager;
        this.userManagerDao = userManagerDao;
        this.jobSeekerDtoConverter = jobSeekerDtoConverter;
        this.jobSeekerControl = jobSeekerControl;
    }


    @Override
    public Result insert(JobSeekerDto jobSeeker) {

        try {

            JobSeekerEntity jobSeekerEntity = jobSeekerDtoConverter.jobSeekerDtoConverter(jobSeeker);

           if (jobSeekerControl.nullControl(jobSeeker)) {
              //  if (fakeMernis.TCNoDogrula(jobSeeker.getJobSeekerNationalId(),
                //       jobSeeker.getJobSeekerName()
                  //     , jobSeeker.getJobSeekerSurname(), jobSeeker.getBirtday())) {

               if (
                      jobSeekerControl.emailControl(jobSeeker)) {


                   if (jobSeekerControl.userControl(jobSeeker)) {


                        jobSeekerEntity.setUser(jobSeekerDtoConverter.jobSeekerToUserDtoConverter(jobSeeker));
                           jobSeekerService.save(jobSeekerEntity);





                            return new SuccessResult(true, "Kullanıcı başarı ile kaydedildi.");
                        } else return new UnsuccessfulResult(false, "Email Kayıtlı");
                    } else return new UnsuccessfulResult(false, "kullanıcı zaten kayıtlı.");

                } //else return new UnsuccessfulResult(false, "Mernis doğrulanamıyor");}
               else return new UnsuccessfulResult(false,"Alanlar boş bırakılamaz.");

        }

        catch (Exception e) {

            System.out.println(e.getMessage());
            return new UnsuccessfulResult(false,"Kullanıcı eklenemiyor.");

    }

    }

    @Override
    public List<JobSeekerDto> getAll() {


        return jobSeekerDtoConverter.getAllJobSeekerDtoConverter(jobSeekerService.findAll());
    }

    @Override
    public Result insertJobExperience(JobSeekerExperienceDto jobSeekerExperienceDto) {


        jobSeekerService.save(jobSeekerDtoConverter.jobSeekerExperienceDtoConverter(jobSeekerExperienceDto));
        return new SuccessResult(true,"eklendi.");
    }

    @Override
    public Result insertJobSchool(JobSeekerSchoolDto jobSeekerSchoolDto,long userId) {
        JobSeekerEntity jobSeekerEntity = jobSeekerService.getAllByUser_UserId(userId);

        jobSeekerEntity.setStartYear(jobSeekerSchoolDto.getStartYear());
        jobSeekerEntity.setJobSekerSchool(jobSeekerSchoolDto.getJobSeekerSchool());
        jobSeekerEntity.setGradiuationYear(jobSeekerSchoolDto.getGradiuationYear());
        jobSeekerEntity.setJobSeekerCollageDepartment(jobSeekerSchoolDto.getJobSeekerCollageDepartment());

        jobSeekerService.saveAndFlush(jobSeekerEntity);
        return new SuccessResult(true,"eklendi.");
    }

    @Override
    public Result insertAccount(AccountDto accountDto, long userId) {

    JobSeekerEntity jobSeekerEntity = jobSeekerService.getAllByUser_UserId(userId);
    jobSeekerEntity.setJobSeekerGithubAdress(accountDto.getJobSeekerGithubAdress());
    jobSeekerEntity.setJobSeekerLinkedlnAdress(accountDto.getJobSeekerLinkedlnAdress());

        jobSeekerService.saveAndFlush(jobSeekerEntity);


        return new SuccessResult(true,"eklendi.");
    }


}


