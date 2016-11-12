package com.jonesrandom.CRUDRealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahData extends AppCompatActivity {

    EditText Nama, Alamat;
    Button Tambah;
    RealmHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_data);

        helper = new RealmHelper(this);

        Nama = (EditText)findViewById(R.id.edit_nama);
        Alamat = (EditText)findViewById(R.id.edit_nlamat);

        Tambah = (Button)findViewById(R.id.tambah);
        Tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nama = Nama.getText().toString();
                String alamat = Alamat.getText().toString();

                if (nama.isEmpty() || alamat.isEmpty()) {
                    Toast.makeText(TambahData.this, "Field Harus Di Isi", Toast.LENGTH_SHORT).show();
                } else {
                    helper.TambahData(nama,alamat);
                    finish();
                }


            }
        });
    }
}
