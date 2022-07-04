package com.example.mobiluygulama;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class YardimActivity  extends AppCompatActivity {

    //degiskenler ..
    RecyclerView recyclerView;
    List<Porsiyons> porsiyonsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yardim);

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
        porsiyonsList.add(new Porsiyons("İdeal Kilo Nasıl Hesaplanır?","",""," Kadın ve erkekler için ayrı ayrı olmak üzere aşağıdaki formüllerle hesaplanmaktadır.\n" +
                "\n" +
                "Kadınlarda: 45,5 + 2,3 X (İnç cinsinden boy - 60)\n" +
                "\n" +
                "Erkeklerde: 50 + 2,3 X (İnç cinsinden boy - 60) "));
        porsiyonsList.add(new Porsiyons("Neden Detox Yapmalıyım?","","","Şehir hayatı ile her geçen gün daha fazla işlenmiş gıdalara, hava ve su kirliliğine maruz kalıyoruz. Bu yabancı maddeler vücudu oldukça zorladığı gibi detoks işlemlerinin yetersiz kalmasına da sebep olur. Juice ve Reset programlarımız sindirim sisteminizi bir süre rahatlatarak, vücudunuzda biriken toksinlerden arınmanıza yardımcı olur. "));
        porsiyonsList.add(new Porsiyons("Günde 5 Öğün Yyiyerek Kilo Verebiliri Miyim?","","","Düzenli yemek yemek kan şekerinizi dengeleyerek yağ depolanmasını engeller. Metabolizmanız bir yangın gibidir. Eğer arada bir ateşlemezseniz ilerlemez. "));
        porsiyonsList.add(new Porsiyons("Yemekler Tekrar Isıtıldığında Besin Değeri Kaybolur Mu?","","","Elbette ve menülerimizi dizayn ederken bu durumu göz önüne alıyoruz. Tekrar ısıtılması gereken yemeklerin ısıtma sürelerini en azda tutuyoruz. "));
        porsiyonsList.add(new Porsiyons("Yiyecek Kısmında Belirtilen Kalori Paketlerinde Eksik Öğün Alsdığımda Kalori Miktarı Değişir Mi?","","","Belirlenen kalori miktarları tam günlük (5 öğün) beslenme planları için geçerlidir. Öğünlerin gün içindeki yaklaşık oranları şu şekildedir: Kahvaltı %20, 1. Ara %10, Öğlen %30, 2. Ara %10 ve Akşam %30. Öğün tercihlerine göre kalori miktarı değişecektir. "));
        porsiyonsList.add(new Porsiyons("Besleyici değerleri bakımından vücudum için en yararlı 5 sebze hangisi?","","","Ispanak, iyi bir folik asit kaynağı, kansere karşı koruyucu etkisi var, A vitamini ve kalsiyum içeriyor; havuç, mükemmel bir A vitamini kaynağı; tatlı patates, A ve C vitaminleri içeriyor; brokoli, A ve C vitaminleri ile folik asit içeriyor; sarımsak, kansere karşı etkili pitokimyasallar içeriyor. "));
        porsiyonsList.add(new Porsiyons("Kahvede bulunan kafein kemiklerimi zayıflatır mı?","","","Diyetisyenlerin verdikleri bilgiye göre, hayır. Çok aşırı miktarda kahve içmiyorsanız böyle bir durum söz konusu değil."));


    }

}
