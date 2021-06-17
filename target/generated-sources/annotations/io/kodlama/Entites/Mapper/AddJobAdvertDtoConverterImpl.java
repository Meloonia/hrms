package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.JobAdverstisementEntity;
import io.kodlama.Entites.dto.AddJobAdvertDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T13:02:55+0300",
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

    @Override
    public List<AddJobAdvertDto> getAllActiveJobAdvert(List<JobAdverstisementEntity> jobAdverstisementEntities) {
        if ( jobAdverstisementEntities == null ) {
            return null;
        }

        List<AddJobAdvertDto> list = new ArrayList<AddJobAdvertDto>( jobAdverstisementEntities.size() );
        for ( JobAdverstisementEntity jobAdverstisementEntity : jobAdverstisementEntities ) {
            list.add( jobAdverstisementEntityToAddJobAdvertDto( jobAdverstisementEntity ) );
        }

        return list;
    }

    protected AddJobAdvertDto jobAdverstisementEntityToAddJobAdvertDto(JobAdverstisementEntity jobAdverstisementEntity) {
        if ( jobAdverstisementEntity == null ) {
            return null;
        }

        AddJobAdvertDto addJobAdvertDto = new AddJobAdvertDto();

        addJobAdvertDto.setRelaseDate( jobAdverstisementEntity.getRelaseDate() );
        addJobAdvertDto.setActiveDate( jobAdverstisementEntity.getActiveDate() );
        addJobAdvertDto.setOpenPosition( jobAdverstisementEntity.getOpenPosition() );
        addJobAdvertDto.setMaxSalary( jobAdverstisementEntity.getMaxSalary() );
        addJobAdvertDto.setActive( jobAdverstisementEntity.isActive() );
        addJobAdvertDto.setDesciription( jobAdverstisementEntity.getDesciription() );

        return addJobAdvertDto;
    }
}
