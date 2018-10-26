package com.blogspot.abzuxcode.mytodolist;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.blogspot.abzuxcode.mytodolist.db.MyDatabaseHelper;
import com.blogspot.abzuxcode.mytodolist.fragment.DonedoFragment;
import com.blogspot.abzuxcode.mytodolist.fragment.FragmentHome;
import com.blogspot.abzuxcode.mytodolist.fragment.TodoFragment;
import com.blogspot.abzuxcode.mytodolist.model.Todo;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tampilDialogtodo();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void tampilDialogtodo(){
        //tempelkan ke dalam view
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.dialog_todo, null);

        //pasang view ke dalam alert dialog
        AlertDialog.Builder alertDialogInput = new AlertDialog.Builder(this);
        alertDialogInput.setView(view);

        //inisialisai komponen dalam dialog
        final EditText edInNama = view.findViewById(R.id.edInNama);
        final EditText edInDesk = view.findViewById(R.id.edInDesk);
        TextView txtInTitle = view.findViewById(R.id.txtInTitle);

        txtInTitle.setText("New Todo");

        alertDialogInput
                .setCancelable(false)
                .setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        //memasang tombol ke alert dialog
         final AlertDialog alertDialog = alertDialogInput.create();
         alertDialog.show();

         alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //cek apakah kode kosong
                 if (TextUtils.isEmpty(edInNama.getText().toString())){
                     edInNama.setError("Nama Harus Diisi");
                     edInNama.requestFocus();
                 }else if (TextUtils.isEmpty(edInDesk.getText().toString())){
                     edInDesk.setError("Deskripsi Harus Diisi");
                     edInDesk.requestFocus();
                 }else {
                     alertDialog.dismiss();
                 }

                 //simpan data ke database
                 myDatabaseHelper.simpleData(edInNama.getText().toString(),
                         edInDesk.getText().toString(), "todo");
             }
         });
    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Home) {
            // Handle the camera action
            FragmentHome home = new FragmentHome();
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().replace(R.id.container,home).commit();


        } else if (id == R.id.nav_todo) {
            TodoFragment todo = new  TodoFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().replace(R.id.container,todo).commit();


        } else if (id == R.id.nav_done) {
            DonedoFragment done = new  DonedoFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().replace(R.id.container,done).commit();

        } else if (id == R.id.nav_feedback) {
            Intent opengmail = new Intent(Intent.ACTION_SEND);
            opengmail.setType("text/plain");
            opengmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"abdullahsulam21@gmail.com"});
            opengmail.putExtra(Intent.EXTRA_SUBJECT,"Feedback My Todolist");
            startActivity(opengmail);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
