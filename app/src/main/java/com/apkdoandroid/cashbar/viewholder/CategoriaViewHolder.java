package com.apkdoandroid.cashbar.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.cashbar.R;
import com.apkdoandroid.cashbar.listeners.OnListenerAcao;
import com.apkdoandroid.cashbar.model.Categoria;

public class CategoriaViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    private TextView textViewTituloCategoria;

    public CategoriaViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardViewTituloCategoria);
        textViewTituloCategoria = itemView.findViewById(R.id.textViewTituloCategoria);
    }

    public void bind(Categoria categoria, OnListenerAcao<Categoria> listener){

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(categoria);
            }
        });
        textViewTituloCategoria.setText(categoria.getDescricao());

    }
}
