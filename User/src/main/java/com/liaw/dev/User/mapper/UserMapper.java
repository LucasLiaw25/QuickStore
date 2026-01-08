package com.liaw.dev.User.mapper;

import com.liaw.dev.User.dto.UserDTO;
import com.liaw.dev.User.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public User toEntity(UserDTO dto){
        return new User(
                dto.getId(),
                dto.getName(),
                dto.getEmail()
        );
    }

}
