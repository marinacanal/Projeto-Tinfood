package com.example.registrationlogindemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.registrationlogindemo.repository.UserRepository;

@Controller
public class CategoriaController {
    
    @Autowired
    private UserRepository userRepository;

    public CategoriaController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/categoria/{categoria}")
    public String categoria(@PathVariable String categoria) {
        UsuarioLogadoController.getUsuarioLogado().setCategoria(categoria);
        userRepository.save(UsuarioLogadoController.getUsuarioLogado());        
        return "redirect:/match";
    }
}
