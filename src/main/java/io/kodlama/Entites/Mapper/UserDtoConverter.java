package io.kodlama.Entites.Mapper;

import io.kodlama.Entites.Concretes.UserEntity;
import io.kodlama.Entites.dto.UserDto;

public interface UserDtoConverter {

    UserEntity userDtoConverter(UserDto user);
    UserDto userEntityConverter(UserEntity user);
}
