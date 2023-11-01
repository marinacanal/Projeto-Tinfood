package com.example.registrationlogindemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.service.UserService;

@RestController
public class RegistrarRestController {

    private UserService userService;

    public RegistrarRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registrar/save")
    public String registro(@RequestBody UserDto user) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            return "Já existe alguém com este e-mail";
        } else {
            userService.saveUser(user);
            return "Registrado com sucesso";
        }
    }
}
