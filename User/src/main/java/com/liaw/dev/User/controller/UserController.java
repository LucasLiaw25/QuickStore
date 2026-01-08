package com.liaw.dev.User.controller;

import com.liaw.dev.User.dto.UserDTO;
import com.liaw.dev.User.service.UserSerivce;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user/")
public class UserController {

    private final UserSerivce serivce;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(serivce.createUser(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUser(){
        return ResponseEntity.ok(serivce.listUser());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(serivce.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO dto){
        return ResponseEntity.ok(serivce.updateUser(id, dto));
    }

}
