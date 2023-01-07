package com.apkdoandroid.cashbar.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apkdoandroid.cashbar.R;
import com.apkdoandroid.cashbar.adapter.CategoriaAdapter;
import com.apkdoandroid.cashbar.adapter.ProdutosAdapter;
import com.apkdoandroid.cashbar.databinding.FragmentCategoriasBinding;
import com.apkdoandroid.cashbar.listeners.OnListenerAcao;
import com.apkdoandroid.cashbar.model.Categoria;
import com.apkdoandroid.cashbar.model.Produto;
import com.apkdoandroid.cashbar.model.Respota;
import com.apkdoandroid.cashbar.viewmodel.CategoriasViewModel;

import java.util.List;

public class CategoriasFragment extends Fragment {
    private FragmentCategoriasBinding  binding;
    protected CategoriasViewModel viewModel;
    private CategoriaAdapter adapterCategoria = new CategoriaAdapter();
    private ProdutosAdapter produtosAdapter = new ProdutosAdapter();




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoriasBinding.inflate(inflater,container, false);

        viewModel = new ViewModelProvider(this).get(CategoriasViewModel.class);
        viewModel.getProdutos();
        viewModel.getCategorias();
        LinearLayoutManager manager = new LinearLayoutManager(binding.getRoot().getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        binding.recyclerviewCategorias.setLayoutManager(manager);
        binding.recyclerviewCategorias.setAdapter(adapterCategoria);



        GridLayoutManager grid = new GridLayoutManager(binding.getRoot().getContext(),2);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        binding.recyclerviewProdutos.setLayoutManager(grid);
        binding.recyclerviewProdutos.setAdapter(produtosAdapter);



        OnListenerAcao<Produto> listenerProduto = new OnListenerAcao<Produto>() {
            @Override
            public void onClick(Produto obj) {
                viewModel.adiconarProduto(obj);
            }

            @Override
            public void onLongClick(Produto obj) {

            }
        };

        produtosAdapter.attackListenerAcao(listenerProduto);

        OnListenerAcao<Categoria> listenerCategoria = new OnListenerAcao<Categoria>() {
            @Override
            public void onClick(Categoria obj) {
                viewModel.getProdutos(obj.getDescricao());

            }

            @Override
            public void onLongClick(Categoria obj) {

            }
        };

        adapterCategoria.attackListenerAcao(listenerCategoria);

        observe();
       return binding.getRoot();
    }

    private void observe() {
        viewModel.resposta.observe(getViewLifecycleOwner(), new Observer<Respota>() {
            @Override
            public void onChanged(Respota respota) {
                if(respota.getStatus()){

                    Toast.makeText(getActivity(), respota.getMensagem(), Toast.LENGTH_SHORT).show();
                    viewModel.carregarTotal();
                }else{
                    Toast.makeText(getActivity(), respota.getMensagem(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.total.observe(getViewLifecycleOwner(), new Observer<Float>() {
            @Override
            public void onChanged(Float aFloat) {
                String valorFormatado = String.format("%.2f",aFloat).replace(".",",");
                binding.textViewTotalCarrinho.setText(valorFormatado);
            }
        });
        viewModel.produtos.observe(getViewLifecycleOwner(), new Observer<List<Produto>>() {
            @Override
            public void onChanged(List<Produto> produtos) {
                produtosAdapter.attackProdutos(produtos);
            }
        });

        viewModel.categorias.observe(getViewLifecycleOwner(), new Observer<List<Categoria>>() {
            @Override
            public void onChanged(List<Categoria> categorias) {

                adapterCategoria.attackCategorias(categorias);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.carregarTotal();
    }
}