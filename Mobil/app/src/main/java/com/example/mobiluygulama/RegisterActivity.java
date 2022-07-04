package com.example.mobiluygulama;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    //edittext degiskenleri tanımlama..
    private EditText editTextname, editTextemail, editTextpasword;
    private  FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //kullanıcıyı sisteme kaydetmedik için kullandıgımız yapı..
        auth = FirebaseAuth.getInstance();

        //degiskenlerin id lerini tanımladım..
        editTextemail = (EditText) findViewById(R.id.email);
        editTextname = (EditText) findViewById(R.id.name);
        editTextpasword = (EditText) findViewById(R.id.password);

    }
    //islemlerin gercekleseceği yapı..
    public void kayit(View view) {

        //string degerler olusturup bunları
        String email = editTextemail.getText().toString();
        String name = editTextname.getText().toString();
        String password = editTextpasword.getText().toString();

        //girilecek edittextlerin bos olup olmadıgı kontrolleri..
        if(name.isEmpty()){
            editTextname.setError("İsim boş bırakılamaz");
            editTextname.requestFocus();
            return;
        }

        else if(email.isEmpty()){
            editTextemail.setError("Mail boş bırakılamaz");
            editTextemail.requestFocus();
            return;
        }

        else if(password.isEmpty()){
            editTextpasword.setError("Sifre boş bırakılamaz");
            editTextpasword.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Lütfen geçerli bir eposta girin");
            editTextemail.requestFocus();
            return;
        }

        if(password.length()<6){
            editTextpasword.setError("Lütfen 6 karakter içeren sifre giriniz");
        }
        else{
            //yaptıgım islemlerin gerceklesi pgerceklesmediğini anlamak icin yazdıgım islemler..
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful())//eger islemler basarılı isee..
                    {
                        //toast ile mesaj verecek..
                        Toast.makeText(RegisterActivity.this,"Kayıt başarılı",Toast.LENGTH_SHORT ).show();
                        //basarılı olduktan sonra diger sayfaya gecis işlemi olcak..
                        Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(login);
                        finish();
                    }

                    //basarısız ise toast ile sorunun ne oldugu mesajı vercek..
                    else
                        Toast.makeText(RegisterActivity.this, task.getException().getMessage(),Toast.LENGTH_SHORT ).show();
                }
            });
        }


    }
}
