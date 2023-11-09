package com.example.registrationlogindemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.registrationlogindemo.repository.UserRepository;

@Controller
public class DescricaoController {

    @Autowired
    private UserRepository userRepository;

    public DescricaoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/descricao/{descricao}")
    public String descricao(@PathVariable String descricao) {
        UsuarioLogadoController.getUsuarioLogado().setDescricao(descricao);
        userRepository.save(UsuarioLogadoController.getUsuarioLogado());        
        return "redirect:/descricao";
    }
}
