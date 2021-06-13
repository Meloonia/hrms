package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.CvDto;

import java.io.IOException;

public interface JobSeekerCvService {

    Result addCv(CvDto cvDto) throws IOException;

}
