package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.dto.CvDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface JobSeekerCvService {

    Result addCv(long userId, File cvDto) throws IOException;

}
