package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dosenklp1.logbook.ListAdapterLogbook;
import com.example.dosenklp1.logbook.Logbook;

import java.util.ArrayList;

public class ListLogbookActivity extends AppCompatActivity implements ListAdapterLogbook.ItemLogbookClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        RecyclerView recyclerView = findViewById(R.id.list_logbook);
        ListAdapterLogbook adapterLogbook = new ListAdapterLogbook(getLogbook());
        adapterLogbook.setLogbookClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterLogbook);


    }

    public ArrayList<Logbook> getLogbook(){
        ArrayList<Logbook> listLogbook = new ArrayList<>();
        listLogbook.add(new Logbook(
               "September",
               "10/9/2022",
               "Penentuan Judul"
        ));
        listLogbook.add(new Logbook(
                "September",
                "26/9/2022",
                "Observasi objek"
        ));
        listLogbook.add(new Logbook(
                "September",
                "30/9/2022",
                "Observasi objek dan wawancara"
        ));
        listLogbook.add(new Logbook(
                "Oktober",
                "5/10/2022",
                "Penyelesaian bab 1"
        ));
        listLogbook.add(new Logbook(
                "Oktober",
                "7/10/2022",
                "Penyelesaian bab 1"
        ));
        return listLogbook;
    }

    public void main(View view) {
        Intent main = new Intent(this, ProfileTaActivity.class);
        startActivity(main);
    }

    @Override
    public void onItemLogbookClick(Logbook logbook) {
        Intent detailLogbook = new Intent(this, DetailLogbookActivity.class);
        startActivity(detailLogbook);
    }
}