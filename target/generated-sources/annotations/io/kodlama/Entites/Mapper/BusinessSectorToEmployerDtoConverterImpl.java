package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.BusinessSectorToEmployerDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T11:58:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class BusinessSectorToEmployerDtoConverterImpl implements BusinessSectorToEmployerDtoConverter {

    @Override
    public List<BusinessSectorToEmployerDto> businessSectorToEmployerDtoConverter(List<JobAdverstisementEntity> businessSectorToEmployerDto) {
        if ( businessSectorToEmployerDto == null ) {
            return null;
        }

        List<BusinessSectorToEmployerDto> list = new ArrayList<BusinessSectorToEmployerDto>( businessSectorToEmployerDto.size() );
        for ( JobAdverstisementEntity jobAdverstisementEntity : businessSectorToEmployerDto ) {
            list.add( jobAdverstisementEntityToBusinessSectorToEmployerDto( jobAdverstisementEntity ) );
        }

        return list;
    }

    protected BusinessSectorToEmployerDto jobAdverstisementEntityToBusinessSectorToEmployerDto(JobAdverstisementEntity jobAdverstisementEntity) {
        if ( jobAdverstisementEntity == null ) {
            return null;
        }

        BusinessSectorToEmployerDto businessSectorToEmployerDto = new BusinessSectorToEmployerDto();

        businessSectorToEmployerDto.setMinSalary( jobAdverstisementEntity.getMinSalary() );
        businessSectorToEmployerDto.setMaxSalary( jobAdverstisementEntity.getMaxSalary() );
        businessSectorToEmployerDto.setOpenPosition( jobAdverstisementEntity.getOpenPosition() );
        businessSectorToEmployerDto.setRelaseDate( jobAdverstisementEntity.getRelaseDate() );
        businessSectorToEmployerDto.setActiveDate( jobAdverstisementEntity.getActiveDate() );
        businessSectorToEmployerDto.setActive( jobAdverstisementEntity.isActive() );

        return businessSectorToEmployerDto;
    }
}
