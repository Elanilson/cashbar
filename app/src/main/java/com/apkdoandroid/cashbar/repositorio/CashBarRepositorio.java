package com.apkdoandroid.cashbar.repositorio;

import com.apkdoandroid.cashbar.listeners.APIListener;
import com.apkdoandroid.cashbar.model.Categoria;
import com.apkdoandroid.cashbar.model.Dados;
import com.apkdoandroid.cashbar.repositorio.services.CashBarService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CashBarRepositorio {
    private CashBarService service = RetrofitClient.classService(CashBarService.class);

    public void getCategorias(APIListener<Dados> listener){

        Call<Dados> call = service.getCategorias();
        call.enqueue(new Callback<Dados>() {
            @Override
            public void onResponse(Call<Dados> call, Response<Dados> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Dados> call, Throwable t) {
                listener.onFailures(t.getMessage());
            }
        });
    }
}
