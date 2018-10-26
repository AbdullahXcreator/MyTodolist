package com.blogspot.abzuxcode.mytodolist.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blogspot.abzuxcode.mytodolist.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DonedoFragment extends Fragment {


    public DonedoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donedo, container, false);
    }

}
