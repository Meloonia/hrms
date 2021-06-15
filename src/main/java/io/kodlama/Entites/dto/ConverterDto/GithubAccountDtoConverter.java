package io.kodlama.Entites.dto.ConverterDto;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.dto.AccountDto;

public class GithubAccountDtoConverter {

    private final AccountDto accountDto;
    private final JobSeekerEntity jobSeekerEntity;
    public GithubAccountDtoConverter(AccountDto accountDto,JobSeekerEntity jobSeekerEntity) {
        this.accountDto = accountDto;
        this.jobSeekerEntity=jobSeekerEntity;
    }

    public JobSeekerEntity converter(String githubAdress) {

        jobSeekerEntity.setJobSeekerGithubAdress(githubAdress);

        return jobSeekerEntity;
    }

}
