package io.kodlama.Utils.Controls;

import io.kodlama.Entites.dto.JobSeekerDto;

public interface JobSeekerControlService {

    boolean nullControl(JobSeekerDto jobSeekerDto);
    boolean emailControl(JobSeekerDto jobSeekerDto);
    boolean userControl(JobSeekerDto jobSeekerDto);


}
