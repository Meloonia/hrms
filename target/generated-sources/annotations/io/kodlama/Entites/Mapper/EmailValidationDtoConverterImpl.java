package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.EmailValidationEntity;
import io.kodlama.Entites.dto.EmailValidationDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-27T14:46:33+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class EmailValidationDtoConverterImpl implements EmailValidationDtoConverter {

    @Override
    public EmailValidationEntity emailValidationDtoConverter(EmailValidationDto emailValidationDto) {
        if ( emailValidationDto == null ) {
            return null;
        }

        EmailValidationEntity emailValidationEntity = new EmailValidationEntity();

        emailValidationEntity.setEmail( emailValidationDto.getEmail() );
        emailValidationEntity.setValidation( emailValidationDto.isValidation() );

        return emailValidationEntity;
    }
}
