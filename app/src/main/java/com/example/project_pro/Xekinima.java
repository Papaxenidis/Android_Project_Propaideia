package com.example.project_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Xekinima extends AppCompatActivity {


    TextView t1,t2,t3,t4;
    Button empros,pisw;
    int x=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xekinima);

        t1 = findViewById(R.id.tx1);
        t2 = findViewById(R.id.tx2);
        t3 = findViewById(R.id.tx3);
        t4 = findViewById(R.id.tx);

        empros = findViewById(R.id.button10);
        pisw = findViewById(R.id.button14);

        empros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(x==0)
                {
                    t1.setVisibility(View.INVISIBLE);
                    t2.setVisibility(View.VISIBLE);
                    x=x+1;
                }else if(x==1)
                {
                    t2.setVisibility(View.INVISIBLE);
                    t3.setVisibility(View.VISIBLE);
                    x=x+1;
                }else if(x==2)
                {
                    t3.setVisibility(View.INVISIBLE);
                    t4.setVisibility(View.VISIBLE);
                    x=x+1;

                }


            }
        });

        pisw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(Xekinima.this, Kentriki.class);
                startActivity(i);

            }
        });



    }
}