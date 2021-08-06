package io.kodlama.Business.Concretes;

import io.kodlama.Business.Abstracts.UserManagerServices;
import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Core.utilities.results.SuccessResult;
import io.kodlama.Core.utilities.results.UnsuccessfulResult;
import io.kodlama.DataAccess.Abstracts.UserManagerDao;
import io.kodlama.Entites.Concretes.UserEntity;

import org.springframework.stereotype.Service;

import java.util.Collections;


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


    public  UserEntity getUserById(long id ){


        return userManagerservices.findUserEntityByUserId(id);
    }


   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            // kullanıcının adından kullanıcıyı bulup geri şifresi ile geri döndermen lazım

            UserEntity user = userManagerservices.getByUserEmail(username);

            if (user.getUserEmail() == username && user.getUserPassword() !=null) {
//                return new User(kullaniciList.get(0).getKullaniciAdi(), kullaniciList.get(0).getSifre(), Collections.emptyList());
                return new User(user.getUserEmail(), user.getUserPassword(), Collections.emptyList());
            } else {
                throw new UsernameNotFoundException(username);
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException(username);
        }
    }*/

/*    public Optional<UserEntity> returnEmployerId(long id){

        return userManagerservices.findById(id);
    }*/

}
