package com.jonesrandom.CRUDRealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Detail extends AppCompatActivity implements View.OnClickListener {

    EditText Nama, Alamat;
    Button Simpan, Hapus;
    RealmHelper helper;

    String i_nama, i_alamat;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        helper = new RealmHelper(this);

        Nama = (EditText)findViewById(R.id.edit_nama);
        Alamat = (EditText)findViewById(R.id.edit_nlamat);

        Simpan = (Button)findViewById(R.id.simpan);
        Hapus = (Button)findViewById(R.id.hapus);

        Simpan.setOnClickListener(this);
        Hapus.setOnClickListener(this);

        initData();
    }

    public void initData() {

        i_nama = getIntent().getStringExtra("nama");
        i_alamat = getIntent().getStringExtra("alamat");
        id = getIntent().getIntExtra("id",0);

        Nama.setText(i_nama);
        Alamat.setText(i_alamat);
    }

    @Override
    public void onClick(View view) {

        String nama = Nama.getText().toString();
        String alamat = Alamat.getText().toString();

        switch (view.getId()) {

            case R.id.simpan:
                helper.EditData(id,nama,alamat);
                break;
            case R.id.hapus:
                helper.HapusData(id);
                break;
        }

        finish();

    }
}
