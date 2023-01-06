package com.apkdoandroid.cashbar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.cashbar.R;
import com.apkdoandroid.cashbar.listeners.OnListenerAcao;
import com.apkdoandroid.cashbar.model.Categoria;
import com.apkdoandroid.cashbar.viewholder.CategoriaViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaViewHolder> {

    private List<Categoria> categorias = new ArrayList<>();
    private OnListenerAcao<Categoria> listener;

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria,parent,false);
      return  new CategoriaViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        holder.bind(categorias.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }
    public void attackCategorias(List<Categoria> categorias){
        this.categorias = categorias;
        notifyDataSetChanged();
    }
    public void attackListenerAcao(OnListenerAcao<Categoria>  lsitener){
        this.listener = lsitener;
    }
}
