package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.SystemManagerEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.SystemManagerDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-06T19:10:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class SystemManagerDtoConverterImpl implements SystemManagerDtoConverter {

    @Override
    public SystemManagerEntity SystemManagerDtoConvertEntity(SystemManagerDto systemManagerDto) {
        if ( systemManagerDto == null ) {
            return null;
        }

        SystemManagerEntity systemManagerEntity = new SystemManagerEntity();

        systemManagerEntity.setSystemManagerName( systemManagerDto.getSystemManagerName() );
        systemManagerEntity.setSystemManagersurname( systemManagerDto.getSystemManagersurname() );
        systemManagerEntity.setSystemManagerPhone( systemManagerDto.getSystemManagerPhone() );
        systemManagerEntity.setSystemManagerAdress( systemManagerDto.getSystemManagerAdress() );

        return systemManagerEntity;
    }

    @Override
    public UserEntity SystemManagerDtoConverterUserEntity(SystemManagerDto systemManagerDto) {
        if ( systemManagerDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserEmail( systemManagerDto.getUserEmail() );
        userEntity.setUserPassword( systemManagerDto.getUserPassword() );
        userEntity.setRePassword( systemManagerDto.getRePassword() );

        return userEntity;
    }
}
