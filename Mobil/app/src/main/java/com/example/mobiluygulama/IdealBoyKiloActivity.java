package com.example.mobiluygulama;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class IdealBoyKiloActivity  extends AppCompatActivity {

    //degiskeen tanımlamasi..
    private EditText eText, eText1, eText2;
    private TextView tView, tView1, tView2, tView3;
    private RadioGroup radioGroup;
    private Button btnSonuc, btnReset;
    private RadioButton radioBtn1, radioBtn2;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ideal_boy_kilo);

        //degiskenlere id atamasi...
        eText= (EditText) findViewById(R.id.boy);
        eText1= (EditText) findViewById(R.id.kilo);
        eText2= (EditText) findViewById(R.id.yas);

        tView = (TextView) findViewById(R.id.ideal);
        tView1 = (TextView) findViewById(R.id.durum);
        tView2 = (TextView) findViewById(R.id.idea);
        tView3 = (TextView) findViewById(R.id.cal);

        radioGroup = (RadioGroup) findViewById(R.id.radio);
        radioBtn1 = (RadioButton) findViewById(R.id.bay);
        radioBtn2 = (RadioButton) findViewById(R.id.bayan);

        btnSonuc = (Button) findViewById(R.id.sonuc);
        btnReset = (Button) findViewById(R.id.butonsfr);

        //butona tiklama islemleri..
        btnSonuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strboy = eText.getText().toString();
                String strkilo = eText1.getText().toString();
                String stryas = eText2.getText().toString();

                //if kontrolleri..
                //veriler bos bırakıldıgında uyarı mesajı verecek toast ile..
                if(strboy.equals("")){
                    Toast.makeText(IdealBoyKiloActivity.this, "Lütfen boyunuzu giriniz.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(strkilo.equals("")){
                    Toast.makeText(IdealBoyKiloActivity.this, "Lütfen kilonuzu giriniz.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(stryas.equals("")){
                    Toast.makeText(IdealBoyKiloActivity.this, "Lütfen yaşınızı giriniz.", Toast.LENGTH_SHORT).show();
                    return;
                }
                float by = Float.parseFloat(strboy)/100;
                float kl = Float.parseFloat(strkilo);
                float ys = Float.parseFloat(stryas);
                float boy = Float.parseFloat(strboy);

                int idealKiloBay = (int) (50+2.3*(by*100*0.4-60)); //ideal kilonun bay için formulunu tanımladım int olarak..
                int idealKiloBayan = (int) (45.5+2.3*(by*100*0.4-60));  //ideal kilonun bayan için formulunu tanımladım int olarak..

                int kaloriBay = (int) (66+13.7*kl+5*boy-6.8*ys);  //kalorinin bay için formulunu tanımladım int olarak..
                int kaloriBayan = (int) (655+9.6*kl+1.8*boy-4.7*ys);  //kalorinin bayan için formulunu tanımladım int olarak..
                int checkId = radioGroup.getCheckedRadioButtonId();  //radio buton icin cehckıd tanımlaması..

                if(checkId == R.id.bay)  //chechıd eger bay ise ideal kilo ve kalori hesabı..
                {
                    tView2.setText(String.valueOf(idealKiloBay));
                    tView3.setText(String.valueOf(kaloriBay));

                }
                else if(checkId == R.id.bayan)  //chechıd eger bayan ise ideal kilo ve kalori hesabı..
                {
                    tView2.setText(String.valueOf(idealKiloBayan));
                    tView3.setText(String.valueOf(kaloriBayan));
                }

                //ideal kilo normal kılodan fazla ise alert mesajı vercek..
                /*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("İdeal Kilo");
                if(idealKiloBay>kl){
                    alertDialogBuilder.setMessage("Fazla Kilolusunuz");
                }
                else if(idealKiloBayan>kl){
                    alertDialogBuilder.setMessage("Fazla Kilolusunuz").show();
                }
                AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();*/

                float deg = BedenKitleIndeksi(by, kl); //beden kitle indeksi fonksiyonuna edittext ile aldıgım degerleri parametre olarak gonderdim..
                tView1.setText(Indeks(deg)); //textview icine hesaplanan degeri yazdım..
                tView.setText("= " +deg);
            }
        });
        //sısıflama butonu icin islemler..
        //settext ile içlerini boşalttım degiskenlerin..
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText.setText("");
                eText1.setText("");
                eText2.setText("");
                tView.setText("");
                tView1.setText("");
                tView2.setText("");
                tView3.setText("");
            }
        });

    }

    public float BedenKitleIndeksi(float boy, float kilo){
        return kilo /(boy*boy); // kilonun boyun karesine oranını aldıgı parametreler ile return edip hesaplama..
    }
    public String Indeks(float deger)
    {

        // hesaplanan degeri if else ile kontrol edip durumunu belirleme...
        if( deger>0 && deger<16){
            return "= Çok Zayıf";
        }
        else if(deger<18.5){
            return "= Zayıf";
        }
        else if(deger<25){
            return "=Normal";
        }
        else if(deger<30){
            return "= Fazla Kilolu";

        }
        else {
            return "= Obez";
        }

    }
}


