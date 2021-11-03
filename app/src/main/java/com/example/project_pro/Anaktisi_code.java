package com.example.project_pro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Anaktisi_code extends AppCompatActivity {


    ImageView help;

    EditText mail,kod1,kod2;

    Button b;

    SQLiteDatabase db;
    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anaktisi_code);



        DB = new DBHelper(this);


        help = findViewById(R.id.voi);

        mail = findViewById(R.id.editmail);
        kod1 = findViewById(R.id.editcode1);
        kod2 = findViewById(R.id.editcode2);

        b = findViewById(R.id.butt);




        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Anaktisi_code.this);
                builder.setCancelable(true);
                builder.setTitle("ΣΥΜΒΟΥΛΗ");
                builder.setMessage("Μόλις τυπώσεις τον νέο κωδικό σου(2 φορές), πάτα το κουμπί και είσαι έτοιμος/η.");
                builder.show();


            }
        });




            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String mailTXT =  mail.getText().toString();
                    String kodikos1TXT = kod1.getText().toString();
                    String kodikos2TXT = kod2.getText().toString();


                    if(mailTXT.isEmpty())
                    {
                        mail.setError("Ούπς, ξέχασες να το συμπληρώσεις!");
                        mail.requestFocus();

                        return;
                    }
                    else if(kodikos1TXT.isEmpty())
                    {
                        kod1.setError("Ούπς, ξέχασες να το συμπληρώσεις!");
                        kod1.requestFocus();

                        return;
                    }else if (kodikos2TXT.isEmpty()) {
                        kod2.setError("Ούπς, ξέχασες να το συμπληρώσεις!");
                        kod2.requestFocus();

                        return;
                    }else if (!kodikos1TXT.equals(kodikos2TXT)) {
                        kod1.setError("Οι κωδικοί πρέπει να είναι ίδιοι");
                        kod1.requestFocus();
                        return;


                    }else if(kod1.length() < 5)
                    {
                        kod1.setError("Ο κωδικός πρέπει να είναι μεγαλύτερος από 6 ψηφία");
                        kod1.requestFocus();
                        return;


                    }else if (!kodikos1TXT.matches("\\S+")) {
                        kod1.setError("Δεν πρέπει να υπάρχουν κενά");
                        kod1.requestFocus();
                        return;

                    }else if (!Patterns.EMAIL_ADDRESS.matcher(mailTXT).matches()) {
                        mail.setError("Επίλεξε έγγυρο email.");
                        mail.requestFocus();
                        return;


                    }else
                    {

                        Boolean checkupdatedata = DB.updateuserdata(mailTXT,kodikos1TXT);

                        if(checkupdatedata == true)
                        {
                            Toast.makeText(Anaktisi_code.this, "Updated", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Anaktisi_code.this, MainActivity.class);
                            startActivity(i);

                        }else
                        {
                            Toast.makeText(Anaktisi_code.this, "Τo email που έδωσες δεν υπάρχει.Ξαναπροσπάθησε", Toast.LENGTH_SHORT).show();
                        }


                    }












                }
            });






    }















}