package io.kodlama.adapters.Inmemory.Concretes;

import io.kodlama.Entites.Concretes.EmailValidationEntity;
import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.adapters.Inmemory.Abstracts.EmailValidation;

import java.util.ArrayList;
import java.util.List;
// Sahte Mail onay kontrol servisi.
public class EmailValidationInMemory implements EmailValidation {
   private List<String> emailCode = new ArrayList<>();
    public EmailValidationInMemory() {

        emailCode.add("Mailkodu");
        emailCode.add("Denemekodu");
        emailCode.add("ABC");
        emailCode.add("yeeey");
    }

    @Override
    public boolean EmailDogrula(String code,UserEntity user) {



            if(emailCode.stream().anyMatch(e-> e.equals(code))) {

                user.setEmailValidation(true);
            }
                else return false;

        return true;
    }

    @Override
    public void sendMail(EmailValidationEntity validationCode,UserEntity user) {


        System.out.println("Mail gönderildi.");
        EmailDogrula(validationCode.getEmailValidationCode(),user);
    }


}
