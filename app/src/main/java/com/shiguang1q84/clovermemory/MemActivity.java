package com.shiguang1q84.clovermemory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemActivity extends AppCompatActivity {

    FragmentManager fm ;
    FragmentTransaction ft;
    Fragment fragment = new ItemFragment();
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem);

        button = (Button)findViewById(R.id.button);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        fragment = new ItemFragment();
        ft.replace(R.id.memfragment,fragment);
        ft.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();


    }
}
