package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.JobSeekerService;
import io.kodlama.Business.Abstracts.UserManagerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessDataResult;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.JobSeekerManagerDao;
import io.kodlama.DataAccess.Abstracts.UserManagerDao;
import io.kodlama.Entites.Concretes.JobSeekerEntity;

import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.Mapper.JobSeekerDtoConverter;
import io.kodlama.Entites.dto.*;

import io.kodlama.Utils.Controls.JobSeekerControlService;

import io.kodlama.adapters.MernisService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {


    private final JobSeekerControlService jobSeekerControl;
    private final JobSeekerManagerDao jobSeekerService;
    private final UserManagerDao userManagerDao;
    private final UserManagerServices userManager;
    private final JobSeekerDtoConverter jobSeekerDtoConverter;
    private final MernisService mernis;

    public JobSeekerManager(JobSeekerManagerDao jobSeekerService, UserManagerDao userManagerDao,
                            UserManagerServices userManager,
                            JobSeekerControlService jobSeekerControl, JobSeekerDtoConverter jobSeekerDtoConverter,
                            @Qualifier("mernis") MernisService mernis) {

        this.jobSeekerService = jobSeekerService;
        this.userManager = userManager;
        this.userManagerDao = userManagerDao;
        this.jobSeekerDtoConverter = jobSeekerDtoConverter;
        this.jobSeekerControl = jobSeekerControl;

        this.mernis = mernis;
    }


    @Override
    public Result insert(JobSeekerDto jobSeeker) {

        try {

            JobSeekerEntity jobSeekerEntity = jobSeekerDtoConverter.jobSeekerDtoConverter(jobSeeker);
            UserEntity user = jobSeekerDtoConverter.jobSeekerToUserDtoConverter(jobSeeker);
            user.setRole("JOBSEEKER");

            if (mernis.mernis().TCKimlikNoDogrula(jobSeeker.getJobSeekerNationalId(),
                    jobSeeker.getJobSeekerName().toUpperCase()
                    , jobSeeker.getJobSeekerSurname().toUpperCase(), jobSeeker.getBirtday())) {

                if (
                        jobSeekerControl.emailControl(jobSeeker) && jobSeekerControl.userControl(jobSeeker)) {

                    jobSeekerEntity.setUser(user);
                    jobSeekerService.save(jobSeekerEntity);


                    return new SuccessResult(true, "Kullanıcı başarı ile kaydedildi.");
                } else return new UnsuccessfulResult(false, "Email veya Kullanıcı Kayıtlı");
            } else return new UnsuccessfulResult(false, "Mernis doğrulanamıyor");
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new UnsuccessfulResult(false, "Kullanıcı eklenemiyor.");

        }

    }

    @Override
    public List<JobSeekerDto> getAll() {


        return jobSeekerDtoConverter.getAllJobSeekerDtoConverter(jobSeekerService.findAll());
    }

    @Override
    public Result insertJobExperience(JobSeekerExperienceDto jobSeekerExperienceDto) {


        jobSeekerService.save(jobSeekerDtoConverter.jobSeekerExperienceDtoConverter(jobSeekerExperienceDto));
        return new SuccessResult(true, "eklendi.");
    }

    @Override
    public Result insertJobSchool(JobSeekerSchoolDto jobSeekerSchoolDto, long userId) {
        JobSeekerEntity jobSeekerEntity = jobSeekerService.getAllByUser_UserId(userId);

        jobSeekerEntity.setSchoolStartYear(jobSeekerSchoolDto.getStartYear());
        jobSeekerEntity.setJobSekerSchool(jobSeekerSchoolDto.getJobSeekerSchool());
        jobSeekerEntity.setGradiuationYear(jobSeekerSchoolDto.getGradiuationYear());
        jobSeekerEntity.setJobSeekerCollageDepartment(jobSeekerSchoolDto.getJobSeekerCollageDepartment());

        jobSeekerService.saveAndFlush(jobSeekerEntity);
        return new SuccessResult(true, "eklendi.");
    }

    @Override
    public Result LinkedLnUpdate(LinkedLnPatchDto linkedLnPatchDto, long userId) {

        JobSeekerEntity jobSeekerEntity = jobSeekerService.getAllByUser_UserId(userId);

        jobSeekerEntity.setJobSeekerLinkedlnAdress(linkedLnPatchDto.getJobSeekerLinkedlnAdress());

        jobSeekerService.saveAndFlush(jobSeekerEntity);


        return new SuccessResult(true, "eklendi.");
    }

    @Override
    public Result gitHubUpdate(GithubPatchDto githubPatchDto, long userId) {

        JobSeekerEntity jobSeekerEntity = jobSeekerService.getAllByUser_UserId(userId);

        jobSeekerEntity.setJobSeekerGithubAdress(githubPatchDto.getJobSeekerGithubAdress());

        jobSeekerService.saveAndFlush(jobSeekerEntity);


        return new SuccessResult(true, "eklendi.");
    }

    @Override
    public JobSeekerEntity getById(long id) {

        return jobSeekerService.getAllByUser_UserId(id);

    }


}


