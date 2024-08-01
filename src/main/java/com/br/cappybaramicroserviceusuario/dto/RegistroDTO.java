package com.br.cappybaramicroserviceusuario.dto;

import com.br.cappybaramicroserviceusuario.enuns.RoleEnum;

import java.time.LocalDate;

public class RegistroDTO {
    private String nome;

    private String email;
    private LocalDate dataNascimento;
    private String senha;
    private RoleEnum role;

    public RegistroDTO() {
    }

    public RegistroDTO(String nome, String email, LocalDate dataNascimento, String senha, RoleEnum role) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
