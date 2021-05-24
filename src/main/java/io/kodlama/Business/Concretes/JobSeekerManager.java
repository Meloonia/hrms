package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.JobSeekerService;
import io.kodlama.Business.Abstracts.UserManagerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.JobSeekerManagerDao;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.adapters.Inmemory.Abstracts.Mernis;
import io.kodlama.adapters.Inmemory.Concretes.MernisInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerManager implements JobSeekerService {

    Mernis mernis = new MernisInMemory();
    JobSeekerManagerDao jobSeekerService;
    UserManagerServices usermanager;
    @Autowired
    public JobSeekerManager(JobSeekerManagerDao jobSeekerService, UserManagerServices userManager) {

        this.jobSeekerService = jobSeekerService;
        this.usermanager = userManager;
    }

    @Override
    public Result insert(UserEntity user, JobSeekerEntity jobSeeker) {

        try {
            if(mernis.TCNoDogrula(jobSeeker.getJobSeekerNationalId() ,
                    jobSeeker.getJobSeekerName().toUpperCase()
                    , jobSeeker.getJobSeekerSurname().toUpperCase(),jobSeeker.getBirtday())) {
                if (
                        jobSeekerService.findAll().stream().anyMatch(j -> j.getJobSeekerNationalId() ==
                                jobSeeker.getJobSeekerNationalId())) {
                    usermanager.insertUser(user);
                    jobSeekerService.save(jobSeeker);

                    return new SuccessResult(true,"Kullanıcı başarı ile kaydedildi.");
            }
                        else return new UnsuccessfulResult(false, "kullanıcı zaten kayıtlı.");
                }
            else return new UnsuccessfulResult(false,"Mernis doğrulanamıyor");


        }
        catch (Exception e) {

            return new UnsuccessfulResult(false,"Kullanıcı eklenemiyor.");

    }

    }
}
