package io.kodlama.Utils.Controls;

import io.kodlama.Entites.dto.EmployerDto;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class EmployerControl implements EmployerControlService{
    @Override
    public boolean nameLenghtControl(EmployerDto employerEntity) {
        if(
                employerEntity.getUserEmail().length() != 0
                        && employerEntity.getUserPassword().length() != 0
                        && employerEntity.getRePassword().length() != 0
                        && emailDomainControl(employerEntity)
        )
            return true;
        else return false;
    }

    @Override
    public boolean emailDomainControl(EmployerDto employerEntity) {
        String regex = "^[A-Za-z0-9._%+-]+@" + employerEntity.getEmployerWebsite().split("@") +"$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employerEntity.getUserEmail());
        if(matcher.matches()) {
            return true;
        }else {
            return false;
        }
    }
}
