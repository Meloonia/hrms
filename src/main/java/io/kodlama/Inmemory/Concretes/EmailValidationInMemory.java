package io.kodlama.Inmemory.Concretes;

import io.kodlama.Entites.Concretes.EmailValidationEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Inmemory.Abstracts.EmailValidation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// Sahte Mail onay kontrol servisi.


@Service
public class EmailValidationInMemory implements EmailValidation {
   private List<String> emailCode = new ArrayList<>();
    public EmailValidationInMemory() {

        UserEntity user = new UserEntity();

        emailCode.add("Mailkodu");
        emailCode.add("Denemekodu");
        emailCode.add("ABC");
        emailCode.add("yeeey");
    }

    public EmailValidationEntity EmailDogrula() {

        return new EmailValidationEntity();
    }

    @Override
    public boolean EmailDogrula(EmailValidationEntity email,UserEntity user) {

            EmailDogrula();

            if(emailCode.stream().anyMatch(e-> e.equals(email.getEmailValidationCode()))) {
                return true;

            }
                else return false;


    }

    @Override
    public void sendMail() {


        System.out.println("Mail gönderildi.");

    }


}