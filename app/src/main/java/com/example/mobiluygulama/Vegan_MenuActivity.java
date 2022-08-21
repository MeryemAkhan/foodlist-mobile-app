package com.example.mobiluygulama;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Vegan_MenuActivity extends AppCompatActivity {

    //degiskenler ..
    RecyclerView recyclerView;
    List<Porsiyons> porsiyonsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegan_menu);

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
        porsiyonsList.add(new Porsiyons("Domates Dolması","1 porsiyon (149 gr)","143 kcal ","Yağ 6,23 g\n" +
                "Karb 14,77 g\n" +
                "Prot 7,08 g"));
        porsiyonsList.add(new Porsiyons("Sebze Güveç (Etsiz)","1 porsiyon (239 g)","134 kcal","Sebze Çorbası (Konservelenmiş, Konsatre)\n Yağ 2,32 g\n" +
                "Karb 23,25 g\n" +
                "Prot 6,33 g"));
        porsiyonsList.add(new Porsiyons("Sebze Çorbası ","1 kase","145 kcal","Yağ 3,89 g\n" +
                "Karb 24,06 g\n" +
                "Prot 4,23 g"));

    }
}
