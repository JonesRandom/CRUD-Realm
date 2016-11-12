package com.jonesrandom.CRUDRealm;


public class DaftarModel {

    private int id;
    private String Nama;
    private String Alamat;

    public DaftarModel(int id, String nama, String alamat) {
        this.id = id;
        Nama = nama;
        Alamat = alamat;
    }

    public DaftarModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        this.Nama = nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        this.Alamat = alamat;
    }
}
