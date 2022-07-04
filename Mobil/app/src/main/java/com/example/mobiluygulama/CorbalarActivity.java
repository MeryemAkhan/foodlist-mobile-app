package com.example.mobiluygulama;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CorbalarActivity  extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Porsiyons> porsiyonsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corbalar);

        recyclerView = findViewById(R.id.recyclerView1);

        initData();
        setRecycleView();
    }

    private void setRecycleView() {
        PorsiyonsAdapter porsiyonsAdapter = new PorsiyonsAdapter(porsiyonsList);
        recyclerView.setAdapter(porsiyonsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {

        //adapterde olusturdugum nesnelerin icerisini doldurdum..
        porsiyonsList = new ArrayList<>(); //liste yapısını kullanmak için nesne ..
        porsiyonsList.add(new Porsiyons("Mercimek Çorbası","1 porsiyon (248 gr)","186 kcal ","Yağ 4,59 g\n" +
                "Karbonhidrat 26,61 g\n" +
                "Protein 10,42 g"));
        porsiyonsList.add(new Porsiyons("Yayla Çorbası ","1 porsiyon (100 g)","51 kcal","Yağ 1,9 g\n" +
                "Karbonhidrat 6,5 g\n" +
                "Protein 1,9 g"));
        porsiyonsList.add(new Porsiyons("Kremalı Mantar Çorbası ","1 porsiyon (248 g)","169 kcal","1 porsiyon (248 g) \t\t\t\t \t\t\t\n" +
                "Kal 169\n" +
                "Yağ 9,85 g\n" +
                "Karbonhidrat 14,21 g\n" +
                "Protein 6,05 g"));
        porsiyonsList.add(new Porsiyons("Tarhana Çorbası ","1 porsiyon (240 g)","197 kcal","Kal 197\n" +
                "Yağ 3,37 g\n" +
                "Karb 35,45 g\n" +
                "Prot 5,89 g"));



    }
}
