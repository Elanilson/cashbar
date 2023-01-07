package com.apkdoandroid.cashbar.repositorio;

import android.content.Context;

import com.apkdoandroid.cashbar.listeners.APIListener;
import com.apkdoandroid.cashbar.model.Dados;
import com.apkdoandroid.cashbar.model.Produto;
import com.apkdoandroid.cashbar.repositorio.local.BancoRoom;
import com.apkdoandroid.cashbar.repositorio.local.interfaces.ProdutoDao;
import com.apkdoandroid.cashbar.repositorio.services.CashBarService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarrinhoRepositorio {

    private ProdutoDao  db;

    public CarrinhoRepositorio(Context context) {
        db = BancoRoom.getInstance(context).produtoDao();
    }



    public Boolean insert(Produto produto){
       return db.insert(produto) > 0 ;
    }

    public Boolean update(Produto produto){
        return db.update(produto) > 0 ;
    }

    public Boolean delete(Produto produto){
        return db.delete(produto) > 0 ;
    }

    public List<Produto> getAll(){
        return db.getProdutos();
    }

    public Produto getProduto(Long id){
        return db.getProduto(id);
    }

}
