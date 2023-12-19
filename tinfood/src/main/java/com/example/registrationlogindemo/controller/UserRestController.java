package com.example.registrationlogindemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserRestController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Obter todos os usuários
    @GetMapping("/listar")
    public List<User> listaUser() {
        return userRepository.findAll();
    }

    // Obter um usuário por ID
    @GetMapping("/listar/usuarioLogado")
    public List<User> buscarUser() {
        return userRepository.findAllById(UsuarioLogadoController.getUsuarioLogado().getId());
    }

    // Atualizar um usuário
    @PutMapping("/atualizar/{id}")
    public User atualizarUser(@PathVariable Long id,
            @RequestBody User novoUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(novoUser.getName());
                    user.setEmail(novoUser.getEmail());
                    user.setPassword(passwordEncoder.encode(novoUser.getPassword()));
                    user.setData_nascimento(novoUser.getData_nascimento());
                    user.setTelefone(novoUser.getTelefone());
                    user.setGenero(novoUser.getGenero());
                    user.setFoto_perfil(novoUser.getFoto_perfil());
                    user.setDescricao(novoUser.getDescricao());
                    user.setPreferencia1(novoUser.getPreferencia1());
                    user.setPreferencia2(novoUser.getPreferencia2());
                    user.setPreferencia3(novoUser.getPreferencia3());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    throw new EntityNotFoundException();
                });

    }

    // Excluir um usuário
    @DeleteMapping("/deletar/{id}")
    public void excluirUser(@PathVariable Long id) {
        try {
            userRepository.deleteByUserRoles(id);
        } catch (JpaSystemException e) {
            e.getMessage();
        }
        userRepository.deleteById(id);
    }
}
