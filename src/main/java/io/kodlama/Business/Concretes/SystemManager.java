package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.SystemManagerService;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.DataAccess.Abstracts.SystemManagerDao;
import io.kodlama.Entites.Concretes.SystemManagerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.Mapper.SystemManagerDtoConverter;
import io.kodlama.Entites.dto.SystemManagerDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SystemManager implements SystemManagerService {

   private final SystemManagerDao systemManagerDao;
   private final SystemManagerDtoConverter systemManagerDtoConverter;

    public SystemManager(SystemManagerDao systemManagerDao, SystemManagerDtoConverter systemManagerDtoConverter) {
        this.systemManagerDao = systemManagerDao;
        this.systemManagerDtoConverter = systemManagerDtoConverter;
    }

    @Override
    public List<SystemManagerEntity> getAll() {
        return this.systemManagerDao.findAll();
    }

    @Override
    public boolean employerConfirm() {
        return true;
    }

    @Override
    public Result insertSystemManager(SystemManagerDto systemManagerDto) {

        SystemManagerEntity systemManagerEntity = new SystemManagerEntity();
        UserEntity user = new UserEntity();

        systemManagerDtoConverter.SystemManagerDtoConvertEntity(systemManagerDto);
        systemManagerDtoConverter.SystemManagerDtoConverterUserEntity(systemManagerDto);
        systemManagerEntity.setUser(user);

        systemManagerDao.save(systemManagerEntity);

        return new SuccessResult(true,"Başarı ile kaydedildi.");
    }
}
