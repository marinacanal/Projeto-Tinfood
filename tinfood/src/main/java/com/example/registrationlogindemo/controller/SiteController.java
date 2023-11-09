package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller //só controller é redirecionamento de pagina html (rotas)
public class SiteController {

    private UserService userService;

    public SiteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    @GetMapping("/uploadArquivo")
    public String upload() {
        return "uploadArquivo";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/registrar")
    public String showRegistrar(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "registrar";
    }

    @GetMapping("/descricao")
    public String showdescricao() {
        return "descricao";
    }


    @GetMapping("/preferencia")
    public String showPreferencias() {
        return "preferencia";
    }

    @GetMapping("/match")
    public String showMatch() {
        return "match";
    }

    @GetMapping("/editar")
    public String showEditar() {
        return "editar";
    }

    @GetMapping("/deletar")
    public String showDeletar() {
        return "apagarConta";
    }
}
