package com.example.mobiluygulama;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Ara_SoguklarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Porsiyons> porsiyonsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ara_soguklar);

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
        porsiyonsList.add(new Porsiyons("Yoğurtlu Biber Mezesi","1 porsiyon (145 gr)","96 kcal ","Karbonhidrat (g) 7.99\n" +
                "Protein (g) 4.66\n" +
                "Yağ (g) 4.68\n" +
                "Lif (g) 0.68\n" +
                "Kolesterol (mg) 16.95\n" +
                "Sodyum (mg) 62.78\n" +
                "Potasyum (mg) 273.7\n" +
                "Kalsiyum (mg) 161.78\n" +
                "Vitamin A (iu) 88.21\n" +
                "Vitamin C (mg) 19.23\n" +
                "Demir (mg) 0.25"));
        porsiyonsList.add(new Porsiyons("Közlenmiş Patlıcan","1 porsiyon (180 g)","45 kcal","Porsiyon başı\n" +
                "Enerji 187 kj 45 kcal\n" +
                "Yağ 0,39g\n" +
                "Doymuş Yağ 0,071g\n" +
                "Tekli Doymamış Yağ 0,038g\n" +
                "Çoklu Doymamış Yağ 0,165g\n" +
                "Karbonhidratlar 10,59g\n" +
                "Şeker 4,24g\n" +
                "Fiber 6,3g\n" +
                "Protein 1,9g\n" +
                "Sodyum 4mg\n" +
                "Kolesterol 0mg\n" +
                "Potasyum 426mg"));
        porsiyonsList.add(new Porsiyons("Yoğurtlu Havuç Salatası ","1 porsiyon (30 g)","31 kcal","Porsiyon başı\n" +
                "Enerji 129 kj 31 kcal\n" +
                "Yağ 1,8g\n" +
                "Doymuş Yağ 0,291g\n" +
                "Trans Yağ 0g\n" +
                "Tekli Doymamış Yağ 1,242g\n" +
                "Çoklu Doymamış Yağ 0,205g\n" +
                "Karbonhidratlar 3,53g\n" +
                "Şeker 2,16g\n" +
                "Fiber 0,7g\n" +
                "Protein 0,5g\n" +
                "Sodyum 82mg\n" +
                "Kolesterol 0mg\n" +
                "Potasyum 82mg"));
        porsiyonsList.add(new Porsiyons("Kuru Domatesli Peynir Topları ","1 porsiyon (112 g)","81 kcal","1 porsiyon 81 kalori"));


    }
}
