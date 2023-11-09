package com.example.registrationlogindemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Obter todos os usuários
    @GetMapping("/listar")
    public List<User> listaUser() {
        return userRepository.findAll();
    }

    // Obter um usuário por ID
    @GetMapping("/listar/{id}")
    public Optional<User> buscarUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    // Atualizar um usuário
    @PutMapping("/atualizar/{id}")
    public User atualizarUser(@PathVariable Long id,
            @RequestBody User novoUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(novoUser.getName());
                    user.setEmail(novoUser.getEmail());
                    user.setPassword(novoUser.getPassword());
                    user.setData_nascimento(novoUser.getData_nascimento());
                    user.setTelefone(novoUser.getTelefone());
                    user.setGenero(novoUser.getGenero());
                    user.setFoto_perfil(novoUser.getFoto_perfil());
                    user.setDescricao(novoUser.getDescricao());
                    user.setPreferencia1(novoUser.getPreferencia1());
                    user.setPreferencia2(novoUser.getPreferencia2());
                    user.setPreferencia3(novoUser.getPreferencia3());
                    user.setCategoria(novoUser.getCategoria());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    throw new EntityNotFoundException();
                });

    }

    // Excluir um usuário
    @DeleteMapping("/deletar/{id}")
    public void excluirUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}

