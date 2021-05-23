package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.UserEntity;

public interface UserManagerServices {

    Result insertUser(UserEntity userEntiy);

}
