package com.example.project_pro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class reception extends AppCompatActivity {


    ImageView exodos,proped,vath,paixnidi,help;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception);


        help = findViewById(R.id.voi);
        exodos = findViewById(R.id.imageView21);
        paixnidi = findViewById(R.id.imageView19);
        proped = findViewById(R.id.imageView23);
        vath = findViewById(R.id.imageView24);

       // SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);



        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(reception.this);
                builder.setCancelable(true);
                builder.setTitle("ΣΥΜΒΟΥΛΗ");
                builder.setMessage("Επίλεξε την εικόνα του τηλεχειριστήριου(1η) για να ξεκινήσεις το παιχνίδι\nΕπίλεξε την εικόνα με το βάθρο(2) για να δεις την βαθμολογία σου\nΕπίλεξε την εικόνα με το βιβλίο(3) για να μελετήσεις την προπαίδεια\nΕπίλεξε την εικόνα με το βέλος(4) για να εποσυνδεθείς.");
                builder.show();



            }
        });

        vath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(reception.this, Stats.class);
                startActivity(i);

            }
        });


        exodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(reception.this, MainActivity.class);
                startActivity(i);

                //String k = sp.getString("mail","0");



            }
        });


        proped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(reception.this, prop.class);
                startActivity(i);
            }
        });



        paixnidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(reception.this, Askiseis_1o.class);
                startActivity(i);


            }
        });



    }
}