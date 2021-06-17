package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.EmployerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.EmployerDto;
import io.kodlama.Entites.dto.getAllEmployerDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T13:13:01+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class EmployerDtoConverterImpl implements EmployerDtoConverter {

    @Override
    public EmployerEntity insertEmployerDtoConverter(EmployerDto employerDto) {
        if ( employerDto == null ) {
            return null;
        }

        EmployerEntity employerEntity = new EmployerEntity();

        employerEntity.setEmployerName( employerDto.getEmployerName() );
        employerEntity.setEmployerAdress( employerDto.getEmployerAdress() );
        employerEntity.setEmployerWebsite( employerDto.getEmployerWebsite() );

        return employerEntity;
    }

    @Override
    public List<EmployerEntity> listEmployerDtoConverter(List<EmployerEntity> employerEntity) {
        if ( employerEntity == null ) {
            return null;
        }

        List<EmployerEntity> list = new ArrayList<EmployerEntity>( employerEntity.size() );
        for ( EmployerEntity employerEntity1 : employerEntity ) {
            list.add( employerEntity1 );
        }

        return list;
    }

    @Override
    public UserEntity insertuserDtoConverter(EmployerDto employerDto) {
        if ( employerDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserEmail( employerDto.getUserEmail() );
        userEntity.setUserPassword( employerDto.getUserPassword() );
        userEntity.setRePassword( employerDto.getRePassword() );

        return userEntity;
    }

    @Override
    public List<getAllEmployerDto> listAllEmployer(List<EmployerEntity> employerEntity) {
        if ( employerEntity == null ) {
            return null;
        }

        List<getAllEmployerDto> list = new ArrayList<getAllEmployerDto>( employerEntity.size() );
        for ( EmployerEntity employerEntity1 : employerEntity ) {
            list.add( employerEntityTogetAllEmployerDto( employerEntity1 ) );
        }

        return list;
    }

    protected getAllEmployerDto employerEntityTogetAllEmployerDto(EmployerEntity employerEntity) {
        if ( employerEntity == null ) {
            return null;
        }

        getAllEmployerDto getAllEmployerDto = new getAllEmployerDto();

        getAllEmployerDto.setEmployerName( employerEntity.getEmployerName() );
        getAllEmployerDto.setEmployerAdress( employerEntity.getEmployerAdress() );
        getAllEmployerDto.setEmployerWebsite( employerEntity.getEmployerWebsite() );
        getAllEmployerDto.setEmployerPhone( employerEntity.getEmployerPhone() );

        return getAllEmployerDto;
    }
}
