package com.example.dosenklp1.logbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dosenklp1.R;
import java.util.ArrayList;


public class ListAdapterLogbook extends  RecyclerView.Adapter<ListAdapterLogbook.MyViewHolder>{

    ArrayList<Logbook> listLogbook = new ArrayList<>();

    public ListAdapterLogbook(ArrayList<Logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_logbook, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Logbook logbook = listLogbook.get(position);
        holder.textBulan.setText(logbook.getBulan());
        holder.textTanggal.setText(logbook.getTanggal());
        holder.textKet.setText(logbook.getKeterangan());

    }

    @Override
    public int getItemCount() {
        return listLogbook.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textBulan, textTanggal, textKet;
        ImageView check, edit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textBulan = itemView.findViewById(R.id.bulan);
            textTanggal = itemView.findViewById(R.id.tanggal);
            textKet = itemView.findViewById(R.id.keterangan);
            check = itemView.findViewById(R.id.check);
            edit = itemView.findViewById(R.id.edit);

        }


    }


}
