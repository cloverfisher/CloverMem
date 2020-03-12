package com.shiguang1q84.clovermemory.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.shiguang1q84.clovermemory.ItemFragment;
import com.shiguang1q84.clovermemory.R;
import com.shiguang1q84.clovermemory.data.DataInterface;

import java.util.List;

public class MyPagerViewAdapter extends MyItemRecyclerViewAdapter {


    public MyPagerViewAdapter(List<DataInterface> items, ItemFragment.OnListFragmentInteractionListener listener) {
        super(items, listener);
    }

    @Override
    public RemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pager
                        , parent, false);
        return new RemViewHolder(view);
    }
}

