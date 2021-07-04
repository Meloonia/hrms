package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.UserManagerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.UserManagerDao;
import io.kodlama.Entites.Concretes.UserEntity;

import org.springframework.stereotype.Service;



@Service
public class UserManager implements UserManagerServices {


    private final UserManagerDao userManagerservices;



    private UserManager(UserManagerDao usersEntity) {
        this.userManagerservices = usersEntity;


    }


    @Override
    public Result insertUser(UserEntity userEntity) {

        if(userManagerservices.findAll().stream().anyMatch(u -> u.getUserEmail() == userEntity.getUserEmail())
        && userEntity.getUserPassword().equals(userEntity.getRePassword())) {

            this.userManagerservices.save(userEntity);
            return new SuccessResult(true);
        }
        else return new UnsuccessfulResult(false);
    }

/*    public Optional<UserEntity> returnEmployerId(long id){

        return userManagerservices.findById(id);
    }*/

}
