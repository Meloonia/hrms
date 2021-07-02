package io.kodlama.Utils.Controls;

import io.kodlama.DataAccess.Abstracts.EmailValidationDao;
import io.kodlama.DataAccess.Abstracts.EmployersDao;
import io.kodlama.Entites.dto.EmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class EmployerControl implements EmployerControlService{

    EmailValidationDao emailValidationDao;

    public EmployerControl( EmailValidationDao emailValidationDao) {
        this.emailValidationDao = emailValidationDao;
    }

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
        String regex = "^[A-Za-z0-9._%+-]+@" + employerEntity.getEmployerWebsite().split("@")[0]+ "$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employerEntity.getUserEmail());
        if(matcher.matches()) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean emailControl(EmployerDto employerEntity) {
        return emailValidationDao.findAll().stream().noneMatch(e -> e.isValidation());
    }
}
