package com.example.dosenklp1.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dosenklp1.R;
import com.example.dosenklp1.models.Bimbingan;

import java.util.ArrayList;


public class ListAdapterBimbingan extends  RecyclerView.Adapter<ListAdapterBimbingan.MyViewHolder>{

    ArrayList<Bimbingan> listPermintaan = new ArrayList<>();
    ItemPermintaanClickListener permintaanClickListener;

    public ListAdapterBimbingan(ArrayList<Bimbingan> listPermintaan, ItemPermintaanClickListener permintaanClickListener) {
        this.listPermintaan = listPermintaan;
        this.permintaanClickListener = permintaanClickListener;
    }

    public ListAdapterBimbingan(ArrayList<Bimbingan> listPermintaan) {
        this.listPermintaan = listPermintaan;
    }

    public void setListPermintaan(ArrayList<Bimbingan> listPermintaan) {
        this.listPermintaan = listPermintaan;
    }

    public void setPermintaanClickListener(ItemPermintaanClickListener permintaanClickListener) {
        this.permintaanClickListener = permintaanClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_permintaan_bimbingan, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Bimbingan bimbingan = listPermintaan.get(position);
        holder.profil.setImageResource(R.drawable.ic_launcher_background);
        holder.textNama.setText(bimbingan.getNama());
        holder.textNim.setText(bimbingan.getNim());
        holder.textJudul.setText(bimbingan.getJudul());



    }

    @Override
    public int getItemCount() {
        return listPermintaan.size();
    }

    public interface ItemPermintaanClickListener{
        void onItemPermintaanClick(Bimbingan bimbingan);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textNama, textNim, textJudul;
        ImageView profil;
        Button terima, tolak;
        Boolean check = false;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textNama = itemView.findViewById(R.id.nama);
            textNim = itemView.findViewById(R.id.nim);
            textJudul = itemView.findViewById(R.id.judulSkripsi);
            profil = itemView.findViewById(R.id.profilMahasiswa);
            terima = itemView.findViewById(R.id.buttonAccept);
            tolak = itemView.findViewById(R.id.buttonDecline);

            terima.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View view) {
                    Bimbingan bimbingan = listPermintaan.get(getBindingAdapterPosition());
                    permintaanClickListener.onItemPermintaanClick(bimbingan);
                    check = true;
                    terima.setBackgroundColor(R.color.brightGreen);
                    terima.setTextColor(R.color.white);


                }
            });

            tolak.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View view) {
                    Bimbingan bimbingan = listPermintaan.get(getBindingAdapterPosition());
                    permintaanClickListener.onItemPermintaanClick(bimbingan);
                    check = true;
                    tolak.setBackgroundColor(R.color.red);
                    tolak.setTextColor(R.color.white);

                }
            });
        }

    }
}
