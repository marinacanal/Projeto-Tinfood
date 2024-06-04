package com.example.registrationlogindemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.registrationlogindemo.repository.UserRepository;

@Controller
public class PreferenciaController {

    @Autowired
    private UserRepository userRepository;

    public PreferenciaController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/preferencia/{preferencia1}/{preferencia2}/{preferencia3}")
    public String preferencia(@PathVariable String preferencia1, @PathVariable String preferencia2, @PathVariable String preferencia3) {
        UsuarioLogadoController.getUsuarioLogado().setPreferencia1(preferencia1);
        UsuarioLogadoController.getUsuarioLogado().setPreferencia2(preferencia2);
        UsuarioLogadoController.getUsuarioLogado().setPreferencia3(preferencia3);
        userRepository.save(UsuarioLogadoController.getUsuarioLogado());
        return "redirect:/uploadArquivo";
    }
}
