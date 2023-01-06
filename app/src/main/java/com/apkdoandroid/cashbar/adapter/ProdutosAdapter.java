package com.apkdoandroid.cashbar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.cashbar.R;
import com.apkdoandroid.cashbar.listeners.OnListenerAcao;
import com.apkdoandroid.cashbar.model.Categoria;
import com.apkdoandroid.cashbar.model.Produto;
import com.apkdoandroid.cashbar.viewholder.CategoriaViewHolder;
import com.apkdoandroid.cashbar.viewholder.ProdutoViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutoViewHolder> {

    private List<Produto> produtos = new ArrayList<>();
    private OnListenerAcao<Produto> listener;

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_produto,parent,false);
      return  new ProdutoViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        holder.bind(produtos.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public void attackProdutos(List<Produto> produtos){
        this.produtos = produtos;
        notifyDataSetChanged();
    }
    public void attackListenerAcao(OnListenerAcao<Produto>  lsitener){
        this.listener = lsitener;
    }
}
