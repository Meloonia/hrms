package io.kodlama.Business.Abstracts;

import io.kodlama.Core.utilities.results.Result;
import io.kodlama.Entites.Concretes.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserManagerServices extends UserDetailsService {

    Result insertUser(UserEntity userEntiy);

   }
