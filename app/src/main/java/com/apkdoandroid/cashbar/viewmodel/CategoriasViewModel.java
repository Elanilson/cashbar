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
import com.apkdoandroid.cashbar.model.Respota;
import com.apkdoandroid.cashbar.repositorio.CarrinhoRepositorio;
import com.apkdoandroid.cashbar.repositorio.CashBarRepositorio;
import com.apkdoandroid.cashbar.repositorio.local.interfaces.ProdutoDao;

import java.util.ArrayList;
import java.util.List;

public class CategoriasViewModel extends AndroidViewModel {

    private CashBarRepositorio repositorio;
    private CarrinhoRepositorio carrinhoRepositorio;

    private List<Categoria> listaTemporaria = new ArrayList<>();

    private MutableLiveData<Respota> _Resposta = new MutableLiveData<>();
    public LiveData<Respota> resposta = _Resposta;

    private MutableLiveData<Float> _Total = new MutableLiveData<>();
    public LiveData<Float> total = _Total;

    private MutableLiveData <List<Categoria>> _Categorias = new MutableLiveData<>();
    public LiveData<List<Categoria>> categorias = _Categorias;

    private MutableLiveData <List<Produto>> _Produtos = new MutableLiveData<>();
    public LiveData<List<Produto>> produtos = _Produtos;


    public CategoriasViewModel(@NonNull Application application) {
        super(application);
        repositorio = new CashBarRepositorio();
        carrinhoRepositorio = new CarrinhoRepositorio(application.getApplicationContext());
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

    public void adiconarProduto(Produto produto){
        if(carrinhoRepositorio.getProduto(produto.getCod_produto()) == null){
            if(carrinhoRepositorio.insert(produto)){
                _Resposta.setValue(new Respota(true,"Adicionado ao carrinho"));
                carregarTotal();
            }else{
                _Resposta.setValue(new Respota("Não adicionado ao carrinho"));
            }
        }else{
            if(produto.getQuantidade() == 0){
                removerProduto(produto);
            }else{
                 atualizarProduto(produto);

            }
        }

    }

    public void atualizarProduto(Produto produto){
        if(carrinhoRepositorio.update(produto)){
            _Resposta.setValue(new Respota(true,"Atualizado"));
            carregarTotal();
        }else{
            _Resposta.setValue(new Respota("Não atualizado"));
        }
    }

    public void removerProduto(Produto produto){

    //    if(produto.getQuantidade() == 0){
            if(carrinhoRepositorio.delete(produto)){
                _Resposta.setValue(new Respota(true,"Removido"));
            }else{
                _Resposta.setValue(new Respota("Não foi possível remover"));
            }
     //   }
    }

    public List<Produto> carregarProdutosDoCarrinho(){
        return carrinhoRepositorio.getAll();
    }

    public void carregarTotal(){
        Float total = 0f;
        for(Produto produto : carrinhoRepositorio.getAll()){
          total +=  produto.getQuantidade() * produto.getValor();
        }
        _Total.setValue(total);
        System.out.println("Total: "+total);
    }




}
