package com.example.mobiluygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //degiskeen tanımlamasi..
    TextView tview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //degiskenlere id atamasi...
      Button giris=(Button) findViewById(R.id.login);
      TextView kayit=(TextView) findViewById(R.id.sigin);

        //butona tiklama islemleri..
      giris.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              //ıtent kullanılarak sayfalar arasi gecis..
              Intent intent = new Intent(MainActivity.this,LoginActivity.class);
              startActivity(intent);
          }
      });


        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });



    }
}