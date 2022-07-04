package com.example.mobiluygulama;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class IceceklerActivity extends AppCompatActivity {
    //degiskenler ..
    RecyclerView recyclerView;
    List<Porsiyons> porsiyonsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icecekler);

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
        porsiyonsList.add(new Porsiyons("Su","1 bardak","240 ml ","Yağ 0 g\n" +
                "Karb 0 g\n" +
                "Prot 0 g\n" + "Sağlıklı bir insan 1,5 litresi idrar yoluyla 1 litreye yakını ise nefes, terleme ve eklem hareketleri ile olmak üzere toplam 2,5 litreye yakın sıvı kaybeder. Kaybedilen sıvının %20’ye yakın kısmı gün boyunca yediklerimizden karşılanır. Karpuz, domates gibi bazı sebze ve meyvelerin su içerikleri %90’a yakındır. Yiyeceklerden sonra kalan 2 litre için de su içtiğimizde kaybettiğimiz sıvıyı yerine koymuş oluruz"));
        porsiyonsList.add(new Porsiyons("Çay (Demlenmiş)","1 bardak","240 ml","Kal 2\n" +
                "Yağ 0 g\n" +
                "Karb 0,71 g\n" +
                "Prot 0 g"));
        porsiyonsList.add(new Porsiyons("Taze Sıkılmış Portakal Suyu","1 porsiyon (186 g)","84 kcal","Yağ 0,37 g\n" +
                "Karb 19,34 g\n" +
                "Prot 1,3 g"));

    }
}
