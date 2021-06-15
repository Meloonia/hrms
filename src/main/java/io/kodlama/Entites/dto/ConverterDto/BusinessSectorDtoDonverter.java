package io.kodlama.Entites.dto.ConverterDto;

import io.kodlama.DataAccess.Abstracts.BusinessAreaDao;
import io.kodlama.Entites.Concretes.BusinessSectorsEntity;

public class BusinessSectorDtoDonverter {

    private final BusinessAreaDao businessAreaDao;

    public BusinessSectorDtoDonverter(BusinessAreaDao businessAreaDao) {
        this.businessAreaDao = businessAreaDao;
    }

    public BusinessSectorsEntity converterBusinessArea(String areaName) {

        BusinessSectorsEntity businessSectorsEntity = new BusinessSectorsEntity();
        businessSectorsEntity.setBusinessSectorName(areaName);
        return businessSectorsEntity;
    }

}
