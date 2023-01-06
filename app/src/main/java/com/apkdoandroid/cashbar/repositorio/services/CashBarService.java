package com.apkdoandroid.cashbar.repositorio.services;

import com.apkdoandroid.cashbar.model.Dados;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CashBarService {

    @GET("getProducts.php")
    Call<Dados> getCategorias();
}
