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
import com.example.dosenklp1.models.Student;

import java.util.ArrayList;


public class ListAdapter extends  RecyclerView.Adapter<ListAdapter.MyViewHolder>{

    ArrayList<Student> listData;
    ItemMahasiswaClickListener mahasiswaClickListener;

    public ListAdapter(ArrayList<Student> listData){
        this.listData = listData;
        notifyDataSetChanged();
    }

    public ListAdapter(ArrayList<Student> listData, ItemMahasiswaClickListener mahasiswaClickListener) {
        this.listData = listData;
        this.mahasiswaClickListener = mahasiswaClickListener;
    }

    public void setListData(ArrayList<Student> listData) {
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
        Student student = listData.get(position);
        holder.textNama.setText(student.getName());
        holder.profil.setImageResource(R.drawable.ic_launcher_background);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public interface ItemMahasiswaClickListener{
        void onItemMahasiswaClick(Student student);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textNama;
        ImageView profil;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textNama = itemView.findViewById(R.id.name);
            profil = itemView.findViewById(R.id.profilpicture);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Student student = listData.get(getBindingAdapterPosition());
                    mahasiswaClickListener.onItemMahasiswaClick(student);

                }
            });

        }

    }
}
