package com.blogspot.abzuxcode.mytodolist.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.blogspot.abzuxcode.mytodolist.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    //nama database
    private static final String NAMA_DATABASE = "db_todo";
    //versi Ddatabase
    private static final int VERSI_DATABASE = 1;

    //constructor
    public MyDatabaseHelper(Context context){
        super(context, NAMA_DATABASE, null,VERSI_DATABASE);
    }

    //menjalankan setup awal
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //buat table pertama kali ketika aplikasi diinstal
        sqLiteDatabase.execSQL(Todo.BUAT_TABEL);
    }

    //menjalankan perubahan pada database maupun table
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //jika table ada sebelumnya , maka hapus tabel yang sudah ada
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Todo.NAMA_TABEL);

        //buat table lagi
        onCreate(sqLiteDatabase);

    }

    //fungsi untuk menyimpan data
    public long simpleData(String nama, String deskripsi, String kategori){
        //akses database untuk menambah data
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // komponen untuk menyimpan data
        ContentValues contentValues = new ContentValues();

        //masukkan data kedalam content value
        contentValues.put(Todo.COLUMN_NAMA, nama);
        contentValues.put(Todo.COLUMN_DESKRIPSI, deskripsi);
        contentValues.put(Todo.COLUMN_KATEGORI, kategori);

        //masukkan data row
        long id = sqLiteDatabase.insert(Todo.NAMA_TABEL,null,contentValues);

        //tutup databse
        sqLiteDatabase.close();

        // keluarkan hasil id dari proses penyimpanan data
        return id;


    }

    //membuat 1 row data berdasarkan id
    public  Todo getTodo(long id){
        //minta akses mengambil data
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //posisikan cursor tabel kedalam data yang dituju
        Cursor cursor = sqLiteDatabase.query(Todo.NAMA_TABEL, new String[]{
                Todo.COLUMN_ID,
                Todo.COLUMN_NAMA,
                Todo.COLUMN_DESKRIPSI,
                Todo.COLUMN_WAKTU,
                Todo.COLUMN_DESKRIPSI
                },
                Todo.COLUMN_ID + "?=", new String[] {String.valueOf(id)},
                null, null, null, null
        );

        //posisikan data yang dipilih cursor kepaling atas/
        //posisikan cursor ke atas
        if (cursor != null)
            cursor.moveToFirst();


        //data yang telah ditemukan dimasukkan kedalam model
        Todo todo = new Todo(
                cursor.getInt(cursor.getColumnIndex(Todo.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Todo.COLUMN_NAMA)),
                cursor.getString(cursor.getColumnIndex(Todo.COLUMN_DESKRIPSI)),
                cursor.getString(cursor.getColumnIndex(Todo.COLUMN_WAKTU)),
                cursor.getString(cursor.getColumnIndex(Todo.COLUMN_KATEGORI))

        );

        // hilangkan cursor beserta koneksi database
        cursor.close();

        //kembalikan data
        return todo;
    }

    //mengambil seluruh data
    public List<Todo> ambilSemuaData(){
        List<Todo> listTodo = new ArrayList<>();

        //Query mengambil semua daata
        String query = " SELECT * FROM " + Todo.NAMA_TABEL + " ORDER BY " + Todo.COLUMN_WAKTU +"DESC";

        SQLiteDatabase sqLiteDatabase =  this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        //masukkan data ke list
        if (cursor.moveToFirst()){
            do {
                Todo todo = new Todo();
                        todo.setId(cursor.getInt(cursor.getColumnIndex(Todo.COLUMN_ID)));
                        todo.setNama(cursor.getString(cursor.getColumnIndex(Todo.COLUMN_NAMA)));
                        todo.setDeskripsi(cursor.getString(cursor.getColumnIndex(Todo.COLUMN_DESKRIPSI)));
                        todo.setWaktu(cursor.getString(cursor.getColumnIndex(Todo.COLUMN_WAKTU)));
                        todo.setKategori(cursor.getString(cursor.getColumnIndex(Todo.COLUMN_KATEGORI)));

                        listTodo.add(todo);
            }while (cursor.moveToNext());
        }

        //tutup koneksi , hilangkan cursor
        sqLiteDatabase.close();

        return listTodo;
    }

    public int ambilJumlahData() {
        String query = " SELECT * FROM " + Todo.NAMA_TABEL;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        int jumlah = cursor.getCount();
        cursor.close();

        return jumlah;
    }

    public int updateTodo (Todo todo){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Todo.COLUMN_NAMA, todo.getNama());
        values.put(Todo.COLUMN_DESKRIPSI, todo.getDeskripsi());
        values.put(Todo.COLUMN_KATEGORI, todo.getKategori());

        return  sqLiteDatabase.update(Todo.NAMA_TABEL, values,
                Todo.COLUMN_ID + "?=",
                new String[] {String.valueOf(todo.getId())});
    }

    public void hapusData (Todo todo){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(Todo.NAMA_TABEL, Todo.COLUMN_ID + "?=",
                new String[] {String.valueOf(todo.getId())});
    }
}
