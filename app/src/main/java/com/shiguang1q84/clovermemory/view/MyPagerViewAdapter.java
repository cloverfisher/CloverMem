package com.shiguang1q84.clovermemory.view;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

import com.shiguang1q84.clovermemory.ItemFragment;
import com.shiguang1q84.clovermemory.R;
import com.shiguang1q84.clovermemory.SinglePageFragment;
import com.shiguang1q84.clovermemory.data.DataInterface;
import com.shiguang1q84.clovermemory.data.DataItem;
import com.shiguang1q84.clovermemory.data.DataList;

import java.util.List;

public class MyPagerViewAdapter extends FragmentStateAdapter {

    DataList dataList;
    boolean isVisiable = true;

    public boolean isVisiable() {
        return isVisiable;
    }

    public void setVisiable(boolean visiable) {
        isVisiable = visiable;
    }

    public MyPagerViewAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public MyPagerViewAdapter(@NonNull Fragment fragment, DataList dataList) {

        super(fragment);
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.e("MYPAGERVIEW ADAPTER", "position:"+position);
        Fragment fragment = new SinglePageFragment();
        Bundle bundle = new Bundle();
        DataItem dataItem = dataList.getDataItem(position);
        bundle.putString("head",dataItem.getHead());
        bundle.putString("context",dataItem.getContext());
        bundle.putBoolean("isvisable",isVisiable);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public long getItemId(int position) {
        Fragment fragment = new SinglePageFragment();
        Bundle bundle = new Bundle();
        DataItem dataItem = dataList.getDataItem(position);
        bundle.putString("head",dataItem.getHead());
        bundle.putString("context",dataItem.getContext());
        bundle.putBoolean("isvisable",isVisiable);

        fragment.setArguments(bundle);
        return super.getItemId(position);
    }





    @Override
    public void onBindViewHolder(@NonNull FragmentViewHolder holder, int position, @NonNull List<Object> payloads) {

        TextView temptext = holder.itemView.findViewById(R.id.item_text);
        if(temptext != null){
            if(isVisiable){
                temptext.setVisibility(View.VISIBLE);
            }else{
                temptext.setVisibility(View.INVISIBLE);
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
            return dataList.getLength();
        }
    }



}

