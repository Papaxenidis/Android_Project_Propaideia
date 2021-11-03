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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Eisodos extends AppCompatActivity {

    TextView textView_regain;

    EditText us,pas;

    ImageView help;

    SQLiteDatabase db;
    DBHelper DB;


    int auto;

    SharedPreferences sh;


    Button eis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eisodos);


        us = findViewById(R.id.user);
        pas = findViewById(R.id.password);

        help = findViewById(R.id.voi);

        eis =  findViewById(R.id.button4);

        sh = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        DB = new DBHelper(this);


        textView_regain = findViewById(R.id.textView9);


        textView_regain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(Eisodos.this, Anaktisi_code.class);
                startActivity(i);
                
            }
        });


        eis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Cursor res = DB.getdata();
                if(res.getCount() == 0)
                {
                    Toast.makeText(Eisodos.this, "Δεν υπάρχει διαθέσιμος κωδικός", Toast.LENGTH_SHORT).show();
                    return;


                }


                String inpu1 = us.getText().toString();
                String input2 = pas.getText().toString();

                if(inpu1.isEmpty()) {
                    us.setError("Το πεδίο είναι υποχρεωτικό");
                    us.requestFocus();

                }else if(input2.isEmpty())
                {
                    pas.setError("Το πεδίο είναι υποχρεωτικό");
                    pas.requestFocus();

                }else
                {

                    while(res.moveToNext())
                    {

                        String x =  res.getString(0);//username
                        String y  = res.getString(3);//password Γιάννης 555555



                        if(x.equals(inpu1) && y.equals(input2))
                        {

                            auto = 1;

                            SharedPreferences.Editor editor = sh.edit();
                            String m = res.getString(2);

                            editor.putString("mail",m);//αποθηκευση του email του εισερχομένου
                            editor.apply();


                            break;

                        }




                    }

                    if(auto == 1)
                    {
                        Intent i = new Intent(Eisodos.this, reception.class);
                        startActivity(i);

                    }else{
                        Toast.makeText(Eisodos.this, "Δεν υπάρχει ο συνδιασμός που τυπώσατε!", Toast.LENGTH_SHORT).show();
                    }




                }








            }
        });


         help.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 AlertDialog.Builder builder = new AlertDialog.Builder(Eisodos.this);
                 builder.setCancelable(true);
                 builder.setTitle("ΣΥΜΒΟΥΛΗ");
                 builder.setMessage("Τύπωσε το όνομα σου και τον κωδικό που είχες επιλέξει.\nΑν ξέχασες τον κωδικό σου, πάτα  \"\"Ξεχασες τον κωδικό σου;\"\" ");
                 builder.show();





             }
         });



    }
}