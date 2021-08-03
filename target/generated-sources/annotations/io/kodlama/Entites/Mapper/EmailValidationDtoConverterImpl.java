package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.EmailValidationEntity;
import io.kodlama.Entites.dto.EmailValidationDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T11:58:43+0300",
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

        emailValidationEntity.setValidation( emailValidationDto.isValidation() );
        emailValidationEntity.setEmail( emailValidationDto.getEmail() );

        return emailValidationEntity;
    }
}
