package com.example.project_;

public class List {
    private String gambar;
    private String nama;
    private String deskripsi;
    private String sejarah;
    private String ciri;

    public List(String datagambar, String datanama, String datadeskripsi, String datasejarah, String dataciri){
        gambar = datagambar;
        nama = datanama;
        deskripsi = datadeskripsi;
        sejarah = datasejarah;
        ciri = dataciri;
    }

    public String getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getSejarah() {
        return sejarah;
    }

    public String getCiri() {
        return ciri;
    }
}
