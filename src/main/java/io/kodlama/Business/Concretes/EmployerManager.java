package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.EmployerServices;
import io.kodlama.Business.Abstracts.UserManagerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.EmployersDao;
import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.Mapper.BusinessSectorToEmployerDtoConverter;
import io.kodlama.Entites.Mapper.EmployerDtoConverter;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;
import io.kodlama.Entites.dto.EmployerDto;

import io.kodlama.Entites.dto.getAllEmployerDto;
import io.kodlama.Utils.Controls.EmployerControlService;


import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployerManager implements EmployerServices {

    private final UserManagerServices userManager;
    private final EmployersDao employersDao;
    private final EmployerDtoConverter employerDtoConverter;
    private final EmployerControlService employerControlService;
    private final BusinessSectorToEmployerDtoConverter businessSectorToEmployerDtoConverter;

    public EmployerManager(UserManagerServices userManager, EmployersDao employersDao,
                           EmployerDtoConverter employerDtoConverter,
                           EmployerControlService employerControl,
                           BusinessSectorToEmployerDtoConverter businessSectorToEmployerDtoConverter) {
        this.userManager = userManager;
        this.employersDao = employersDao;
        this.employerDtoConverter = employerDtoConverter;
        this.employerControlService = employerControl;
        this.businessSectorToEmployerDtoConverter = businessSectorToEmployerDtoConverter;
    }

    @Override
    public Result insert(EmployerDto employerEntity) {
        try {
           EmployerEntity employerEntities = employerDtoConverter.insertEmployerDtoConverter(employerEntity);
           UserEntity user = employerDtoConverter.insertuserDtoConverter(employerEntity);


                if (employerControlService.emailControl(employerEntity) &&
                        employerControlService.emailDomainControl(employerEntity)) {

                        employerEntities.setUser(user);
                        employersDao.save(employerEntities);

                        return new SuccessResult(true, "Şirket başarı ile kaydedildi.");

                } else return new UnsuccessfulResult(false, "Email zaten mevcut veya email doğru değil. " );

        } catch (Exception e) {

            return new UnsuccessfulResult(false, e.getMessage());

        }
    }

    @Override
    public List<getAllEmployerDto> getAll() {



        return employerDtoConverter.listAllEmployer(employersDao.findAll());
    }





    @Override
    public List<BusinessSectorToEmployerDto> getAllJobAdvert(EmployerEntity employer) {



       return businessSectorToEmployerDtoConverter.businessSectorToEmployerDtoConverter(
              employersDao.findEmployerEntityByJobAdverstisementEntities(employer.getUser().getUserId()));

    }

    @Override
    public EmployerEntity getEmployer(long userId) {
        return employersDao.getAllByUser_UserId(userId);
    }


}