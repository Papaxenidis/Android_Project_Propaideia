package com.example.project_pro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class propedies_ extends AppCompatActivity {

    String timi;
    TextView pro1,pro2,pro3,pro4,pro5,pro6,pro7,pro8,pro9,pro10,epikef;
    Button pisw;

    ImageView help;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propedies_);


        epikef = findViewById(R.id.textView30);

        pisw = findViewById(R.id.button);

        help = findViewById(R.id.voi);


        pro1 = findViewById(R.id.p1);
        pro2 = findViewById(R.id.p2);
        pro3 = findViewById(R.id.p3);
        pro4 = findViewById(R.id.p4);
        pro5 = findViewById(R.id.p5);
        pro6 = findViewById(R.id.p6);
        pro7 = findViewById(R.id.p7);
        pro8 = findViewById(R.id.p8);
        pro9 = findViewById(R.id.p9);
        pro10 = findViewById(R.id.p10);




        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(propedies_.this);
                builder.setCancelable(true);
                builder.setTitle("ΣΥΜΒΟΥΛΗ");
                builder.setMessage("Πάρε όσο χρόνο θέλεις για να μελετήσεις τις προπαίδειες.Όταν τελειώσεις πάτα το πλήκτρο με το βέλος");
                builder.show();



            }
        });

        pisw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(propedies_.this, prop.class);
                startActivity(i);



            }
        });




        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            timi = extras.getString("arithmos");
        }
        epikef.setText("ΠΡΟΠΑΙΔΕΙΑ ΤΟΥ "+timi);


        int ar = Integer.parseInt(timi);


        pro1.setText(timi + " x 1 = " + timi);
        pro2.setText(timi + " x 2 = " + String.valueOf(ar * 2));
        pro3.setText(timi + " x 3 = " + String.valueOf(ar * 3));
        pro4.setText(timi + " x 4 = " + String.valueOf(ar * 4));
        pro5.setText(timi + " x 5 = " + String.valueOf(ar * 5));
        pro6.setText(timi + " x 6 = " + String.valueOf(ar * 6));
        pro7.setText(timi + " x 7 = " + String.valueOf(ar * 7));
        pro8.setText(timi + " x 8 = "+ String.valueOf(ar * 8));
        pro9.setText(timi + " x 9 = "+ String.valueOf(ar * 9));
        pro10.setText(timi + " x 10 = "+ String.valueOf(ar * 10));









    }




}