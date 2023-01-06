package com.apkdoandroid.cashbar.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Dados {
    private Boolean success;
    @SerializedName("data")
    private List<Categoria> categorias = new ArrayList<>();

    public Dados() {
    }

    public Dados(Boolean success, List<Categoria> categorias) {
        this.success = success;
        this.categorias = categorias;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
