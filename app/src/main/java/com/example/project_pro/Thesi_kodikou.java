package com.example.project_pro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Thesi_kodikou extends AppCompatActivity {

    Button tik;
    EditText editText1,editText2;
    String kod1,kod2,onoma,epitheto,email,temp ="0",epipedo ="1";

    ImageView help;



    DBHelper DB;

    boolean x;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thesi_kodikou);

        tik = findViewById(R.id.button7);
        help = findViewById(R.id.voi);

        editText1 = findViewById(R.id.editTextTextPersonName7);
        editText2 = findViewById(R.id.editTextTextPersonName2);

        DB = new DBHelper(this);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            onoma = extras.getString("name");
            epitheto = extras.getString("lname");
            email = extras.getString("email");

        }

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Thesi_kodikou.this);
                builder.setCancelable(true);
                builder.setTitle("ΣΥΜΒΟΥΛΗ");
                builder.setMessage("Τύπωσε τον κωδικό σου 2 φορές.\nNα θυμάσε πως ο κωδικός σου πρέπει να έχει παραπάνω από 5 ψηφία.\nΜπορείς να τυπώσεις αριθμούς,γράμματα και σύμβολα.");
                builder.show();



            }
        });




        tik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                kod1 = editText1.getText().toString();
                kod2 = editText2.getText().toString();
                x = kod1.equals(kod2);

                if(kod1.isEmpty()) {

                    editText1.setError("Ούπς,ξέχασες να το συμπληρώσεις!");
                    editText1.requestFocus();

                }else if(kod2.isEmpty())
                {
                    editText2.setError("Ούπς,ξέχασες να το συμπληρώσεις!");
                    editText2.requestFocus();

                }
                else if(kod1.length()<5)
                {
                    editText1.setError("Πρέπει να είναι 5 ψηφία και πάνω!");
                    editText1.requestFocus();

                }
                else if(kod2.length()<5)
                {
                    editText2.setError("Πρέπει να είναι 5 ψηφία και πάνω!");
                    editText2.requestFocus();
                }else if(!x)
                {
                    editText1.setError("Οι κωδικοί Πρέπει να είναι ίδιοι! Π.Χ 67818 και 67818");
                    editText1.requestFocus();
                }else
                {

                    //πρεπει να λαμβανει ολα τα στοιχεια με bundle + τον κωδικό και να κανω δηλωσεισ της db

                    String nameTXT =  onoma;
                    String lastnameTXT = epitheto;
                    String emailTXT = email ;
                    String passTXT =kod1;
                    String s1TXT =temp;
                    String s2TXT =temp;
                    String lvl = epipedo;


                    Boolean checkinsertdata = DB.insertuserdata(nameTXT,lastnameTXT,emailTXT,passTXT,s1TXT,s2TXT,lvl);//EDW

                    if(checkinsertdata == true)
                    {
                        Toast.makeText(Thesi_kodikou.this, "Επιτυχής εισαγωγή", Toast.LENGTH_SHORT).show();

                    }else
                    {
                        Toast.makeText(Thesi_kodikou.this, "Αποτυχής εισαγωγή", Toast.LENGTH_SHORT).show();
                    }





                    Intent i = new Intent(Thesi_kodikou.this, Eisodos.class);
                    startActivity(i);

                }







            }
        });




    }
}