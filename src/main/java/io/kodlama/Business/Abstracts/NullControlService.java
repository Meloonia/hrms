package io.kodlama.Business.Abstracts;

import io.kodlama.Entites.dto.JobSeekerDto;

public interface NullControlService {

    boolean nullControl(JobSeekerDto jobSeekerDto);
    boolean emailControl(JobSeekerDto jobSeekerDto);
    boolean userControl(JobSeekerDto jobSeekerDto);


}
