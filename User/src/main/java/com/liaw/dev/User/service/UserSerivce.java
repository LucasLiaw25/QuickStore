package com.liaw.dev.User.service;

import com.liaw.dev.User.dto.UserDTO;
import com.liaw.dev.User.entity.User;
import com.liaw.dev.User.mapper.UserMapper;
import com.liaw.dev.User.repository.UserRepository;
import com.liaw.dev.User.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSerivce {

    private final UserMapper mapper;
    private final UserValidator validator;
    private final UserRepository repository;

    public UserDTO createUser(UserDTO dto){
        validator.validateEmail(dto.getEmail());
        User user = mapper.toEntity(dto);
        repository.save(user);
        return mapper.toDTO(user);
    }

    public List<UserDTO> listUser(){
        List<User> users = repository.findAll();
        return users.stream().map(mapper::toDTO).toList();
    }

    public UserDTO findById(Long id){
        validator.validateId(id);
        User user = repository.findById(id).get();
        return mapper.toDTO(user);
    }

    public UserDTO updateUser(Long id, UserDTO dto){
        validator.validateId(id);
        User user = mapper.toEntity(dto);
        user.setId(id);
        repository.save(user);
        return mapper.toDTO(user);
    }

    public void deleteUser(Long id){
        validator.validateId(id);
        repository.deleteById(id);
    }

}
