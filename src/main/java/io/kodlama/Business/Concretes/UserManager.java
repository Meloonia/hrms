package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.UserManagerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.UserManagerDao;
import io.kodlama.Entites.Concretes.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserManagerServices {


    UserManagerDao userManagerservices;


    @Autowired
    private UserManager(UserManagerDao usersEntity) {
        this.userManagerservices = usersEntity;


    }


    @Override
    public Result insertUser(UserEntity userEntity) {

        if(userManagerservices.findAll().stream().anyMatch(u -> u.getUserId() == userEntity.getUserId())
        && userEntity.getUserPassword().equals(userEntity.getRePassword())) {

            this.userManagerservices.save(userEntity);
            return new SuccessResult(true);
        }
        else return new UnsuccessfulResult(false);
    }
}
