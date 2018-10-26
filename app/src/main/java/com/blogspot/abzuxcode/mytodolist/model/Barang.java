package com.blogspot.abzuxcode.mytodolist.model;

public class Barang {
    public static final String NAMA_TABEL = "tb_barang";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BARANG = "barang";
    public static final String COLUMN_HARGA = "harga";
    public static final String COLUMN_KATEGORI = "kategori";
    public static final String COLUMN_TOTALHARGA = "total harga";
    public static final String COLUMN_LABA = "laba";
    public static final String COLUMN_RUGI = "rugi";

    private int id;
    private String barang;
    private int harga;
    private  String kategori;
    private int total_harga;
    private int laba;
    private int rugi;

    public static  final  String BUAT_TABEL = "CREATE TABLE "
            + NAMA_TABEL + "("
            + COLUMN_ID + " INTEGER PRIMARY KEYAUTOINCREMENT,"
            + COLUMN_BARANG + "TEXT,"
            + COLUMN_HARGA + "INTEGER,"
            + COLUMN_KATEGORI + "TEXT,"
            + COLUMN_TOTALHARGA + "INTEGER,"
            + COLUMN_LABA + "INTEGER,"
            + COLUMN_RUGI + "INTEGER" + ")";

    public Barang(int id, String barang, int harga, String kategori, int total_harga, int laba, int rugi) {
        this.id = id;
        this.barang = barang;
        this.harga = harga;
        this.kategori = kategori;
        this.total_harga = total_harga;
        this.laba = laba;
        this.rugi = rugi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public int getLaba() {
        return laba;
    }

    public void setLaba(int laba) {
        this.laba = laba;
    }

    public int getRugi() {
        return rugi;
    }

    public void setRugi(int rugi) {
        this.rugi = rugi;
    }
}
