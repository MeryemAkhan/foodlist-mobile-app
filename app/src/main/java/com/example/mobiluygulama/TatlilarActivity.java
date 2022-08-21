package com.example.mobiluygulama;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TatlilarActivity extends AppCompatActivity {

    //degiskenler ..
    RecyclerView recyclerView;
    List<Porsiyons> porsiyonsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tatlilar);

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
        porsiyonsList.add(new Porsiyons("Künefe","1 porsiyon (120 gr)","426 kcal ","Yağ 20,52 g\n" +
                "Karb 54,9 g\n" +
                "Prot 7,36 g"));
        porsiyonsList.add(new Porsiyons("Baklava ","1 porsiyon (78 g)","334 kcal","Yağ 22,64 g\n" +
                "Karb 29,34 g\n" +
                "Prot 5,23 g"));
        porsiyonsList.add(new Porsiyons("Tulumba Tatlısı","1 porsiyon (90 g)","256 kcal","Yağ 7,26 g\n" +
                "Karb 40,69 g\n" +
                "Prot 2,51 g"));


    }
}
