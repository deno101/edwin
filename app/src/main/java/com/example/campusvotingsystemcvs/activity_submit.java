package com.example.campusvotingsystemcvs;

import android.os.Bundle;

import com.example.campusvotingsystemcvs.recycleradapter.RecyclerViewAdapter;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class activity_submit extends AppCompatActivity {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> adms = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        recyclerView = findViewById(R.id.myRecycler);
        populateArrayList();
        initRecyclerView();
    }

    private void populateArrayList() {
        String[] names = {"John doe", "Sam kay", "Mark Stones"};

        String[] adms = {"COM/001", "COM/M/2017", "EDS/34/67", "STA/2018/M"};

        for (int i = 0; i < 10; i++) {
            this.names.add(names[(int) (Math.random() * 3)]);
            this.adms.add(adms[(int) (Math.random() * 3)]);
        }
    }

    private void initRecyclerView() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(names, adms);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
