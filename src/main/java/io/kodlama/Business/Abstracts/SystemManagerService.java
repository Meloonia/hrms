package io.kodlama.Business.Abstracts;

import io.kodlama.Entites.Concretes.SystemManagerEntity;

import java.util.List;

public interface SystemManagerService {
    List<SystemManagerEntity> getAll();
    boolean employerConfirm();

}
