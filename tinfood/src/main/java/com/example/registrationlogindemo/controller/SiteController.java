package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // só controller é redirecionamento de pagina html (rotas)
public class SiteController {

    @Autowired
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

    @GetMapping("/registrar")
    public String showRegistrar(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "registrar";
    }

    @PostMapping("/registrar/save")
    public String registrar(@Valid @ModelAttribute("user") UserDto user,
            BindingResult result,
            Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "Já existe alguém com este e-mail");
            return "redirect:/registrar?error";
        }
        else {
            userService.saveUser(user);
            return "redirect:/registrar?success";
        }
    }

    @GetMapping("/uploadArquivo")
    public String upload() {
        return "uploadArquivo";
    }

    @GetMapping("/descricao")
    public String showdescricao() {
        return "descricao";
    }

    @GetMapping("/preferencia")
    public String showPreferencias() {
        return "preferencia";
    }

    @GetMapping("/editar")
    public String showEditar() {
        return "editar";
    }

    @GetMapping("/fotoPerfil")
    public String showPerfil() {
        return "fotoPerfil";
    }

    @GetMapping("/deletar")
    public String showDeletar() {
        return "deletar";
    }
}
