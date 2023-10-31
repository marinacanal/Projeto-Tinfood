package com.example.registrationlogindemo.controller;

import org.springframework.stereotype.Controller;

import com.example.registrationlogindemo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Controller
@Getter
@Setter
@AllArgsConstructor
public class UsuarioLogadoController {
    public static User usuarioLogado;

    public static void setUsuarioLogado(User user) {
        usuarioLogado = user;
    }

    public static User getUsuarioLogado(){
        return usuarioLogado;
    }
}
