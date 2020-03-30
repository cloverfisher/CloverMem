package com.shiguang1q84.clovermemory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shiguang1q84.clovermemory.data.DataItem;
import com.shiguang1q84.clovermemory.data.DatalistViewModel;
import com.shiguang1q84.clovermemory.view.MemViewAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MemActivity extends AppCompatActivity {

    FragmentManager fm ;
    FragmentTransaction ft;
    MemFragment fragment = new ItemFragment();
    Button button ;
    private DatalistViewModel datalistViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem);
        datalistViewModel = new ViewModelProvider(this).get(DatalistViewModel.class);
        String filename = "defaultdata";
        try {
            InputStream is = getApplicationContext().getAssets().open(filename);//new FileInputStream(filename);
            datalistViewModel.readAsset(is);
        }catch (IOException e){

        }
        final Observer<List<DataItem>> dataItemObserver = new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                MemFragment currentFragment = (MemFragment)fm.findFragmentById(R.id.memfragment);
                MemViewAdapter memViewAdapter = currentFragment.getMyAdapter();
                //boolean tempVisiable = currentFragment.isContentVisable();
                //currentFragment.setContentVisable(!tempVisiable);
                //memViewAdapter.setVisiable(!tempVisiable);//(!myItemRecyclerViewAdapter.getIdVisiable());
                memViewAdapter.notifyDataSetChanged();
            }
        };
        datalistViewModel.getDatalist().observe(this,dataItemObserver);
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
