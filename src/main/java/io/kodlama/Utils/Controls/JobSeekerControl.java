package io.kodlama.Utils.Controls;

import io.kodlama.DataAccess.Abstracts.JobSeekerManagerDao;
import io.kodlama.DataAccess.Abstracts.UserManagerDao;
import io.kodlama.Entites.dto.JobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public
class JobSeekerControl implements JobSeekerControlService {

    private final UserManagerDao userManagerDao;
    private final JobSeekerManagerDao jobSeekerManagerDao;



    public JobSeekerControl(UserManagerDao userManagerDao, JobSeekerManagerDao jobSeekerManagerDao) {
        this.userManagerDao = userManagerDao;
        this.jobSeekerManagerDao = jobSeekerManagerDao;
    }

    @Override
    public boolean nullControl(JobSeekerDto jobSeekerDto) {

        return  jobSeekerDto.getJobSeekerSurname() != null
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