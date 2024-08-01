package com.br.cappybaramicroserviceusuario.enuns;

public enum RoleEnum {
    ORGANIZADOR("organizador"),
    USUARIO("usuario");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
