package com.blogspot.abzuxcode.mytodolist.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blogspot.abzuxcode.mytodolist.R;
import com.blogspot.abzuxcode.mytodolist.model.Todo;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodoFragment extends Fragment {


    public TodoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Toodo toodo = new Toodo(1, "Makan malam",
        //        "Makan malam bersama teman","besok","toodo" );
        //tampilkan nama
        //Log.d("NAMA", toodo.getNama());
        // ubah nama
        //toodo.setNama("Makan Bersama");
        //tampilkan nama
        //Log.d("NAMA", toodo.getNama());
        return inflater.inflate(R.layout.fragment_todo, container, false);
    }

}
