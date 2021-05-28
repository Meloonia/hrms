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
import io.kodlama.Inmemory.Abstracts.Mernis;
import io.kodlama.Inmemory.Concretes.MernisInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    Mernis mernis = new MernisInMemory();

    JobSeekerManagerDao jobSeekerService;
    UserManagerDao userManagerDao;
    UserManagerServices userManager;

    @Autowired
    public JobSeekerManager(JobSeekerManagerDao jobSeekerService, UserManagerDao userManagerDao,
      UserManagerServices userManager ) {

        this.jobSeekerService = jobSeekerService;
        this.userManager = userManager;
        this.userManagerDao = userManagerDao;

    }

    @Override
    public Result insert(UserEntity user, JobSeekerEntity jobSeeker) {

        try {
            if (user.getUserEmail() != null && user.getRePassword() != null &&
                    user.getRePassword() != null && jobSeeker.getJobSeekerName() != null
                    && jobSeeker.getJobSeekerSurname() != null
                    && jobSeeker.getJobSeekerNationalId() != 0
                    && jobSeeker.getBirtday() != 0
                    && jobSeeker.getJobSeekerPhone() != null
                    && jobSeeker.getJobSeekerAdress() != null) {
               // if (mernis.TCNoDogrula(jobSeeker.getJobSeekerNationalId(),
                  //      jobSeeker.getJobSeekerName()
                    //    , jobSeeker.getJobSeekerSurname(), jobSeeker.getBirtday())) {
                    if (
                            userManagerDao.findAll().stream().noneMatch(u -> u.getUserEmail().equals(user.getUserEmail()))) {

                        if (jobSeekerService.findAll().stream().noneMatch(j -> j.getJobSeekerNationalId() ==
                                jobSeeker.getJobSeekerNationalId())) {

                             userManager.insertUser(user);
                            jobSeekerService.save(jobSeeker);
                            return new SuccessResult(true, "Kullanıcı başarı ile kaydedildi.");
                        } else return new UnsuccessfulResult(false, "Email Kayıtlı");
                    } else return new UnsuccessfulResult(false, "kullanıcı zaten kayıtlı.");

                } //else return new UnsuccessfulResult(false, "Mernis doğrulanamıyor");
           /* } */  else return new UnsuccessfulResult(false,"Alanlar boş bırakılamaz.");

        }

        catch (Exception e) {

            return new UnsuccessfulResult(false,"Kullanıcı eklenemiyor.");

    }

    }

    @Override
    public List<JobSeekerEntity> getAll() {
        return jobSeekerService.findAll();
    }
}
