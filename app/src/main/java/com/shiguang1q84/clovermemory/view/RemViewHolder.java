package com.shiguang1q84.clovermemory.view;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.shiguang1q84.clovermemory.R;
import com.shiguang1q84.clovermemory.data.DataInterface;

public class RemViewHolder extends RecyclerView.ViewHolder{
    public final View mView;
    public final TextView mIdView;
    public final TextView mContentView;
    public DataInterface mItem;

    public RemViewHolder(View view) {
        super(view);
        mView = view;
        mIdView = (TextView) view.findViewById(R.id.item_head);
        mContentView = (TextView) view.findViewById(R.id.item_text);
       // mIdView.setVisibility(View.INVISIBLE);
    }

    @Override
    public String toString() {
        return super.toString() + " '" + mContentView.getText() + "'";
    }
}
