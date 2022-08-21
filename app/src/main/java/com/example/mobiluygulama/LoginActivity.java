package com.example.mobiluygulama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextname, editTextemail, editTextpasword;
    private FirebaseAuth auth;
    private FirebaseUser mUser; // ilgili kayıt olan kullanıcının bilgisini almak için firebaseuser kullandım..
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        auth = FirebaseAuth.getInstance();

        editTextemail = (EditText) findViewById(R.id.email);
        editTextname = (EditText) findViewById(R.id.name);
        editTextpasword = (EditText) findViewById(R.id.pswd);

    }

    public void giris(View view) {
        String email = editTextemail.getText().toString();
        String password = editTextpasword.getText().toString();

        //kullanıcı girisi için bazı kontroller..
        if(email.isEmpty()){
            editTextemail.setError("Mail boş bırakılamaz");
            editTextemail.requestFocus();
            return;
        }

        else if(password.isEmpty()){
            editTextpasword.setError("Sifre boş bırakılamaz");
            editTextpasword.requestFocus();
            return;
        }
        else{
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult)  //basarı ile tamamlandıysa..
                {
                    mUser = auth.getCurrentUser(); //kayit olan kullanıcıların bilgisini alıyoruz..
                    System.out.println("Kullanıcı Adı: " + mUser.getDisplayName());  //kullanıcının adını göster..
                    System.out.println("Kullanıcı Email: " + mUser.getEmail());  //kullanıcının e mailini göster..
                    System.out.println("Kullanıcı Uid: " + mUser.getUid());  //kullanıcının Uid göster..

                    //giris islenlerini tamamladıktan sonra menü ya gecis yapacak..
                    //sayfalar arası gecis icin intent kullandım..
                    Intent login = new Intent(LoginActivity.this, MenuCardViewActivity.class);
                    startActivity(login);
                    finish();

                }
            }).addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show(); //excaptionumuzu mesaj olarak yazdırma..

                }
            });
        }


    }
}
