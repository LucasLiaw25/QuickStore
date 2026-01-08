package com.liaw.dev.User.validation;

import com.liaw.dev.User.entity.User;
import com.liaw.dev.User.exception.EmailExistingException;
import com.liaw.dev.User.exception.UserNotFoundException;
import com.liaw.dev.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository repository;

    public void validateId(Long id){
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("Usuário não encontrado");
        }
    }

    public void validateEmail(String email){
        Optional<User> user = repository.findByEmail(email);
        if (user.isPresent()){
            throw new EmailExistingException("Email já cadastrado");
        }
    }

}
