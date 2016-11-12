package com.jonesrandom.CRUDRealm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Daftar extends RealmObject {

    @PrimaryKey
    private int id;
    private String Nama;
    private String Alamat;

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
