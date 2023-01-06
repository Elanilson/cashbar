package com.apkdoandroid.cashbar.listeners;

public interface APIListener<T>{
    void onSuccess(T result);
    void onFailures(String mensagem);

}
