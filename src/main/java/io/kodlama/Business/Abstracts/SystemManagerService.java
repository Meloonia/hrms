package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.SystemManagerEntity;
import io.kodlama.Entites.dto.SystemManagerDto;

import java.util.List;

public interface SystemManagerService {
    List<SystemManagerEntity> getAll();
    boolean employerConfirm();
    Result insertSystemManager(SystemManagerDto systemManagerDto);

}
