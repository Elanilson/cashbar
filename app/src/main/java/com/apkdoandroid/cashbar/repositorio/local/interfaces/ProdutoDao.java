package com.apkdoandroid.cashbar.repositorio.local.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.apkdoandroid.cashbar.model.Produto;

import java.util.List;

@Dao
public interface  ProdutoDao {

    @Insert
    Long insert(Produto produto);
    @Update
    int update(Produto produto);
    @Delete
    int delete(Produto produto);

    @Query("select * from produtos")
    List<Produto> getProdutos();

    @Query("select * from produtos where cod_produto = :id")
    Produto getProduto (Long id);

}
