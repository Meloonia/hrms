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



        emailCode.add("Mailkodu");
        emailCode.add("Denemekodu");
        emailCode.add("ABC");
        emailCode.add("yeeey");
    }


    @Override
    public boolean EmailDogrula(EmailValidationEntity email,UserEntity user) {



          return emailCode.stream().anyMatch(e-> e.equals(email.getEmailValidationCode()));

    }

    @Override
    public void sendMail() {

        System.out.println("Mail gönderildi.");

    }


}
