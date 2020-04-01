package com.shiguang1q84.clovermemory.view;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shiguang1q84.clovermemory.ItemFragment.OnListFragmentInteractionListener;
import com.shiguang1q84.clovermemory.R;
import com.shiguang1q84.clovermemory.data.DataItem;
import com.shiguang1q84.clovermemory.data.DatalistViewModel;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a DataItem and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<RemViewHolder> implements MemViewAdapter {

    //private  List<DataItem> mValues;
    private  OnListFragmentInteractionListener mListener;
    private boolean isVisable=true;
    private DatalistViewModel mValues;

//    public MyItemRecyclerViewAdapter(List<DataItem> items, OnListFragmentInteractionListener listener) {
//        mValues = items;
//        mListener = listener;
//    }

    public MyItemRecyclerViewAdapter(DatalistViewModel items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public RemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycle
                        , parent, false);
        return new RemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RemViewHolder holder, final int position) {
        //holder.mItem = mValues.get(position);
        List<DataItem> dataItems = mValues.getDatalist().getValue();
        if(dataItems==null){
            return;
        }
        holder.mItem = dataItems.get(position);
        holder.mIdView.setText(holder.mItem.getHead());
        holder.mContentView.setText(holder.mItem.getContent());
        if(isVisable){
            holder.mContentView.setVisibility(View.VISIBLE);
        }
        else{
            holder.mContentView.setVisibility(View.INVISIBLE);
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.dosomething(position);
                }
            }
        });
    }

//    public void setIdVisiable(boolean isVisiable){
//        this.isVisable = isVisiable;
//    }
    public boolean getIdVisiable(){
        return this.isVisable;
    }
    @Override
    public int getItemCount() {
        return mValues.getSize();
    }

    @Override
    public void setVisiable(boolean isVisable) {
        this.isVisable = isVisable;
    }

    @Override
    public boolean isVisiable() {
        return isVisable;
    }
}
