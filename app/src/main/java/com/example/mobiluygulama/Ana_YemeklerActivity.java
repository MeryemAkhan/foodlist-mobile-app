package com.example.mobiluygulama;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Ana_YemeklerActivity extends AppCompatActivity {

    //degiskenler ..
    RecyclerView recyclerView;
    List<Porsiyons> porsiyonsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ana_yemekler);

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
        porsiyonsList.add(new Porsiyons("Dana Etinden Köfte","1 porsiyon (108 gr)","220 kcal ","Yağ 13,08 g\n" +
                "Karb 7,04 g\n" +
                "Prot 17,45 g"));
        porsiyonsList.add(new Porsiyons("Belen Tava ","1 porsiyon (100 g)","208 kcal","Yağ %62\n" +
                "Karbonhidrat %15\n" +
                "Protein %23"));
        porsiyonsList.add(new Porsiyons("Tepsi Kebabı","1 porsiyon (245 g)","393 kcal","Kal 393\n" +
                "Yağ 23,7 g\n" +
                "Karb 17,11 g\n" +
                "Prot 27,22 g"));
        porsiyonsList.add(new Porsiyons("Sebzeli Tavuk Yemeği","1 porsiyon (200 g)","246 kcal","Yağ 14,42 g\n" +
                "Karb 9,67 g\n" +
                "Prot 19,71 g"));
        porsiyonsList.add(new Porsiyons("Patlıcan Kebabı","1 porsiyon (245 g)","276 kcal","Yağ 18,07 g\n" +
                "Karb 12,69 g\n" +
                "Prot 17,29 g"));

    }
}
