package com.shiguang1q84.clovermemory;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shiguang1q84.clovermemory.data.DataList;
import com.shiguang1q84.clovermemory.view.MemViewAdapter;
import com.shiguang1q84.clovermemory.view.MyPagerViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PagerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PagerFragment extends MemFragment {

    private OnFragmentInteractionListener mListener;
    private ViewPager2 viewpager;
    private int position;
    MyPagerViewAdapter pagerViewAdapter;
    public PagerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FlipperFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PagerFragment newInstance(String param1, String param2) {
        PagerFragment fragment = new PagerFragment();
        return fragment;
    }


    public static PagerFragment newInstance() {
        PagerFragment fragment = new PagerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position",0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pager, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewpager = view.findViewById(R.id.pager);
        DataList dataList = new DataList(getContext());
        pagerViewAdapter = new MyPagerViewAdapter(this,dataList);
        viewpager.setAdapter(pagerViewAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("PAGERFRAGMENT", "position=" + position);

        viewpager.setCurrentItem(position,false);
        pagerViewAdapter.setVisiable(super.isContentVisable());
        pagerViewAdapter.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    protected MemViewAdapter getMyAdapter() {
        return pagerViewAdapter;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
