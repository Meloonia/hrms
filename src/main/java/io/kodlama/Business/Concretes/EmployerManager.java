package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.EmployerServices;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.EmployersDao;
import io.kodlama.Entites.Concretes.EmailValidationEntity;
import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.UserEntity;


import io.kodlama.Inmemory.Concretes.EmailValidationInMemory;
import lombok.NoArgsConstructor;
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
    @Autowired
    public EmployerManager(EmployersDao employersDao, UserManager userManager, SystemManager systemManagerService) {
        this.employersDao = employersDao;
        this.userManager = userManager;
        this.systemManagerService = systemManagerService;
    }


    @Override
    public Result insert(UserEntity user, EmployerEntity employerEntity) {
        try {
            if (
                    user.getUserEmail().length() != 0
                            && user.getUserPassword().length() != 0
                            && user.getRePassword().length() != 0
                            && checkIfMailDomain(employerEntity)
            ) {
                if(emailValidation.EmailDogrula(new EmailValidationEntity(),user)) {
                    if(systemManagerService.employerConfirm()) {
                        userManager.insertUser(user);
                        employersDao.save(employerEntity);
                        return new SuccessResult(true,"Şirket başarı ile kaydedildi.");
                    }
                    else  return new UnsuccessfulResult(false,"Email doğrulanmadı.");
                }
                else return new UnsuccessfulResult(false , "website domaini ile mail domaini aynı olmalı");
            }
            else return new UnsuccessfulResult(false,"Şirket kaydında hata oluştu.");

        } catch (Exception e) {

            return new UnsuccessfulResult(false, "Kullanıcı eklenemiyor.");

        }
    }

    @Override
    public List<EmployerEntity> getAll() {
        return employersDao.findAll();
    }


    public boolean checkIfMailDomain(EmployerEntity employerEntity) {
        String regex = "^[A-Za-z0-9._%+-]+@" + employerEntity.getEmployerWebsite() +"$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employerEntity.getEmployerEmail());
        if(matcher.matches()) {
            return true;
        }else {
            return false;
        }
} }