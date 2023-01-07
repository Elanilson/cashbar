package com.apkdoandroid.cashbar.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produtos")
public class Produto {
    @ColumnInfo(name = "cod_produto")
    @PrimaryKey(autoGenerate = true)
    private Long cod_produto;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "descricao")
    private String descricao ;
    @ColumnInfo(name = "valor")
    private Float valor;
    @ColumnInfo(name = "desconto")
    private Float desconto;
    @ColumnInfo(name = "imagem")
    private String imagem;
    @ColumnInfo(name = "quantidade")
    private int quantidade;


    public Produto() {
    }


    @Override
    public String toString() {
        return "Produto{" +
                "cod_produto=" + cod_produto +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", desconto=" + desconto +
                ", imagem='" + imagem + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(Long cod_produto) {
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
