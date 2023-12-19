package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity //significa marcar uma classe como uma entidade jpa, uma classe que corresponde a uma tabela no banco
@Table(name="roles") //fornece detalhe sobre a tabela associada no banco de dados

public class Role
{
    @Id //indica chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o id automaticamente, um valor com tipo único
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    // @ManyToMany(mappedBy="roles") // muitos para muitos (criado na classe user primeiramente)
    // private List<User> users;
}

/* 
@ManyToOne
@JoinColumn(name="autor_id")
private Autor autor;

@OneToMany(mappedBy ="autor")
private list<Livros>livros;
 
^ relacionamento bidirecional, se exite muitos para um em uma classe, precisa de um para muitos na outra
 */