package com.apkdoandroid.cashbar.repositorio;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private RetrofitClient(){}

    private static Retrofit INSTACE;
    private static OkHttpClient client = new OkHttpClient();
    private static Retrofit getINSTACE(){
        if(INSTACE == null){
            INSTACE = new Retrofit.Builder()
                    .baseUrl("https://api.cashpago.com.br/cashbar/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return INSTACE;
    }

    public static <T> T classService(Class<T> classService){
        return getINSTACE().create(classService);
    }

}
