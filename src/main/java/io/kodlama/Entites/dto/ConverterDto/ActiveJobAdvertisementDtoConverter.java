package io.kodlama.Entites.dto.ConverterDto;

import io.kodlama.DataAccess.Abstracts.BusinessAreaDao;
import io.kodlama.DataAccess.Abstracts.EmployersDao;
import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.JobAdverstisementEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/*    String businessSectorName,
    String employername,
   Date relaseDate,
    Date activeDate,
    int openPosition,*/
public class ActiveJobAdvertisementDtoConverter {



    private final BusinessAreaDao businessAreaDao;
    private final EmployersDao employersDao;
    private SimpleDateFormat bicim=new SimpleDateFormat("yyyy/MM/dd");

    public ActiveJobAdvertisementDtoConverter(EmployersDao employersDao,BusinessAreaDao businessAreaDao) {


        this.businessAreaDao = businessAreaDao;
        this.employersDao = employersDao;
    }

    public EmployerEntity employerNameConverter(long id){

        EmployerEntity employerEntity = employersDao.getEmployerEntityByEmployerIdAnd(id);
        return employerEntity;
    }

    public BusinessSectorsEntity businessSectorsConverter(int Id) {
        BusinessSectorsEntity businessSectorsEntity  = businessAreaDao.getBusinessSectorsEntityByBusinessSectorId(Id);


        return businessSectorsEntity;


    }

    public JobAdverstisementEntity converterJobAdvertisementDto(

                                                                Date relaseDate,
                                                                Date activeDate,
                                                                int openPosition) {

        JobAdverstisementEntity jobAdverstisementEntity = new JobAdverstisementEntity();
        jobAdverstisementEntity.setActiveDate(activeDate);
        jobAdverstisementEntity.setRelaseDate(relaseDate);
        jobAdverstisementEntity.setOpenPosition(openPosition);

            return jobAdverstisementEntity;

    }

}
