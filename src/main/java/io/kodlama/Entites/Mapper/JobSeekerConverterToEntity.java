package io.kodlama.Entites.Mapper;

import io.kodlama.DataAccess.Abstracts.JobSeekerManagerDao;
import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.dto.CvDto;
import org.springframework.stereotype.Component;

@Component
public class JobSeekerConverterToEntity {

    private final JobSeekerManagerDao jobSeekerManagerDao;

    public JobSeekerConverterToEntity(JobSeekerManagerDao jobSeekerManagerDao) {
        this.jobSeekerManagerDao = jobSeekerManagerDao;
    }

    public JobSeekerEntity jobSeekerUpdateCv(long userId,CvDto cvDto) {

        JobSeekerEntity jobSeekerEntity = jobSeekerManagerDao.getAllByUser_UserId(userId);

        jobSeekerEntity.setJobSeekerName(cvDto.getJobSeekerName());
        jobSeekerEntity.setJobSeekerSurname(cvDto.getJobSeekerSurname());
        jobSeekerEntity.setJobSekerSchool(cvDto.getJobSeekerSchool());
        jobSeekerEntity.setSchoolStartYear(cvDto.getSchoolStartyear());
        jobSeekerEntity.setGradiuationYear(cvDto.getGradiuationYear());
        jobSeekerEntity.setJobSeekerCollageDepartment(cvDto.getJobSeekerCollageDepartment());
        jobSeekerEntity.setJobSeekerNowJob(cvDto.getNowJob());
        jobSeekerEntity.setJobSeekerLinkedlnAdress(cvDto.getJobSeekerLinkedlnAdress());
        jobSeekerEntity.setJobSeekerGithubAdress(cvDto.getJobSeekerGithubAdress());
        jobSeekerEntity.setJobSeekerDesciription(cvDto.getJobSeekerDesciription());
        jobSeekerEntity.setJobSeekerExperience(cvDto.getJobSeekerExperience());

        return jobSeekerEntity;
    }

}
