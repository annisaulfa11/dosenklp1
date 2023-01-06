package com.example.dosenklp1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dosenklp1.R;
import com.example.dosenklp1.fragments.JadwalFragment;
import com.example.dosenklp1.models.Bimbingan;
import com.example.dosenklp1.models.Data;
import com.example.dosenklp1.models.Jadwal;
import com.example.dosenklp1.models.Logbook;

import java.util.ArrayList;


public class ListAdapterJadwal extends  RecyclerView.Adapter<ListAdapterJadwal.MyViewHolder>{

    ArrayList<Jadwal> ListJadwal = new ArrayList<>();
    ItemJadwalClickListener jadwalClickListener;

    public ListAdapterJadwal(ArrayList<Jadwal> ListJadwal){
        this.ListJadwal = ListJadwal;
    }

    public ListAdapterJadwal (ArrayList<Jadwal> ListJadwal, ListAdapterJadwal.ItemJadwalClickListener jadwalClickListener) {
        this.ListJadwal = ListJadwal;
        this.jadwalClickListener = jadwalClickListener;
    }

    public void setListJadwal(ArrayList<Jadwal> ListJadwal) {
        this.ListJadwal = ListJadwal;
    }

    public void setJadwalClickListener(ListAdapterJadwal.ItemJadwalClickListener jadwalClickListener) {
        this.jadwalClickListener = jadwalClickListener;
    }


    @NonNull
    @Override
    //membuat viewholder untuk menampilkan data
    public ListAdapterJadwal.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListAdapterJadwal.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jadwal, parent, false));
    }

    @Override
    //untuk menempatkan data ke recyclerview
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Jadwal jadwal = ListJadwal.get(position);
        holder.ImageProfil.setImageResource(R.drawable.ic_launcher_background);
        holder.textNama.setText(jadwal.getNama());
        holder.textNIM.setText(jadwal.getNim());
        holder.textHariSeminar.setText(jadwal.getHariSeminar());
        holder.textRuangSeminar.setText(jadwal.getRuangSeminar());
        holder.textTimeSeminar.setText(jadwal.getWaktuSeminar());
        holder.textHariSidang.setText(jadwal.getHariSidang());
        holder.textRuangSidang.setText(jadwal.getRuangSidang());
        holder.textWaktuSidang.setText(jadwal.getWaktuSidang());

    }

    @Override
    public int getItemCount() {
        return ListJadwal.size();
    }

    public interface ItemJadwalClickListener {
        void onItemJadwalClick(Jadwal jadwal);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ImageProfil;
        TextView textNama, textNIM, textHariSeminar, textRuangSeminar, textTimeSeminar, textHariSidang, textRuangSidang, textWaktuSidang;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageProfil = itemView.findViewById(R.id.circleImageViewProfilePicture);
            textNama = itemView.findViewById(R.id.textViewNamaMahasiswa);
            textNIM = itemView.findViewById(R.id.textViewNIM);
            textHariSeminar = itemView.findViewById(R.id.hariSeminar);
            textRuangSeminar = itemView.findViewById(R.id.ruangSeminar);
            textTimeSeminar = itemView.findViewById(R.id.timeSeminar);
            textHariSidang = itemView.findViewById(R.id.hariSidang);
            textRuangSidang = itemView.findViewById(R.id.ruangSidang);
            textWaktuSidang = itemView.findViewById(R.id.timeSidang);

            textHariSidang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Jadwal jadwal = ListJadwal.get(getBindingAdapterPosition());
                    jadwalClickListener.onItemJadwalClick(jadwal);
                }
            });

            textRuangSidang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Jadwal jadwal = ListJadwal.get(getBindingAdapterPosition());
                    jadwalClickListener.onItemJadwalClick(jadwal);
                }
            });

            textWaktuSidang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Jadwal jadwal = ListJadwal.get(getBindingAdapterPosition());
                    jadwalClickListener.onItemJadwalClick(jadwal);
                }
            });

        }
    }
}
