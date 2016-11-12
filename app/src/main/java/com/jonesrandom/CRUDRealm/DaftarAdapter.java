package com.jonesrandom.CRUDRealm;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DaftarAdapter extends RecyclerView.Adapter<DaftarAdapter.DaftarHolder> {

    private ArrayList<DaftarModel> daftar;
    private OnDaftarDiKlik klik;

    public DaftarAdapter(ArrayList<DaftarModel> daftar, OnDaftarDiKlik klik) {
        this.daftar = daftar;
        this.klik = klik;
    }

    @Override
    public DaftarHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list,parent,false);
        DaftarHolder holder = new DaftarHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(DaftarHolder holder, int position) {

        holder.Klik(daftar.get(position), klik);
        holder.Nama.setText(daftar.get(position).getNama());
        holder.Alamat.setText(daftar.get(position).getAlamat());

    }

    @Override
    public int getItemCount() {
        return daftar.size();
    }

    public class DaftarHolder extends RecyclerView.ViewHolder{

        TextView Nama,Alamat;

        public DaftarHolder(View itemView) {
            super(itemView);

            Nama = (TextView) itemView.findViewById(R.id.row_nama);
            Alamat = (TextView) itemView.findViewById(R.id.row_alamat);

        }

        public void Klik(final DaftarModel model, final OnDaftarDiKlik daftarDiKlik) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    daftarDiKlik.onClick(model);
                }
            });
        }

    }

    public interface OnDaftarDiKlik {
        void onClick(DaftarModel model);
    }
}
