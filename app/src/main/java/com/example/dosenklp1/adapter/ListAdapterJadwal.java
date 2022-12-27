package com.example.dosenklp1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dosenklp1.R;
import com.example.dosenklp1.models.Data;


public class ListAdapterJadwal extends  RecyclerView.Adapter<ListAdapterJadwal.MyViewHolder>{

    String[] list;

    public ListAdapterJadwal(String[] list){
        this.list = Data.names;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jadwal, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(Data.names[position]);
    }

    @Override
    public int getItemCount() {
        return Data.names.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewNamaMahasiswa);
        }
    }
}
