package com.shiguang1q84.clovermemory;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.shiguang1q84.clovermemory.data.DataItem;
import com.shiguang1q84.clovermemory.data.DatalistViewModel;

import java.util.List;

public class EditMemContentDialogFragment extends DialogFragment {

    private  View memview;
    private TextView headText;
    private EditText contentText;
    private int index;
    private DataItem dataItem;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        memview= inflater.inflate(R.layout.fragment_dialog_memedit,null);
        builder.setView(memview);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DatalistViewModel datalistViewModel = new ViewModelProvider(getActivity()).get(DatalistViewModel.class);
                List<DataItem> dataItems =  datalistViewModel.getDatalist().getValue();
                DataItem dataItem = dataItems.get(index);
                dataItem.setContent(contentText.getText().toString());
                datalistViewModel.updateDataItem(dataItem);
//                String headStr = headText.getText().toString();
//                dataItems.set(index, new DataItem(headText.getText().toString(),contentText.getText().toString()));
                // TODO  setValues
                //datalistViewModel.getDatalist().setValue(dataItems);
            }
        });
        builder.setNegativeButton("CANCEL",null);
        return builder.create();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        index = bundle.getInt("index");
        DatalistViewModel datalistViewModel = new ViewModelProvider(getActivity()).get(DatalistViewModel.class);
        dataItem = datalistViewModel.getDatalist().getValue().get(index);
        String headstr = dataItem.getHead();//bundle.getString("head");
        String contentstr = dataItem.getContent();//bundle.getString("content");
        headText = memview.findViewById(R.id.item_head_dialog);
        contentText = memview.findViewById(R.id.item_content_dialog);
        headText.setText(headstr);
        contentText.setText(contentstr);
    }
}
