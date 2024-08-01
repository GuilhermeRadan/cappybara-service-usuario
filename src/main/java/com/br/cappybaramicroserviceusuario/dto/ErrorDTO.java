package com.br.cappybaramicroserviceusuario.dto;

public class ErrorDTO {
    private String menssagem;

    private String status;

    public ErrorDTO() {
    }

    public ErrorDTO(String menssagem, String status) {
        this.menssagem = menssagem;
        this.status = status;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
