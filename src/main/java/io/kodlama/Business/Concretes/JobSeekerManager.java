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
import io.kodlama.Entites.dto.JobSeekerExperienceDto;
import io.kodlama.Entites.dto.JobSeekerSchoolDto;
import io.kodlama.Inmemory.Abstracts.Mernis;
import io.kodlama.Inmemory.Concretes.MernisInMemory;

import io.kodlama.Utils.Controls.JobSeekerControl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    Mernis mernis = new MernisInMemory();
    JobSeekerControl jobSeekerControl;
    JobSeekerManagerDao jobSeekerService;
    UserManagerDao userManagerDao;
    UserManagerServices userManager;
    ModelMapper modelMapper;

    @Autowired
    public JobSeekerManager(JobSeekerManagerDao jobSeekerService, UserManagerDao userManagerDao,
                            UserManagerServices userManager , ModelMapper modelMapper ,
                            JobSeekerControl jobSeekerControl) {

        this.jobSeekerService = jobSeekerService;
        this.userManager = userManager;
        this.userManagerDao = userManagerDao;
        this.modelMapper = modelMapper;
        this.jobSeekerControl = jobSeekerControl;
    }


    @Override
    public Result insert(JobSeekerDto jobSeeker) {

        try {

            JobSeekerEntity jobSeekerEntity;

            jobSeekerEntity = modelMapper.map(jobSeeker,JobSeekerEntity.class);

           if (jobSeekerControl.nullControl(jobSeeker)) {
               // if (mernis.TCNoDogrula(jobSeeker.getJobSeekerNationalId(),
                  //      jobSeeker.getJobSeekerName()
                    //    , jobSeeker.getJobSeekerSurname(), jobSeeker.getBirtday())) {

               if (
                      jobSeekerControl.emailControl(jobSeeker)) {


                   if (jobSeekerControl.userControl(jobSeeker)) {

                       modelMapper.map(jobSeekerEntity , JobSeekerEntity.class);
                           userManager.insertUser(modelMapper.map(jobSeeker , UserEntity.class));
                           jobSeekerService.save(jobSeekerEntity);




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

    @Override
    public Result insertJobExperience(JobSeekerExperienceDto jobSeekerExperienceDto) {
        JobSeekerEntity jobSeekerEntity = new JobSeekerEntity();
        modelMapper.map(jobSeekerEntity,JobSeekerExperienceDto.class);
        jobSeekerService.save(jobSeekerEntity);
        return new SuccessResult(true,"eklendi.");
    }

    @Override
    public Result insertJobSchool(JobSeekerSchoolDto jobSeekerSchoolDto) {
        JobSeekerEntity jobSeekerEntity = new JobSeekerEntity();
        modelMapper.map(jobSeekerEntity,JobSeekerExperienceDto.class);
        jobSeekerService.save(jobSeekerEntity);
        return new SuccessResult(true,"eklendi.");
    }

    @Override
    public List<JobSeekerEntity> getDateSchoolYear() {
        return jobSeekerService.getAllByGradiuationYear();
    }


}
