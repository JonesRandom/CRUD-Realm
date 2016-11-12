package com.jonesrandom.CRUDRealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RealmHelper helper;
    ArrayList<DaftarModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new RealmHelper(this);
        data = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initData();

        Button tambah = (Button)findViewById(R.id.tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TambahData.class));
            }
        });

    }

    public void initData() {

        TextView empty = (TextView)findViewById(R.id.empty);

        try {
            data = helper.SemuaData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (data.size() < 1) {
            empty.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Data Kosong", Toast.LENGTH_LONG).show();
        } else {
            DaftarAdapter adapter = new DaftarAdapter(data, new DaftarAdapter.OnDaftarDiKlik() {
                @Override
                public void onClick(DaftarModel model) {

                    Intent detail = new Intent(MainActivity.this, Detail.class);
                    detail.putExtra("id", model.getId());
                    detail.putExtra("nama", model.getNama());
                    detail.putExtra("alamat", model.getAlamat());

                    startActivity(detail);

                }
            });
            recyclerView.setAdapter(adapter);
            empty.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        data.clear();
        initData();
    }
}
