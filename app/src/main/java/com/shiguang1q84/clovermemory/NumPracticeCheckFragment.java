package com.shiguang1q84.clovermemory;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumPracticeCheckFragment extends Fragment {

    EditText numListEditText;
    Button checkoutButton;
    TextView numListTextView;


    public NumPracticeCheckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_num_practice_check, container, false);
        if(view == null){
            return null;
        }
        numListEditText = view.findViewById(R.id.numlist_edittext);
        numListTextView = view.findViewById(R.id.numlist_textview);
        checkoutButton = view.findViewById(R.id.button2checkout);

        return view;
    }

}
