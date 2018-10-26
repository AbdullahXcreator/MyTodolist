package com.blogspot.abzuxcode.mytodolist.fragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blogspot.abzuxcode.mytodolist.fragment.MyMenuViewHolder;
import com.blogspot.abzuxcode.mytodolist.R;

class MyMenuAdapter extends RecyclerView.Adapter<MyMenuViewHolder> {
    String[] menu;
    int[] gambar;
    Activity activity;

    public MyMenuAdapter(FragmentActivity activity, String[] menuApp, int[] menuGambar) {
        //memasukkan data dari parameter ke variable didalam class
        menu = menuApp;
        this.activity = activity;
        gambar = menuGambar;
    }

    @NonNull
    @Override
    public MyMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //memasang layout dan menghubungkan dengan viewholder
        View view = LayoutInflater.from(activity).inflate(R.layout.menu_row, parent, false);
        return  new MyMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMenuViewHolder holder, int i) {
        //memasang data ke layout viewhodlder
        holder.txtmenuitem.setText(menu [i]);
        holder.imgmenuitem.setImageResource(gambar[i]);


    }

    @Override
    public int getItemCount() {
        //memasukkan total data yang tampil
        return menu.length;
    }
}
