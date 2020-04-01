package com.shiguang1q84.clovermemory.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

import com.shiguang1q84.clovermemory.R;
import com.shiguang1q84.clovermemory.SinglePageFragment;
import com.shiguang1q84.clovermemory.data.DatalistViewModel;

import java.util.List;

public class MyPagerViewAdapter extends FragmentStateAdapter implements MemViewAdapter {

    boolean isVisiable = true;
    DatalistViewModel dataList;

    public boolean isVisiable() {
        return isVisiable;
    }

    public void setVisiable(boolean visiable) {
        isVisiable = visiable;
    }

    public MyPagerViewAdapter(@NonNull Fragment fragment, DatalistViewModel dataList) {
        super(fragment);
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.e("MYPAGERVIEW ADAPTER", "createfragment position:"+position);
        Fragment fragment = new SinglePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index",position);
        bundle.putBoolean("isvisable",isVisiable);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public long getItemId(int position) {
        Log.e("MYPAGERVIEW ADAPTER", "getItemId position:"+position);
        Fragment fragment = new SinglePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index",position);
        bundle.putBoolean("isvisable",isVisiable);
        fragment.setArguments(bundle);
        return super.getItemId(position);
    }


    @Override
    public void onBindViewHolder(@NonNull FragmentViewHolder holder, int position, @NonNull List<Object> payloads) {
        TextView tempContent = holder.itemView.findViewById(R.id.item_text);
        if(tempContent != null){
            tempContent.setText(dataList.getDatalist().getValue().get(position).getContent());
            if(isVisiable){
                tempContent.setVisibility(View.VISIBLE);
            }else{
                tempContent.setVisibility(View.INVISIBLE);
            }
        }
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        if(dataList==null){
            return 0;
        }
        else {
            return dataList.getSize();
        }
    }



}

