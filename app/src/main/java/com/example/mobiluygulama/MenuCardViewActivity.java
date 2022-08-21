package com.example.mobiluygulama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MenuCardViewActivity extends AppCompatActivity {
     GridLayout menuGrid; //gridlayout için degisken tanımladım..
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_card_view);

        //id sini bulup tanımlanan degiskene atıp degiskeni cagirmis oluyoruz..
        menuGrid=(GridLayout)findViewById(R.id.menuGrid);

        setSingleEvent(menuGrid);

    }

   //olusturdugum card view nesnelerini tıklanır hale getirme işlemi..
    private void setSingleEvent(GridLayout menuGrid) {

        //6 tane cardview olusturdugum için for döngüsüne ihtiyac duydum ..
        // i degiskeni tanımladım olusturdugum menuGrid nesnesinden kuçük olana kadar döbgü devam edecek..
        //i nin ilk degeri 0 olarak tanımladım..
        for(int i=0; i < menuGrid.getChildCount(); i++)
        {
            CardView cardView = (CardView) menuGrid.getChildAt(i); //cardview nesnesini cagirip i degiskenini parametre olarak gönderdim..

            final int finalI = i; //if else icinde kullanacagım degisken oluşturdum..

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) //tıklama islemi için activityler arası gecis islemleri..
                // itent kullaranak yaptım..
                {
                    if(finalI == 0)
                    {
                        Intent itent = new Intent(MenuCardViewActivity.this, IdealBoyKiloActivity.class);
                        startActivity(itent);
                    }
                    else if(finalI == 1)
                    {
                        Intent itent = new Intent(MenuCardViewActivity.this,FoodDrinkActivity.class);
                        startActivity(itent);
                    }
                    else if(finalI == 2)
                    {
                        Intent itent = new Intent(MenuCardViewActivity.this, HakkimizdaActivity.class);
                        startActivity(itent);
                    }
                    else if(finalI == 3)
                    {
                        Intent itent = new Intent(MenuCardViewActivity.this, SuMiktariActivity.class);
                        startActivity(itent);
                    }
                    else if(finalI == 4)
                    {
                        Intent itent = new Intent(MenuCardViewActivity.this, YardimActivity.class);
                        startActivity(itent);
                    }
                   else if(finalI == 5)
                    {
                        System.exit(0); //cikisa tılandıgında exit ile cıkış islemi..
                    }
                    else
                    {
                        //herhangi bir cardview icin activity olmadığı sürece uyarı mesajı verme islemi..
                        Toast.makeText(MenuCardViewActivity.this, "Lütfen card view için bir activity oluşturun.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
