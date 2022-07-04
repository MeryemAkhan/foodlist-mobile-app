package com.example.mobiluygulama;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//bazı activitylerde kullanacagım adapter kodları..

//
public class PorsiyonsAdapter extends RecyclerView.Adapter<PorsiyonsAdapter.PorsiyonVH> {

    //liste yapısı olması icin porsiyonlist adında yapı olusturdum..
    List<Porsiyons> porsiyonsList;

    public PorsiyonsAdapter(List<Porsiyons> porsiyonsList) {
        this.porsiyonsList = porsiyonsList;
    }

    @NonNull
    @Override
    public PorsiyonVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Layoutinflater: row xml objesini Java sınıflarına çevirmek için kullandım..
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false); //viewHolderin başlatılması için metod..
       return new PorsiyonVH(view);
    }

    //ListView’i implement ederken daha performanslı çalışması için ViewHolder kullandım..
    @Override
    public void onBindViewHolder(@NonNull PorsiyonVH holder, int position) {

        //liste yapısında olmasını istedigim degerleri göstermek icin holder ile alıp get metodunu yazdım..
        Porsiyons porsiyons = porsiyonsList.get(position);
        holder.codenameText.setText(porsiyons.getCodename());
        holder.porsionText.setText(porsiyons.getPorsiyon());
        holder.kaloriText.setText(porsiyons.getKalori());
        holder.aciklamaText.setText(porsiyons.getAciklama());

        boolean isExpandable = porsiyonsList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return porsiyonsList.size();
    }

    public class PorsiyonVH extends RecyclerView.ViewHolder {

        //xml icinde olan degiskenlerimi burada kullanmak icicn olusturdum..

        TextView codenameText, porsionText, kaloriText, aciklamaText;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public PorsiyonVH(@NonNull View itemView) {
            super(itemView);

            //degiskenlere id leri attım..
            codenameText = itemView.findViewById(R.id.code_name);
            porsionText = itemView.findViewById(R.id.porsiyon);
            kaloriText = itemView.findViewById(R.id.kalori);
            aciklamaText = itemView.findViewById(R.id.aciklama);


            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable);

            //xml kısmında olusturdugum layouta tıklama islemi..
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Porsiyons porsiyons = porsiyonsList.get(getAdapterPosition()); //olustudugum porsiyons classında nesne olusturup prrsiyonlist icindeki adapterin icerisine attım..
                    porsiyons.setExpandable(!porsiyons.isExpandable());
                    notifyItemChanged(getAdapterPosition());


                }
            });


        }
    }
}
