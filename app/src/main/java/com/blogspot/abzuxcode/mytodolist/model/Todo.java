package com.blogspot.abzuxcode.mytodolist.model;

public class Todo {
    public static final String NAMA_TABEL = "tb_todo";

    //variable konstan hanya untuk penamaan field saja
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_DESKRIPSI = "deskripsi";
    public static final String COLUMN_WAKTU = "waktu";
    public static final String COLUMN_KATEGORI = "kategori";

    // variable biasa untuk menampung data yang berubah uba
    private int id;
    private  String nama;
    private  String deskripsi;
    private  String waktu;
    private  String kategori;

    //membuat table SQLite
    public static  final  String BUAT_TABEL = "CREATE TABLE "
            + NAMA_TABEL + "("
            + COLUMN_ID + " INTEGER PRIMARY KEYAUTOINCREMENT,"
            + COLUMN_NAMA + "TEXT,"
            + COLUMN_DESKRIPSI + "TEXT,"
            + COLUMN_WAKTU + "DATETIME DEFAULT CURRENT_TIMESTAMP,"
            + COLUMN_KATEGORI + "TEXT" + ")";

    //constructor untuk memasukkan data kedalam class model ini
    public Todo(int id, String nama, String deskripsi, String waktu, String kategori) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.waktu = waktu;
        this.kategori = kategori;
    }

    public Todo() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }






}
