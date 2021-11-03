package com.example.project_pro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Askiseis_2o extends AppCompatActivity {

    TextView tel1,tel2,ap1,ap2,ap3;

    Button okey,begin;

    ImageView help;

    DBHelper DB;
    String epipedo;

    int sum,ran_1,ran_2,ran_3,user_input,score,temp,score1,score2 = 0,sc_thet,sc_ar;//score 1 και 2 να πεταστούν στην βάση στο τέλος




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_askiseis_2o);

        DB = new DBHelper(this);


        help = findViewById(R.id.voi);

        tel1 = findViewById(R.id.telestis1);
        tel2 = findViewById(R.id.telestis2);

        ap1 = findViewById(R.id.apot1);
        ap2 = findViewById(R.id.apot2);
        ap3 = findViewById(R.id.apot3);

        okey = findViewById(R.id.ok);

        begin = findViewById(R.id.renew);

        Intent intent = getIntent();
        score = intent.getIntExtra("score_dek", 0);


        score1 = score;

        SharedPreferences sp1 = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String m = sp1.getString("mail", "0");

        Cursor res1 = DB.getdata();
        while(res1.moveToNext())
        {

            String temp = res1.getString(2);

            if(temp.equals(m))
            {
                epipedo = res1.getString(6);
                break;



            }




        }

        tel1.setText(epipedo);












        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Askiseis_2o.this);
                builder.setCancelable(true);
                builder.setTitle("ΣΥΜΒΟΥΛΗ");
                builder.setMessage("Επίλεξε το σωστό αποτέλεσμα από τους 3 αριθμούς που παρέχονται");
                builder.show();




            }
        });


        okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sum < 10) {

                    if (user_input == 0) {


                        Toast.makeText(Askiseis_2o.this, "Πρέπει να επιλέξεις απάντηση!", Toast.LENGTH_SHORT).show();
                        return;

                    }



                    int x = Integer.parseInt(tel1.getText().toString());
                    int y = Integer.parseInt(tel2.getText().toString());

                    int z = x * y;




                    Random rand = new Random();
                    int metro = rand.nextInt(3 - 1 +1) + 1;


                    ran_1 = rand.nextInt(10 - 1 + 1) + 1;//ap to 1 ews to 10
                    if(sum == 1)
                    {
                       temp = ran_1;

                    }else{

                        while(temp == ran_1)
                        {
                            ran_1 = rand.nextInt(10 - 1) + 1;//ap to 1 ews to 10

                        }

                        temp = ran_1;


                    }

                    String auto = skhnika(ran_1);


                    do {
                        ran_2 = rand.nextInt(99) + 10;// ap to 1 ews to 100
                        ran_3 = rand.nextInt(99) + 10; // apo to 1 ews to 100

                    }while(ran_2 == ran_3);


                    if (metro == 1)//Τυχαία εναπόθεση σωστής απάντησης
                    {
                        tel2.setText(String.valueOf(ran_1));
                        ap1.setText(auto);
                        ap2.setText(String.valueOf(ran_3));
                        ap3.setText(String.valueOf(ran_2));

                    } else if (metro == 2) {
                        tel2.setText(String.valueOf(ran_1));
                        ap1.setText(String.valueOf(ran_2));
                        ap2.setText(auto);
                        ap3.setText(String.valueOf(ran_3));

                    } else if (metro == 3) {
                        tel2.setText(String.valueOf(ran_1));
                        ap1.setText(String.valueOf(ran_2));
                        ap2.setText(String.valueOf(ran_3));
                        ap3.setText(auto);
                    }



                    if (z == user_input) {

                        score += 10;
                        score2 +=10;
                        sum +=1;
                    } else {

                        sum+=1;
                    }

                }

                else{


                    Cursor res = DB.getdata();
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                    String k = sp.getString("mail","0");

                    while (res.moveToNext())
                    {

                        String x = res.getString(2);

                        if(k.equals(x))
                        {


                            String tem1 = res.getString(4);
                            String temp2 = res.getString(5);
                            int xt = Integer.parseInt(tem1);
                            int xy = Integer.parseInt(temp2);

                            String s1 = String.valueOf(score1+xt);
                            String s2 = String.valueOf(score2+xy);

                            DB.ananewsi(s1,s2,k);



                            break;


                        }



                    }

                    int neo = score1 + score2;

                    Intent i = new Intent(Askiseis_2o.this, Apotelesmata.class);
                    i.putExtra("intVariableName", neo);
                    startActivity(i);








                }


            }


        });





      /*  okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (user_input == 0) {


                    Toast.makeText(Askiseis_2o.this, "Πρέπει να επιλέξεις απάντηση!", Toast.LENGTH_SHORT).show();
                    return;

                }


                sum += 1;

                int x = Integer.parseInt(tel1.getText().toString());
                int y = Integer.parseInt(tel2.getText().toString());

                int z = x * y;


                if (z == user_input) {

                    score += 10;
                    Toast.makeText(Askiseis_2o.this, String.valueOf(score), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Askiseis_2o.this, "Λαθοοοοοος τρελε", Toast.LENGTH_SHORT).show();
                }


                ran_1 = rand.nextInt(10 - 1) + 1;//ap to 1 ews to 10
                String auto = skhnika(ran_1);
                ran_2 = rand.nextInt(99) + 10;// ap to 1 ews to 100
                ran_3 = rand.nextInt(99) + 10; // apo to 1 ews to 100



                tel2.setText(String.valueOf(ran_1));
                ap1.setText(auto);
                ap2.setText(String.valueOf(ran_3));
                ap3.setText(String.valueOf(ran_2));





            }
        });*/






        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(Askiseis_2o.this, "Na to", Toast.LENGTH_SHORT).show();


            }
        });



    }









    public void prwti(View v)
    {

        String a = ap1.getText().toString();
        user_input = Integer.parseInt(a);



    }

    public void deuteri(View v)
    {
        String b = ap2.getText().toString();
        user_input = Integer.parseInt(b);

    }

    public void triti(View v)
    {

        String c = ap3.getText().toString();
        user_input = Integer.parseInt(c);

    }


    public String skhnika(int ran_1)
    {


        String kati = tel1.getText().toString();
        int k = Integer.parseInt(kati);
        int apotelesma = k*ran_1;
        String neo = String.valueOf(apotelesma);
        return  neo;

    }







}