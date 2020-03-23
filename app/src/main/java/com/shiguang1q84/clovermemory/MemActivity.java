package com.shiguang1q84.clovermemory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shiguang1q84.clovermemory.view.MemViewAdapter;

public class MemActivity extends AppCompatActivity {

    FragmentManager fm ;
    FragmentTransaction ft;
    MemFragment fragment = new ItemFragment();
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
        button.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MemFragment currentFragment = (MemFragment)fm.findFragmentById(R.id.memfragment);
            MemViewAdapter memViewAdapter = currentFragment.getMyAdapter();
            boolean tempVisiable = currentFragment.isContentVisable();
            currentFragment.setContentVisable(!tempVisiable);
            memViewAdapter.setVisiable(!tempVisiable);//(!myItemRecyclerViewAdapter.getIdVisiable());
            memViewAdapter.notifyDataSetChanged();
        }
    };


}
