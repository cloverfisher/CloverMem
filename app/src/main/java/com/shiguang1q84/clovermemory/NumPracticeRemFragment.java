package com.shiguang1q84.clovermemory;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;


public class NumPracticeRemFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    int arraylenth=0;

    public NumPracticeRemFragment() {
        // Required empty public constructor
    }

//    // TODO: Rename and change types and number of parameters
//    public static NumPracticeRemFragment newInstance(String param1, String param2) {
//        NumPracticeRemFragment fragment = new NumPracticeRemFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_num_practice_rem, container, false);
        final TextView textView = view.findViewById(R.id.numlist);
        SeekBar seekBar = view.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                arraylenth = progress;
                textView.setText(getRandomNumList(arraylenth));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        return view;

    }

    private String getRandomNumList(int arraylenth){
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(int i=0;i<arraylenth;i++){
            k = (int)(0+ Math.random()*10);
            sb.append(k);
        }
        return sb.toString();//String.valueOf(arraylenth);
    }
}
