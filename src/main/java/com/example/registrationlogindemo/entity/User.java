package com.example.registrationlogindemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true) //para indicar se é obrigatório(não nulável) e se é único
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String data_nascimento;

    @Column(nullable=false)
    private String telefone;

    @Column(nullable=false)
    private String genero;

    @Column(nullable=true)
    private String foto_perfil;

    @Column(nullable=true)
    private String descricao;

    @Column(nullable=true)
    private String preferencia1;

    @Column(nullable=true)
    private String preferencia2;

    @Column(nullable=true)
    private String preferencia3;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();

}
