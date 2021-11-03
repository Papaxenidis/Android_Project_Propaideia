package com.example.project_pro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_pro.Askiseis_2o;
import com.example.project_pro.DBHelper;
import com.example.project_pro.R;
import com.example.project_pro.reception;

import org.w3c.dom.Text;

import java.util.Random;

public class Askiseis_1o extends AppCompatActivity {


    EditText ken;
    DBHelper DB;
    String epipedo;
    TextView tel1,tel2;

    int rand_int1,sum = 0,score = 0,temp1, apa,mon_thet,mon_ar;

    Button bok,bspiti,fromstart;

    ImageView help;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_askiseis_1o);
        DB = new DBHelper(this);


        fromstart = findViewById(R.id.ok2);

        ken = findViewById(R.id.keno);

        tel1 = findViewById(R.id.teles1);
        tel2 = findViewById(R.id.teles2);

        bok = findViewById(R.id.ok);
        bspiti = findViewById(R.id.home);

        help = findViewById(R.id.imageView22);

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







        fromstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Askiseis_1o.this, Askiseis_1o.class);
                startActivity(i);



            }
        });


        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Askiseis_1o.this);
                builder.setCancelable(true);
                builder.setTitle("ΣΥΜΒΟΥΛΗ");
                builder.setMessage("Θέσε το σωστό αποτέλεσμα στο κενό και μετά πάτα ΟΚ.\nΕάν θες να αρχίσεις απο την αρχή πάτα το ⤴");
                builder.show();


            }
        });




        bok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sum <= 10)
                {



                    String apantisi = ken.getText().toString();

                    if(apantisi.isEmpty())
                    {
                        ken.setError("Το πεδίο πρέπει να έχει αριθμό");
                        ken.requestFocus();

                        return;

                    }



                    Random rand = new Random();
                    rand_int1 = rand.nextInt(11-1) + 1;

                    while(rand_int1 == temp1)
                    {
                        rand_int1 = rand.nextInt(10-1) + 1;


                    }








                    apa = Integer.parseInt(apantisi);

                    int x = Integer.parseInt(tel1.getText().toString());
                    int y = Integer.parseInt(tel2.getText().toString());

                    int z = x*y;


                    if(apa == z)
                    {
                        score+=10;


                    }


                    int k = rand_int1;
                    tel2.setText(String.valueOf(k));
                    temp1 = k;

                    clear();

                }else
                {
                    String apantisi = ken.getText().toString();

                    if(apantisi.isEmpty())
                    {
                        ken.setError("Το πεδίο πρέπει να έχει αριθμό");
                        ken.requestFocus();

                        return;

                    }



                    Random rand = new Random();
                    rand_int1 = rand.nextInt(11-1) + 1;

                    while(rand_int1 == temp1)
                    {
                        rand_int1 = rand.nextInt(10-1) + 1;

                    }


                    apa = Integer.parseInt(apantisi);

                    int x = Integer.parseInt(tel1.getText().toString());
                    int y = Integer.parseInt(tel2.getText().toString());

                    int z = x*y;


                    if(apa == z)
                    {
                        score+=10;

                    }

                    int k = rand_int1;
                    tel2.setText(String.valueOf(k));
                    temp1 = k;


                    Intent i = new Intent(Askiseis_1o.this, Askiseis_2o.class);
                    i.putExtra("score_dek", score);//score thetiko se dekades
                    startActivity(i);




                }



                sum+=1;






            }
        });

        bspiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Askiseis_1o.this, reception.class);
                startActivity(i);



            }
        });








    }



    void clear()
    {
        ken.setText("");

    }











}