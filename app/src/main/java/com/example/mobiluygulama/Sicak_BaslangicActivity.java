package com.example.mobiluygulama;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Sicak_BaslangicActivity extends AppCompatActivity {

    //degiskenler ..
    RecyclerView recyclerView;
    List<Porsiyons> porsiyonsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sicak_baslangic);

        recyclerView = findViewById(R.id.recyclerView);

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
        porsiyonsList.add(new Porsiyons("Kaşarlı Patates Kroket","1 porsiyon (110 g)","230.75 kcal ","Yağ 12 g\n" +
                "Karb 25 g\n" +
                "Prot 3 g\n" +
                "100 g içinde 220 kadar kalori mevcut"));
        porsiyonsList.add(new Porsiyons("Sigara Böreği","1 porsiyon (75 g)","293 kcal","Porsiyon başı\n"+
                "Enerji 1226 kj 293 kcal\n" +
                "Yağ 22,74g\n" +
                "Doymuş Yağ 8,394g\n" +
                "Tekli Doymamış Yağ 6,264g\n" +
                "Çoklu Doymamış Yağ 6,926g\n" +
                "Karbonhidratlar 15,02g\n" +
                "Şeker 1,74g \n" +
                "Fiber 0,6g\n" +
                "Protein 7,45g\n" +
                "Sodyum 479mg\n" +
                "Kolesterol 37mg\n" +
                "Potasyum 73mg"));
        porsiyonsList.add(new Porsiyons("Kol Böreği ","1 porsiyon (120 g)","295 kcal","Porsiyon başı\n" +
                "Enerji 1234 kj 295 kcal\n" +
                "Yağ 6,93g\n" +
                "Doymuş Yağ 3,415g\n" +
                "Tekli Doymamış Yağ 2,155g\n" +
                "Çoklu Doymamış Yağ 0,65g\n" +
                "Karbonhidratlar 47,85g\n" +
                "Şeker 0,23g\n" +
                "Fiber 1,8g\n" +
                "Protein 9,01g\n" +
                "Sodyum 190mg\n" +
                "Kolesterol 34mg\n" +
                "Potasyum 120mg"));
        porsiyonsList.add(new Porsiyons("Kadın Budu Köfte","1 porsiyon (112 g)","224 kcal","Porsiyon başı\n" +
                "Enerji 938 kj 224 kcal\n" +
                "Yağ 10,66g\n" +
                "Doymuş Yağ 3,914g\n" +
                "Trans Yağ 0,525g\n" +
                "Tekli Doymamış Yağ 4,405g\n" +
                "Çoklu Doymamış Yağ 0,811g\n" +
                "Karbonhidratlar 14g\n" +
                "Şeker 1,76g\n" +
                "Fiber 1,1g\n" +
                "Protein 16,96g\n" +
                "Sodyum 573mg\n" +
                "Kolesterol 97mg\n" +
                "Potasyum 292mg"));

    }
}
