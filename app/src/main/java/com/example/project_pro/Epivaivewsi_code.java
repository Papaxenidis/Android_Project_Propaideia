package com.example.project_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Epivaivewsi_code extends AppCompatActivity {

    String name1,epitheto2,mail,on_bu,epi_bu,em_bu;

    TextView tname,tlname,temail;

    Button bnai,boxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epivaivewsi_code);


        tname = findViewById(R.id.textView13);
        tlname = findViewById(R.id.textView16);
        temail = findViewById(R.id.textView17);

        bnai = findViewById(R.id.button6);
        boxi = findViewById(R.id.button8);





        bnai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(Epivaivewsi_code.this, Thesi_kodikou.class);
                i.putExtra("name", name1);
                i.putExtra("lname", epitheto2);
                i.putExtra("email",mail);
                startActivity(i);



            }
        });


        boxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Epivaivewsi_code.this, Eggrafi.class);
                startActivity(i);

            }
        });





        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            name1 = extras.getString("name");
            epitheto2 = extras.getString("lname");
            mail = extras.getString("email");

        }

       tname.setText(name1);
       tlname.setText(epitheto2);
       temail.setText(mail);




    }
}