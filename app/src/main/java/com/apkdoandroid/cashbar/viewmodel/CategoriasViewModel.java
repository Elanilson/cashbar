package com.apkdoandroid.cashbar.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.apkdoandroid.cashbar.listeners.APIListener;
import com.apkdoandroid.cashbar.model.Categoria;
import com.apkdoandroid.cashbar.model.Dados;
import com.apkdoandroid.cashbar.model.Produto;
import com.apkdoandroid.cashbar.repositorio.CashBarRepositorio;

import java.util.ArrayList;
import java.util.List;

public class CategoriasViewModel extends AndroidViewModel {

    private CashBarRepositorio repositorio = new CashBarRepositorio();

    private List<Categoria> listaTemporaria = new ArrayList<>();

    private MutableLiveData <List<Categoria>> _Categorias = new MutableLiveData<>();
    public LiveData<List<Categoria>> categorias = _Categorias;

    private MutableLiveData <List<Produto>> _Produtos = new MutableLiveData<>();
    public LiveData<List<Produto>> produtos = _Produtos;


    public CategoriasViewModel(@NonNull Application application) {
        super(application);
    }

    public void getCategorias(){
        APIListener<Dados> listener = new APIListener<Dados>() {
            @Override
            public void onSuccess(Dados result) {
                if(result.getCategorias() != null){
                    listaTemporaria.addAll(result.getCategorias());
                    _Categorias.setValue(result.getCategorias());
                }

            }

            @Override
            public void onFailures(String mensagem) {

            }
        };

        repositorio.getCategorias(listener);

    }
    public void getProdutos(String nomeCategoria){

        if(nomeCategoria != null && nomeCategoria != ""){
                for(Categoria categoria : listaTemporaria){
                    if(categoria.getDescricao().equalsIgnoreCase(nomeCategoria)){
                        if(categoria.getProdutos() != null){
                            _Produtos.setValue(categoria.getProdutos());
                        }
                    }

                }

        }else{
            for(Categoria categoria : listaTemporaria){
                _Produtos.setValue(categoria.getProdutos());
            }
        }

    }

    public void getProdutos(){
         List<Produto> produtosTemporarios = new ArrayList<>();
        APIListener<Dados> listener = new APIListener<Dados>() {
            @Override
            public void onSuccess(Dados result) {
                if(result.getCategorias() != null){
                    for(Categoria categoria : result.getCategorias()){
                        produtosTemporarios.addAll(categoria.getProdutos());

                    }
                }

                _Produtos.setValue(produtosTemporarios);


            }

            @Override
            public void onFailures(String mensagem) {

            }
        };

        repositorio.getCategorias(listener);



    }




}
