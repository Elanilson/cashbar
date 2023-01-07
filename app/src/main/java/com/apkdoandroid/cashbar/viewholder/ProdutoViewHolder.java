package com.apkdoandroid.cashbar.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.cashbar.R;
import com.apkdoandroid.cashbar.listeners.OnListenerAcao;
import com.apkdoandroid.cashbar.model.Categoria;
import com.apkdoandroid.cashbar.model.Produto;
import com.bumptech.glide.Glide;

public class ProdutoViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    private ImageView imagem;
    private TextView textViewTitulo,textView6PrecoProduto,textViewQuantidade;
    private Button buttonAddCarinho;
    private ImageButton imageButtonITemSacolaMenos,imageButtonItemSacolaMais;
    private int quantidade = 1;

    public ProdutoViewHolder(@NonNull View itemView) {
        super(itemView);
        //cardView = itemView.findViewById(R.id.cardViewTituloCategoria);
        textViewTitulo = itemView.findViewById(R.id.textViewTituloProduto);
        textView6PrecoProduto = itemView.findViewById(R.id.textView6PrecoProduto);
        imagem = itemView.findViewById(R.id.imageViewProduto);
        buttonAddCarinho = itemView.findViewById(R.id.buttonAdicionarProdutoCarrinho);
        imageButtonITemSacolaMenos = itemView.findViewById(R.id.imageButtonITemSacolaMenos);
        imageButtonItemSacolaMais = itemView.findViewById(R.id.imageButtonItemSacolaMais);
        textViewQuantidade = itemView.findViewById(R.id.textViewItemQuantidade);
    }

    public void bind(Produto produto, OnListenerAcao<Produto> listener){
       /* cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(produto);
            }
        });*/
        imageButtonItemSacolaMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantidade >= 0){
                    quantidade++;
                    produto.setQuantidade(quantidade);
                    textViewQuantidade.setText(String.valueOf(quantidade));
                }
            }
        });
        imageButtonITemSacolaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantidade >0){
                    quantidade--;
                    produto.setQuantidade(quantidade);
                    textViewQuantidade.setText(String.valueOf(quantidade));
                }
            }
        });


        buttonAddCarinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(produto);
            }
        });
        Glide.with(itemView.getContext()).load(produto.getImagem()).placeholder(R.color.cinza).into(imagem);
        textViewTitulo.setText(produto.getNome());
        String valorFormatado = String.format("%.2f",produto.getValor()).replace(".",",");
        textView6PrecoProduto.setText("R$ "+valorFormatado);

    }
}
