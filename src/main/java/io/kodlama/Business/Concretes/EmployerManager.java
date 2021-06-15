package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.EmployerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.EmployersDao;
import io.kodlama.DataAccess.Abstracts.JobAdvertisementDao;
import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;
import io.kodlama.Entites.dto.EmployerDto;
import io.kodlama.Inmemory.Concretes.EmailValidationInMemory;
import io.kodlama.Utils.Controls.EmployerControlService;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class EmployerManager implements EmployerServices {

    EmployersDao employersDao;
    UserManager userManager;
    SystemManager systemManagerService;
    ModelMapper modelMapper;
    EmployerControlService employerControlService;
    JobAdvertisementDao jobAdvertisementDao;
    @Autowired
    public EmployerManager(EmployersDao employersDao, UserManager userManager,
                           SystemManager systemManagerService, ModelMapper modelMapper
            , EmployerControlService employerControlService , JobAdvertisementDao jobAdvertisementDao) {
        this.employersDao = employersDao;
        this.userManager = userManager;
        this.systemManagerService = systemManagerService;
        this.modelMapper = modelMapper;
        this.employerControlService = employerControlService;
        this.jobAdvertisementDao = jobAdvertisementDao;
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

    @Override
    public Result addJobAdvert(AddJobAdvertDto addJobAdvertDto) {


        try {
         jobAdvertisementDao.save(modelMapper.map(addJobAdvertDto, JobAdverstisementEntity.class));

         return new SuccessResult(true , "İş ilanı eklendi");
        }
        catch (Exception e) {
            return new UnsuccessfulResult(false , "iş ilanı eklenemedi");
        }


    }

    @Override
    public List<BusinessSectorToEmployerDto> getAllJobAdvert(EmployerEntity employer) {

        List<BusinessSectorToEmployerDto> jobAdverstisementEntities = new ArrayList<>();

        modelMapper.map(jobAdverstisementEntities,BusinessSectorToEmployerDto.class);
        for(JobAdverstisementEntity job : jobAdvertisementDao.findAll()) {

            if(job.getEmployer().getEmployerId() == employer.getEmployerId() ) {

                jobAdverstisementEntities.add(modelMapper.map(jobAdverstisementEntities,BusinessSectorToEmployerDto.class));

            }

        }

        return jobAdverstisementEntities.stream().toList();
    }


}