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
import android.widget.Toast;

public class prop extends AppCompatActivity {


    Button p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,spiti;
    ImageView help;


    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop);

        DB = new DBHelper(this);


        spiti = findViewById(R.id.home);

        p1 = findViewById(R.id.button17);
        p2 = findViewById(R.id.button4);
        p3 = findViewById(R.id.button18);
        p4 = findViewById(R.id.button18);
        p5 = findViewById(R.id.button20);

        help = findViewById(R.id.imagev);


        p6 = findViewById(R.id.button21);
        p7 = findViewById(R.id.button24);
        p8 = findViewById(R.id.button22);
        p9 = findViewById(R.id.button25);
        p10 = findViewById(R.id.button10);






        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(prop.this);
                builder.setCancelable(true);
                builder.setTitle("ΣΥΜΒΟΥΛΗ");
                builder.setMessage("Επέλεξε την προπαίδεια που θέλεις να μελετήσεις.");
                builder.show();



            }
        });



        spiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(prop.this, reception.class);
                startActivity(i);

            }
        });


    }







    public void propaidia(View view)
    {
        Button b = (Button)view;
        String buttonText = b.getText().toString();//;Eτσι παίρνεις τον αριθμό που αναγράφεται στο πλήκτρο (999---------999^^^^^^^^______)
        String number = buttonText.replaceAll("\\D+","");//Καθαρός αριθμός σε String

        String epipedo = "";





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





        int num_wanted = Integer.parseInt(number); // = *
        int num_is = Integer.parseInt(epipedo);// = 1





        if(num_wanted <= num_is)
        {
            Intent i = new Intent(prop.this, propedies_.class);
            i.putExtra("arithmos", number);
            startActivity(i);

        }else
        {

            Toast.makeText(this, "Δεν έχεις ξεκλειδώσει αυτήν την προπαίδεια", Toast.LENGTH_SHORT).show();
        }






    }







}