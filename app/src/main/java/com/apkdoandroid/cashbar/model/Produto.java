package com.apkdoandroid.cashbar.model;

public class Produto {
    private String cod_produto;
    private String nome;
    private String descricao;
    private Float valor;
    private Float desconto;
    private String imagem;

    public Produto() {
    }

    public Produto(String cod_produto, String nome, String descricao, Float valor, Float desconto, String imagem) {
        this.cod_produto = cod_produto;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.desconto = desconto;
        this.imagem = imagem;
    }

    public String getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(String cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
