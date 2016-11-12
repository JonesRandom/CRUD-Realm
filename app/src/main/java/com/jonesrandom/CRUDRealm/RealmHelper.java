package com.jonesrandom.CRUDRealm;

import android.content.Context;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class RealmHelper {

    private static final String TAG = "REALM_HELPER";

    private Realm realm;
    private RealmResults<Daftar> results;
    public Context context;

    public RealmHelper(Context context) {
        realm = Realm.getInstance(context);
        this.context = context;
    }

    public void TambahData(String nama, String alamat) {

        Daftar daftar = new Daftar();
        daftar.setId((int) (System.currentTimeMillis() / 1000));
        daftar.setNama(nama);
        daftar.setAlamat(alamat);

        realm.beginTransaction();
        realm.copyToRealm(daftar);
        realm.commitTransaction();

    }

    public ArrayList<DaftarModel> SemuaData() {

        ArrayList<DaftarModel> daftarModel = new ArrayList<>();

        results = realm.where(Daftar.class).findAll();
        results.sort("Nama", Sort.ASCENDING);

        for (int i = 0; i < results.size(); i++) {

            int id = results.get(i).getId();
            String nama = results.get(i).getNama();
            String alamat = results.get(i).getAlamat();

            daftarModel.add(new DaftarModel(id, nama, alamat));

        }

        return daftarModel;
    }

    public void EditData(int id, String Nama, String Alamat) {

        realm.beginTransaction();
        Daftar daftar = realm.where(Daftar.class).equalTo("id",id).findFirst();
        daftar.setNama(Nama);
        daftar.setAlamat(Alamat);
        realm.commitTransaction();

    }

    public void HapusData(int id) {

        RealmResults<Daftar> daftar = realm.where(Daftar.class).equalTo("id",id).findAll();

        realm.beginTransaction();
        daftar.remove(0);
        daftar.removeLast();
        daftar.clear();
        realm.commitTransaction();

    }


}
