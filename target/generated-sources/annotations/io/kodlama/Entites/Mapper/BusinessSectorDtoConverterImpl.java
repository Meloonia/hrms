package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.BusinessSectorsEntity;
import io.kodlama.Entites.dto.BusinessSectorDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-06T19:10:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class BusinessSectorDtoConverterImpl implements BusinessSectorDtoConverter {

    @Override
    public BusinessSectorsEntity businessSectorConverterDto(BusinessSectorDto businessSectorDto) {
        if ( businessSectorDto == null ) {
            return null;
        }

        BusinessSectorsEntity businessSectorsEntity = new BusinessSectorsEntity();

        businessSectorsEntity.setBusinessSectorId( businessSectorDto.getBusinessSectorId() );
        businessSectorsEntity.setBusinessSectorName( businessSectorDto.getBusinessSectorName() );

        return businessSectorsEntity;
    }

    @Override
    public List<BusinessSectorDto> businessSectorListConvertDto(List<BusinessSectorsEntity> businessSectorsEntity) {
        if ( businessSectorsEntity == null ) {
            return null;
        }

        List<BusinessSectorDto> list = new ArrayList<BusinessSectorDto>( businessSectorsEntity.size() );
        for ( BusinessSectorsEntity businessSectorsEntity1 : businessSectorsEntity ) {
            list.add( businessSectorsEntityToBusinessSectorDto( businessSectorsEntity1 ) );
        }

        return list;
    }

    protected BusinessSectorDto businessSectorsEntityToBusinessSectorDto(BusinessSectorsEntity businessSectorsEntity) {
        if ( businessSectorsEntity == null ) {
            return null;
        }

        BusinessSectorDto businessSectorDto = new BusinessSectorDto();

        businessSectorDto.setBusinessSectorId( businessSectorsEntity.getBusinessSectorId() );
        businessSectorDto.setBusinessSectorName( businessSectorsEntity.getBusinessSectorName() );

        return businessSectorDto;
    }
}
