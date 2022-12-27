package com.example.dosenklp1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dosenklp1.R;
import com.example.dosenklp1.models.Mahasiswa;

import java.util.ArrayList;


public class ListAdapter extends  RecyclerView.Adapter<ListAdapter.MyViewHolder>{

    ArrayList<Mahasiswa> listData = new ArrayList<>();
    ItemMahasiswaClickListener mahasiswaClickListener;

    public ListAdapter(ArrayList<Mahasiswa> listData){

        this.listData = listData;
    }

    public ListAdapter(ArrayList<Mahasiswa> listData, ItemMahasiswaClickListener mahasiswaClickListener) {
        this.listData = listData;
        this.mahasiswaClickListener = mahasiswaClickListener;
    }

    public void setListData(ArrayList<Mahasiswa> listData) {
        this.listData = listData;
    }

    public void setMahasiswaClickListener(ItemMahasiswaClickListener mahasiswaClickListener) {
        this.mahasiswaClickListener = mahasiswaClickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Mahasiswa mahasiswa = listData.get(position);
        holder.profil.setImageResource(R.drawable.ic_launcher_background);
        holder.textNama.setText(mahasiswa.getNama());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public interface ItemMahasiswaClickListener{
        void onItemMahasiswaClick(Mahasiswa mahasiswa);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textNama;
        ImageView profil;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textNama = itemView.findViewById(R.id.name);
            profil = itemView.findViewById(R.id.profilpicture);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Mahasiswa mahasiswa = listData.get(getBindingAdapterPosition());
            mahasiswaClickListener.onItemMahasiswaClick(mahasiswa);
        }
    }
}
