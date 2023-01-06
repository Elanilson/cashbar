package com.apkdoandroid.cashbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.apkdoandroid.cashbar.databinding.ActivityMainBinding;
import com.apkdoandroid.cashbar.view.CategoriasFragment;
import com.apkdoandroid.cashbar.view.ResumoPedidoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        bottomNavigationView = findViewById(R.id.buttonNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new CategoriasFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.categorias);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.categorias:
                        fragment = new CategoriasFragment();
                        break;
                    case R.id.resumoPedido:
                        fragment = new ResumoPedidoFragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,fragment).commit();


                return true;
            }
        });
    }
}