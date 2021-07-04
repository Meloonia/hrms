package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.ActiveJobAdverstisementDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-04T21:29:36+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class ActiveJobAdverstisementDtoConverterImpl implements ActiveJobAdverstisementDtoConverter {

    @Override
    public List<ActiveJobAdverstisementDto> getAllActiveJobAdvert(List<JobAdverstisementEntity> jobAdverstisementEntities) {
        if ( jobAdverstisementEntities == null ) {
            return null;
        }

        List<ActiveJobAdverstisementDto> list = new ArrayList<ActiveJobAdverstisementDto>( jobAdverstisementEntities.size() );
        for ( JobAdverstisementEntity jobAdverstisementEntity : jobAdverstisementEntities ) {
            list.add( jobAdverstisementEntityToActiveJobAdverstisementDto( jobAdverstisementEntity ) );
        }

        return list;
    }

    protected ActiveJobAdverstisementDto jobAdverstisementEntityToActiveJobAdverstisementDto(JobAdverstisementEntity jobAdverstisementEntity) {
        if ( jobAdverstisementEntity == null ) {
            return null;
        }

        ActiveJobAdverstisementDto activeJobAdverstisementDto = new ActiveJobAdverstisementDto();

        activeJobAdverstisementDto.setRelaseDate( jobAdverstisementEntity.getRelaseDate() );
        activeJobAdverstisementDto.setActiveDate( jobAdverstisementEntity.getActiveDate() );
        activeJobAdverstisementDto.setOpenPosition( jobAdverstisementEntity.getOpenPosition() );

        return activeJobAdverstisementDto;
    }
}
