package com.apkdoandroid.cashbar.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkdoandroid.cashbar.R;
import com.apkdoandroid.cashbar.databinding.FragmentResumoPedidoBinding;

public class ResumoPedidoFragment extends Fragment {
    FragmentResumoPedidoBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResumoPedidoBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}