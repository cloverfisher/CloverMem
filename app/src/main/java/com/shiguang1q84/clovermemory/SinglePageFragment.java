package com.shiguang1q84.clovermemory;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.shiguang1q84.clovermemory.data.DataItem;
import com.shiguang1q84.clovermemory.data.DatalistViewModel;

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
        final int index = args.getInt("index",0);
        DatalistViewModel datalistViewModel = new ViewModelProvider(getActivity()).get(DatalistViewModel.class);
        DataItem dataItem = datalistViewModel.getDatalist().getValue().get(index);
        final String headstr = dataItem.getHead();//args.getString("head");
        final String contentstr = dataItem.getContent();//args.getString("content");
        boolean isVisable = args.getBoolean("isvisable");
        TextView head = view.findViewById(R.id.item_head);
        TextView content = view.findViewById(R.id.item_text);
        head.setText(headstr);
        content.setText(contentstr);
        if(isVisable) {
            content.setVisibility(View.VISIBLE);
        }else{
            content.setVisibility(View.INVISIBLE);
        }
        view.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                DialogFragment dialogFragment = new EditMemContentDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("index", index);
//                bundle.putString("head",headstr);
//                bundle.putString("content",contentstr);
                dialogFragment.setArguments(bundle);
                dialogFragment.show(getParentFragmentManager(),"aaa");
                return true;
            }
        });
    }
}
