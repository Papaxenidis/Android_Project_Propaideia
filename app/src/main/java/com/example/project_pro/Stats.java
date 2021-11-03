package com.example.project_pro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Stats extends AppCompatActivity {


    TextView sum,poll,sos;
    Button b;

    ImageView imageView;
    DBHelper DB;

    String  []vat = new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);


        sum = findViewById(R.id.tkeno);
        poll = findViewById(R.id.tpoll);
        sos = findViewById(R.id.msosta);
        b = findViewById(R.id.button);

        imageView = findViewById(R.id.imageView35);

        DB = new DBHelper(this);


        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String k = sp.getString("mail","0");


        vat = ypologismos(k);

        sum.setText(vat[0]);
        poll.setText(vat[1]);
        int x = Integer.parseInt(vat[0]);
        int y = Integer.parseInt(vat[1]);
        sos.setText(String.valueOf(x+y));


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Stats.this, reception.class);
                startActivity(i);


            }
        });




        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Stats.this);
                builder.setCancelable(true);
                builder.setTitle("ΣΥΜΒΟΥΛΗ");
                builder.setMessage("Παρακάτω προβάλλονται οι βαθμολογίες σου.");
                builder.show();


            }
        });




    }



    private String[] ypologismos(String em) {

        Cursor res = DB.getdata();
        String n = " ";

        String []p = new String[2];

        while (res.moveToNext())
        {
            n = res.getString(2);
            if(n.equals(em))
            {

               p[0] = res.getString(4);
               p[1] = res.getString(5);


               break;

            }



        }

        return p;


    }
}