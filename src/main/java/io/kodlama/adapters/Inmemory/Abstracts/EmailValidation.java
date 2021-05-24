package io.kodlama.adapters.Inmemory.Abstracts;

import io.kodlama.Entites.Concretes.EmailValidationEntity;
import io.kodlama.Entites.Concretes.UserEntity;

public interface EmailValidation {

    boolean EmailDogrula(String code,UserEntity user);
    void sendMail(EmailValidationEntity validationCode,UserEntity user);


}
