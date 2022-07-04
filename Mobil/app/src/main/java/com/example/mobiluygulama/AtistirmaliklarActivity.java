package com.example.mobiluygulama;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AtistirmaliklarActivity extends AppCompatActivity {
    //degiskenler ..
    RecyclerView recyclerView;
    List<Porsiyons> porsiyonsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atistirmaliklar);

        recyclerView = findViewById(R.id.recyclerView1);

        //kullanacagım fonksiyonları onCreate icinde cagırdım..
        initData();
        setRecycleView();
    }

    private void setRecycleView() {
        //olusturdugum adapteri activityde kullanmak için nesne olusturdum..
        PorsiyonsAdapter porsiyonsAdapter = new PorsiyonsAdapter(porsiyonsList);
        recyclerView.setAdapter(porsiyonsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        //adapterde olusturdugum nesnelerin icerisini doldurdum..
        porsiyonsList = new ArrayList<>(); //liste yapısını kullanmak için nesne ..
        porsiyonsList.add(new Porsiyons("Cevizli Sucuk","1 porsiyon (50 gr)","390 kcal ","Yağ 14,88 g\n" +
                "Karb 62,34 g\n" +
                "Prot 5,52 g"));
        porsiyonsList.add(new Porsiyons("Mücver","1 porsiyon (150 g)","172 kcal","Yağ 7,64 g\n" +
                "Karb 20,08 g\n" +
                "Prot 6,51 g"));
        porsiyonsList.add(new Porsiyons("Kumpir","1 porsiyon (350 g)","685 kcal","Yağ 41,91 g\n" +
                "Karb 49,97 g\n" +
                "Prot 29,7 g"));

    }

}
