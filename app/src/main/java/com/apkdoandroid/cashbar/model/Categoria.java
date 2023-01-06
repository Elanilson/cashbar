package com.apkdoandroid.cashbar.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String cod_categoria;
    private String descricao;
    private List<Produto> produtos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(String cod_categoria, String descricao, List<Produto> produtos) {
        this.cod_categoria = cod_categoria;
        this.descricao = descricao;
        this.produtos = produtos;
    }

    public String getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(String cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
