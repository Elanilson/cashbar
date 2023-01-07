package com.apkdoandroid.cashbar.model;

public class Respota {
    private Boolean status = true;
    private String mensagem = "";

    public Respota() {
    }

    public Respota(String mensagem) {
        this.mensagem = mensagem;
    }

    public Respota(Boolean status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
