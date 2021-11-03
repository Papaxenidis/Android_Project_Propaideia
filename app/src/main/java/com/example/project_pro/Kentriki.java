package com.example.project_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Kentriki extends AppCompatActivity {


    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kentriki);


        b = findViewById(R.id.button13);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent i = new Intent(Kentriki.this, Eisodos.class);
                startActivity(i);*/

                finish();
                startActivity(getIntent());


            }
        });





    }
}