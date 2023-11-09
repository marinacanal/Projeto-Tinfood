package com.example.registrationlogindemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty
    private String name;

    @NotEmpty(message = "Email deve ser informado")
    @Email
    private String email;

    @NotEmpty(message = "A senha deve ser informada")
    private String password;

    @NotEmpty(message = "A data deve ser informada")
    private String data_nascimento;

    @NotEmpty
    private String telefone;

    @NotEmpty
    private String genero;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private String preferencia1;

    @NotEmpty
    private String preferencia2;

    @NotEmpty
    private String preferencia3;

    private String foto_perfil;

}
