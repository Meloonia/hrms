package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.NullControlService;
import io.kodlama.DataAccess.Abstracts.JobSeekerManagerDao;
import io.kodlama.DataAccess.Abstracts.UserManagerDao;
import io.kodlama.Entites.dto.JobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class JobSeekerControl implements NullControlService {

    private final UserManagerDao userManagerDao;
    private final JobSeekerManagerDao jobSeekerManagerDao;

    @Autowired

    public JobSeekerControl(UserManagerDao userManagerDao, JobSeekerManagerDao jobSeekerManagerDao) {
        this.userManagerDao = userManagerDao;
        this.jobSeekerManagerDao = jobSeekerManagerDao;
    }

    @Override
    public boolean nullControl(JobSeekerDto jobSeekerDto) {

        return jobSeekerDto.getUserEmail() != null && jobSeekerDto.getRePassword() != null &&
                jobSeekerDto.getUserPassword() != null && jobSeekerDto.getJobSeekerName() != null
                && jobSeekerDto.getJobSeekerSurname() != null
                && jobSeekerDto.getJobSeekerNationalId() != 0
                && jobSeekerDto.getBirtday() != 0
                && jobSeekerDto.getJobSeekerPhone() != null
                && jobSeekerDto.getJobSeekerAdress() != null;

    }

    @Override
    public boolean emailControl(JobSeekerDto jobSeekerDto) {
        return userManagerDao.findAll().stream().noneMatch(u -> u.getUserEmail().equals(jobSeekerDto.getUserEmail()));
    }

    @Override
    public boolean userControl(JobSeekerDto jobSeekerDto) {
        return jobSeekerManagerDao.findAll().stream().noneMatch(j -> j.getJobSeekerNationalId() ==
                jobSeekerDto.getJobSeekerNationalId());

    }
}