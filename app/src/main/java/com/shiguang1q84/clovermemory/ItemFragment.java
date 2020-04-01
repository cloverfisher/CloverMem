package com.shiguang1q84.clovermemory;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shiguang1q84.clovermemory.data.DatalistViewModel;
import com.shiguang1q84.clovermemory.view.MemViewAdapter;
import com.shiguang1q84.clovermemory.view.MyItemRecyclerViewAdapter;

import java.io.IOException;
import java.io.InputStream;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends MemFragment {

    // TODO: Customize parameters
    private int mColumnCount = 5;
    private OnListFragmentInteractionListener mListener;
    private MyItemRecyclerViewAdapter myItemRecyclerViewAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);


        mListener = new OnListFragmentInteractionListener() {

            @Override
            public void dosomething(int position) {
                FragmentManager fm = getParentFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment = new PagerFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("position",position);
                fragment.setArguments(bundle);
                transaction.addToBackStack(null);
                transaction.replace(R.id.memfragment,fragment);
                transaction.commit();
            }
        };
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }



            String filename = "defaultdata";
     //           InputStream is = getContent().getAssets().open(filename);
            DatalistViewModel datalistViewModel = new ViewModelProvider(getActivity()).get(DatalistViewModel.class);//new DatalistViewModel(is);
            myItemRecyclerViewAdapter = new MyItemRecyclerViewAdapter(datalistViewModel, mListener);

           // myItemRecyclerViewAdapter.setVisiable(super.isContentVisable());
            recyclerView.setAdapter(myItemRecyclerViewAdapter);
        }
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        myItemRecyclerViewAdapter.setVisiable(super.isContentVisable());
        myItemRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        //void onListFragmentInteraction(DataInterface item);
        void dosomething(int position);
    }

    public MemViewAdapter getMyAdapter(){
        return  myItemRecyclerViewAdapter;
    }
}
