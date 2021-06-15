package io.kodlama.Entites.dto.ConverterDto;

import io.kodlama.Entites.Concretes.JobSeekerEntity;
import io.kodlama.Entites.dto.AccountDto;

public class LinkedlnAccountDtoConverter {

    private final AccountDto accountDto;
    private final JobSeekerEntity jobSeekerEntity;
    public LinkedlnAccountDtoConverter(AccountDto accountDto,JobSeekerEntity jobSeekerEntity) {
        this.accountDto = accountDto;
        this.jobSeekerEntity=jobSeekerEntity;
    }

    public JobSeekerEntity converter(String linkedlnAdress) {

        jobSeekerEntity.setJobSeekerGithubAdress(linkedlnAdress);

        return jobSeekerEntity;
    }
}
