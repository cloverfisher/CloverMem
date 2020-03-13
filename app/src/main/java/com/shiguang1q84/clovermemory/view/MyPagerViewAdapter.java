package com.shiguang1q84.clovermemory.view;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.shiguang1q84.clovermemory.ItemFragment;
import com.shiguang1q84.clovermemory.R;
import com.shiguang1q84.clovermemory.SinglePageFragment;
import com.shiguang1q84.clovermemory.data.DataInterface;
import com.shiguang1q84.clovermemory.data.DataItem;
import com.shiguang1q84.clovermemory.data.DataList;

import java.util.List;

public class MyPagerViewAdapter extends FragmentStateAdapter {

    DataList dataList;

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
        fragment.setArguments(bundle);
        return fragment;
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

