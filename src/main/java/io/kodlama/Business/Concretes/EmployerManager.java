package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.EmployerServices;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.EmployersDao;

import io.kodlama.Entites.Concretes.EmployerEntity;

import io.kodlama.Entites.Concretes.UserEntity;


import io.kodlama.Entites.dto.EmployerDto;
import io.kodlama.Inmemory.Concretes.EmailValidationInMemory;
import io.kodlama.Utils.Controls.EmployerControlService;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@NoArgsConstructor
public class EmployerManager implements EmployerServices {
    EmailValidationInMemory emailValidation = new EmailValidationInMemory();
    EmployersDao employersDao;
    UserManager userManager;
    SystemManager systemManagerService;
    ModelMapper modelMapper;
    EmployerControlService employerControlService;

    @Autowired
    public EmployerManager(EmployersDao employersDao, UserManager userManager,
                           SystemManager systemManagerService, ModelMapper modelMapper
            , EmployerControlService employerControlService) {
        this.employersDao = employersDao;
        this.userManager = userManager;
        this.systemManagerService = systemManagerService;
        this.modelMapper = modelMapper;
        this.employerControlService = employerControlService;
    }


    @Override
    public Result insert(EmployerDto employerEntity) {
        try {
            EmployerEntity employerEntities = modelMapper.map(employerEntity, EmployerEntity.class);


            if (
                    employerControlService.nameLenghtControl(employerEntity)
            ) {
                if (employerControlService.emailControl(employerEntity)) {
                    if (employerControlService.emailDomainControl(employerEntity)) {
                        modelMapper.map(employerEntities, EmployerEntity.class);
                        userManager.insertUser(modelMapper.map(employerEntity, UserEntity.class));
                        employersDao.save(employerEntities);
                        return new SuccessResult(true, "Şirket başarı ile kaydedildi.");
                    } else return new UnsuccessfulResult(false, "isimler 2 harften fazla olmalıdır");
                } else return new UnsuccessfulResult(false, "Email zaten mevcut");
            } else return new UnsuccessfulResult(false, "Email Doğrulanamadı");

        } catch (Exception e) {

            return new UnsuccessfulResult(false, "Kullanıcı eklenemiyor.");

        }
    }

    @Override
    public List<EmployerEntity> getAll() {
        return employersDao.findAll();
    }


}