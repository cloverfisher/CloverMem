package com.shiguang1q84.clovermemory.view;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shiguang1q84.clovermemory.ItemFragment.OnListFragmentInteractionListener;
import com.shiguang1q84.clovermemory.R;
import com.shiguang1q84.clovermemory.data.DataInterface;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a DataItem and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<RemViewHolder> {

    private  List<DataInterface> mValues;
    private  OnListFragmentInteractionListener mListener;
 //   private MyItemRecyclerViewAdapter myItemRecyclerViewAdapter;

    public MyItemRecyclerViewAdapter(List<DataInterface> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

//    public MyItemRecyclerViewAdapter newInstance(List<DataInterface> items, OnListFragmentInteractionListener listener){
//        if(myItemRecyclerViewAdapter == null){
//            this.mValues = items;
//            this.mListener = listener;
//        }
//        return myItemRecyclerViewAdapter;
//    }

//    private MyItemRecyclerViewAdapter(List<DataInterface> items, OnListFragmentInteractionListener listener) {
//
//        mValues = items;
//        mListener = listener;
//    }

    @Override
    public RemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycle
                        , parent, false);
        return new RemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RemViewHolder holder, int position) {
        //holder.mItem = mValues.get(position);
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(holder.mItem.getHead());
        holder.mContentView.setText(holder.mItem.getContext());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.dosomething();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

}
