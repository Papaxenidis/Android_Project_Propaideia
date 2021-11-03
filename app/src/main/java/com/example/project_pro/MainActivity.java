package com.example.project_pro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button yes,no,kati;


    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB = new DBHelper(this);


        yes = findViewById(R.id.button2);
        no = findViewById(R.id.button3);
        kati = findViewById(R.id.button9);


       kati.setOnClickListener(new View.OnClickListener() { //ΠΡΟΧΕΙΡΟ ΚΟΥΜΠΙΙΙΙΙΙ
            @Override
            public void onClick(View v) {



                Cursor res = DB.getdata();
                if(res.getCount() == 0)
                {
                    Toast.makeText(MainActivity.this, "No entry happened", Toast.LENGTH_SHORT).show();
                    return;


                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Όνομα :" + res.getString(0)+"\n");
                    buffer.append("Επίθετο :" + res.getString(1)+"\n");
                    buffer.append("email :" + res.getString(2)+"\n");
                    buffer.append("password :" + res.getString(3)+"\n");
                    buffer.append("sc1 :" + res.getString(4)+"\n");
                    buffer.append("sc2 :" + res.getString(5)+"\n");
                    buffer.append("Level :" + res.getString(6)+"\n\n");






                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User entries");
                builder.setMessage(buffer.toString());
                builder.show();

/*
                String nameTXT =  "Παντελής";


                Boolean checkdeletedata = DB.deletedata(nameTXT);

                if(checkdeletedata == true)
                {
                    Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();

                }else
                {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }


*/


            }
        });


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Eisodos.class);
                startActivity(i);




            }
        });



        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Eggrafi.class);
                startActivity(i);

            }
        });
    }
}