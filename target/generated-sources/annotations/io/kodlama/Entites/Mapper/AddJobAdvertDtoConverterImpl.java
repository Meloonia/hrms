package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-04T21:11:10+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class AddJobAdvertDtoConverterImpl implements AddJobAdvertDtoConverter {

    @Override
    public JobAdverstisementEntity insertJobAdvert(AddJobAdvertDto addJobAdvertDto) {
        if ( addJobAdvertDto == null ) {
            return null;
        }

        JobAdverstisementEntity jobAdverstisementEntity = new JobAdverstisementEntity();

        jobAdverstisementEntity.setDesciription( addJobAdvertDto.getDesciription() );
        jobAdverstisementEntity.setActive( addJobAdvertDto.isActive() );
        jobAdverstisementEntity.setRelaseDate( addJobAdvertDto.getRelaseDate() );
        jobAdverstisementEntity.setActiveDate( addJobAdvertDto.getActiveDate() );
        jobAdverstisementEntity.setMaxSalary( addJobAdvertDto.getMaxSalary() );
        jobAdverstisementEntity.setOpenPosition( addJobAdvertDto.getOpenPosition() );

        return jobAdverstisementEntity;
    }
}
