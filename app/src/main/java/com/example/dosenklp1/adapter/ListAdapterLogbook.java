package com.example.dosenklp1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dosenklp1.R;
import com.example.dosenklp1.models.Logbook;

import java.util.ArrayList;


public class ListAdapterLogbook extends  RecyclerView.Adapter<ListAdapterLogbook.MyViewHolder>{

    ArrayList<Logbook> listLogbook = new ArrayList<>();
    ItemLogbookClickListener logbookClickListener;

    public ListAdapterLogbook(ArrayList<Logbook> listLogbook) {

        this.listLogbook = listLogbook;
    }
    public ListAdapterLogbook(ArrayList<Logbook> listLogbook, ItemLogbookClickListener logbookClickListener) {
        this.listLogbook = listLogbook;
        this.logbookClickListener = logbookClickListener;
    }

    public void setListLogbook(ArrayList<Logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    public void setLogbookClickListener(ItemLogbookClickListener logbookClickListener) {
        this.logbookClickListener = logbookClickListener;
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

    public interface ItemLogbookClickListener{
        void onItemLogbookClick(Logbook logbook);
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

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Logbook logbook = listLogbook.get(getBindingAdapterPosition());
                    logbookClickListener.onItemLogbookClick(logbook);
                }
            });

        }


    }


}
