package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.SystemManagerService;
import io.kodlama.DataAccess.Abstracts.SystemManagerDao;
import io.kodlama.Entites.Concretes.SystemManagerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SystemManager implements SystemManagerService {

    SystemManagerDao systemManagerDao;
    @Autowired
    public SystemManager(SystemManagerDao systemManagerDao) {
        this.systemManagerDao = systemManagerDao;
    }

    @Override
    public List<SystemManagerEntity> getAll() {
        return this.systemManagerDao.findAll();
    }

    @Override
    public boolean employerConfirm() {
        return true;
    }
}
