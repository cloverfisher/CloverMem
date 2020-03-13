package com.shiguang1q84.clovermemory;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shiguang1q84.clovermemory.data.DataItem;

public class SinglePageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_pager,container,false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        String headstr = args.getString("head");
        String contextstr = args.getString("context");
        TextView head = view.findViewById(R.id.item_head);
        TextView context = view.findViewById(R.id.item_text);
        head.setText(headstr);
        context.setText(contextstr);
        //super.onViewCreated(view, savedInstanceState);

    }
}
