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
import android.widget.Toast;

public class Apotelesmata extends AppCompatActivity {


    ImageView niki, itta, help;
    TextView textn, texti;
    Button spiti;

    int apantisi = 0;
    SQLiteDatabase db;
    DBHelper DB;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apotelesmata);

        niki = findViewById(R.id.xaroumenos);
        itta = findViewById(R.id.meskylo);
        help = findViewById(R.id.voi);

        textn = findViewById(R.id.text_win);
        texti = findViewById(R.id.text_itta);

        spiti = findViewById(R.id.home);

        DB = new DBHelper(this);


        Intent intent = getIntent();
        score = intent.getIntExtra("intVariableName", 0);

        check();

        paixe(score);


        spiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Apotelesmata.this, reception.class);
                startActivity(i);


            }
        });


        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Apotelesmata.this);
                builder.setCancelable(true);
                builder.setTitle("ΣΥΜΒΟΥΛΗ");
                builder.setMessage("Πάτα το πλήκτρο με το σπιτάκι ώστε να πάς στην αρχική σελίδα.");
                builder.show();


            }
        });


    }

    private void check() {


        Cursor res1 = DB.getdata();
        SharedPreferences sp1 = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String m = sp1.getString("mail", "0");


        while (res1.moveToNext()) {

            String x = res1.getString(2);

            if (m.equals(x)) {

                String g = res1.getString(6);
                if (g.equals("10")) {
                    apantisi = 1;
                    break;

                }


            }
        }


    }


    public void paixe(int score) {

        if (apantisi != 1) {


            if (score >= 130) {

                Cursor res = DB.getdata();
                SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                String k = sp.getString("mail", "0");


                while (res.moveToNext()) {

                    String x = res.getString(2);

                    if (k.equals(x)) {

                        String temp = res.getString(6);
                        int tempint = Integer.parseInt(temp);
                        tempint += 1;
                        temp = String.valueOf(tempint);
                        Boolean checkupdatedata = DB.ananewsilvl(temp, k);


                        break;


                    }


                }

                textn.setVisibility(View.VISIBLE);
                niki.setVisibility(View.VISIBLE);
                texti.setVisibility(View.INVISIBLE);
                itta.setVisibility(View.INVISIBLE);


            } else {

                textn.setVisibility(View.INVISIBLE);
                niki.setVisibility(View.INVISIBLE);
                texti.setVisibility(View.VISIBLE);
                itta.setVisibility(View.VISIBLE);


            }


        }else
        {

            Intent i = new Intent(Apotelesmata.this, reception.class);
            startActivity(i);


        }


    }


}