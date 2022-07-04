package com.example.mobiluygulama;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SuMiktariActivity extends AppCompatActivity {
    //private degiskenler tanımlandı..
    private EditText editText;
    private TextView textView, textView1, textView2, textView3;
    private Button btnHesapla, btnSifirla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.su_miktari);

        //id leri bulup tanımlanan degiskenlere atıp degiskenleri cagirmis oluyoruz..
        editText = (EditText) findViewById(R.id.kilo1);

        textView = (TextView) findViewById(R.id.sumiktar);
        textView1 = (TextView) findViewById(R.id.bardak);
        textView2 = (TextView) findViewById(R.id.brdk);
        textView3 = (TextView) findViewById(R.id.litre);

        btnHesapla = (Button) findViewById(R.id.hesap);
        btnSifirla = (Button) findViewById(R.id.btnsifirla);

        //Butona tiklama islemi
        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strkilo = editText.getText().toString(); //int olan degeri stringe ceviriyoruz ve degiskene atama..

                //uyarı mesajı..
                if(strkilo.equals("")){
                    Toast.makeText(SuMiktariActivity.this, "Lütfen kilonuzu giriniz.", Toast.LENGTH_SHORT).show();
                    return;
                }

           //hesaplama isleminde kullanacagim degiskenler tanimlanip gerekli islemler yatim..
                float kilo = Float.parseFloat(strkilo);
                 float deger = (float) ((kilo*3)/100); //günlük icilecek su miktarı litre cinsinden hesaplama..
                 textView.setText(String.valueOf(deger));
                 textView3.setText("L");
                 int bardak = (int)(deger*4);  //Günde alması gereken litreye göre kac bardak su icmesi hesaplaması..
                 textView1.setText(String.valueOf(bardak));
                textView2.setText("Bardak su içmelisiniz");
            }
        });

      //girilen degerleri ve hesaplanan degerleri sıfırlama islemi..
        btnSifirla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) //butonu aktif etme..
            {
                editText.setText("");
                textView.setText("");
                textView1.setText("");
                textView2.setText("");
                textView3.setText("");
            }
        });

    }
}
