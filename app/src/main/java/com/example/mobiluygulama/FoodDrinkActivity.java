package com.example.mobiluygulama;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FoodDrinkActivity extends AppCompatActivity {
    ListView listView; //degişken tanimliyoruz..


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_drink);

        listView = findViewById(R.id.listView); //id bulup listview i cagiriyoruz..

        //BASLIK VE RESMİN İCERİSİNİ DOLDURUYORUZ..
        String sbaslik []= {"Sıcak Başlangıçlar", "Ara Soğuklar", "Çorbalar", "Ana Yemekler", "Tatlılar", "Atıştırmalık", "Vegan Menü", "İçecekler"};
        int images[] = {R.drawable.arasck,R.drawable.arasgk,R.drawable.corba,R.drawable.anaymk,R.drawable.tatli,R.drawable.atistirmalik,R.drawable.vegan,R.drawable.icecek };

        MyAdapter adapter = new  MyAdapter(this,sbaslik, images); // veriler ile liste arasinda baglanti için adapter tanımladım..
        listView.setAdapter(adapter); //listview ile adapter arasında baglanti kurdum..


        //olusturdugum listviewleri aktif hale getirdim..
        //if else ile kontrol sagladım..
        listView.setOnItemClickListener((parent, view, position, id) -> {
            if(position == 0) //0 oldugunde intenet ile diğer activitye gececek..
            {
                Intent intent = new Intent(getApplicationContext(), Sicak_BaslangicActivity.class);

                Bundle bundle = new Bundle(); //bundle nesnesi olusturdum..
                bundle.putInt("image", images[0]); //putınt ile ilk resmi image icine attım...
                intent.putExtras(bundle);
                intent.putExtra("baslik", sbaslik[0]); //putextra ile string tipindeki baslıka attım ilk sıradakini
                intent.putExtra("position",""+0); //ve position nunu de belirledim..
                startActivity(intent); //activity başlatma..

            }
            else if(position == 1){
                Intent intent = new Intent(getApplicationContext(), Ara_SoguklarActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("image", images[1]);
                intent.putExtras(bundle);
                intent.putExtra("baslik", sbaslik[1]);
                intent.putExtra("position",""+1);
                startActivity(intent);

            }
            else if(position == 2){
                Intent intent = new Intent(getApplicationContext(), CorbalarActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("image", images[2]);
                intent.putExtras(bundle);
                intent.putExtra("baslik", sbaslik[2]);
                intent.putExtra("position",""+2);
                startActivity(intent);

            }
            else if(position == 3){
                Intent intent = new Intent(getApplicationContext(), Ana_YemeklerActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("image", images[3]);
                intent.putExtras(bundle);
                intent.putExtra("baslik", sbaslik[3]);
                intent.putExtra("position",""+3);
                startActivity(intent);

            }
            else if(position == 4){
                Intent intent = new Intent(getApplicationContext(), TatlilarActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("image", images[4]);
                intent.putExtras(bundle);
                intent.putExtra("baslik", sbaslik[4]);
                intent.putExtra("position",""+4);
                startActivity(intent);

            }
           else if(position == 5){
                Intent intent = new Intent(getApplicationContext(), AtistirmaliklarActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("image", images[5]);
                intent.putExtras(bundle);
                intent.putExtra("baslik", sbaslik[5]);
                intent.putExtra("position",""+5);
                startActivity(intent);

            }
            else if(position == 6){
                Intent intent = new Intent(getApplicationContext(), Vegan_MenuActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("image", images[6]);
                intent.putExtras(bundle);
                intent.putExtra("baslik", sbaslik[6]);
                intent.putExtra("position",""+6);
                startActivity(intent);

            }
            else if(position == 7){
                Intent intent = new Intent(getApplicationContext(), IceceklerActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("image", images[7]);
                intent.putExtras(bundle);
                intent.putExtra("baslik", sbaslik[7]);
                intent.putExtra("position",""+7);
                startActivity(intent);

            }


        });
    }

    class MyAdapter extends ArrayAdapter<String>{
        //adapterin tutmasini istediğim parametreler..
        Context context;
        String mBaslik[];
        int rImages[];

        //constructor oluşturdum..
        MyAdapter(Context c, String baslik[], int imgs[])
        {
            super(c,R.layout.dizi,R.id.tdeneme, baslik);
            this.context=c;
            this.mBaslik = baslik;
            this.rImages = imgs;
        }

        @NonNull
        @Override
        //layout u adapter ile birbirine bagladım..
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View dizi = layoutInflater.inflate(R.layout.dizi,parent,false); //oluşturdugum dizi layoutu view da nesne olarak tanımladım..
            ImageView images = dizi.findViewById(R.id.image);
            TextView tdene = dizi.findViewById(R.id.tdeneme); // textview nesnesi oluşturdum..

            images.setImageResource(rImages[position]);

            tdene.setText(mBaslik[position]);// tdene nesnesinin positionunu alıp settext ile listview daki bmbaslık nesnesine atiyorum..

            return dizi;
        }
    }
}
