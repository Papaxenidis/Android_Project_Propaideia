package com.example.project_pro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Eggrafi extends AppCompatActivity {

    TextView textView_onoma,textView_epitheto,textView_kodikos,textView_c1,textView_c2;
    Button next,prev;
    EditText editText;

    int iden;
    ImageView help;

    DBHelper DB;

    String onoma="α",epitheto = "β",email="fw";


    int x=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eggrafi);


        DB = new DBHelper(this);


        textView_onoma = findViewById(R.id.textView6);
        help = findViewById(R.id.voi);
        textView_epitheto = findViewById(R.id.textView2);
        textView_kodikos = findViewById(R.id.textView4);

        textView_c1 = findViewById(R.id.textView3);
        textView_c2 = findViewById(R.id.textView5);

        next = findViewById(R.id.button);
        prev = findViewById(R.id.button5);

        editText = findViewById(R.id.editTextTextPersonName3);



        //ELEGXOS GIA KENO
        //ELEGXOS GIA ARITHMOUS



        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Eggrafi.this);
                builder.setCancelable(true);
                builder.setTitle("ΣΥΜΒΟΥΛΗ");
                builder.setMessage("Γράψε στο κενό το όνομα σου και μετά πάτα \"\"Επόμενο\"\"");
                builder.show();




            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String plaisio = editText.getText().toString();//περιεχομενο πλαισιίου
                String regex = "(.)*(\\d)(.)*";
                Pattern pattern = Pattern.compile(regex);
                boolean containsNumber = pattern.matcher(plaisio).matches();






                    //arxi
                    Cursor res = DB.getdata();
                    while(res.moveToNext() && res.getCount()!=0)
                    {

                        String temp_o = res.getString(2);
                        if(x == 3)
                        {
                            if(temp_o.equals(plaisio))
                            {
                                iden = 1;
                                break;

                            }

                        }


                    }



                if(iden == 1)
                {
                    editText.setError("Το email υπάρχει ήδη.");
                    editText.requestFocus();

                }else if(plaisio.isEmpty()) {

                    editText.setError("Ουπς!Ξέχασες να συμπληρώσεις το πλαίσιο.");
                    editText.requestFocus();

                    if(x>0){
                        x = x - 1;

                    }else
                    {
                        x=0;
                    }

                }else if (containsNumber == true && x!=3)
                {
                    editText.setError("Οι αριθμοί απαγορεύονται στο όνομα και στο επίθετο.");
                    editText.requestFocus();

                }else if(!plaisio.matches("\\S+"))
                {
                    editText.setError("Δεν πρέπει να υπάρχουν κενά.");
                    editText.requestFocus();
                }else if(x==3 && !Patterns.EMAIL_ADDRESS.matcher(plaisio).matches())
                {


                    editText.setError("Πρέπει να δώσεις έγκυρο email.");
                    editText.requestFocus();


                }else if(plaisio.length()<4)
                {
                    editText.setError("Το όνομα σου πρέπει να έχει πάνω από 4 γράμματα.Π.Χ Γιάννης");
                    editText.requestFocus();
                }
                else
                {

                    if(x==1)
                    {
                        onoma = editText.getText().toString();



                    }else if(x==2)
                    {
                        epitheto = editText.getText().toString();



                    }else if (x == 3){

                        email = editText.getText().toString();

                    }

                    epomeno();


                }






            }



        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                proigoumeno();



            }
        });

    }

    private void proigoumeno() {

        x = x-1;


        if(x==1)
        {
            textView_onoma.setVisibility(View.VISIBLE);
            textView_epitheto.setVisibility(View.INVISIBLE);
            textView_c1.setVisibility(View.INVISIBLE);
            prev.setVisibility(View.INVISIBLE);


        }else if(x==2)
        {
            textView_epitheto.setVisibility(View.VISIBLE);
            prev.setVisibility(View.VISIBLE);

            // textView_c1.setVisibility(View.VISIBLE);

            textView_onoma.setVisibility(View.INVISIBLE);

            textView_kodikos.setVisibility(View.INVISIBLE);
            textView_c2.setVisibility(View.INVISIBLE);


        }


    }

    private void epomeno() {

        if(x<=3)
        {
            x=x+1;

        }

        if(x>3)
        {
            Intent i = new Intent(Eggrafi.this, Epivaivewsi_code.class);
            i.putExtra("name", onoma);
            i.putExtra("lname", epitheto);
            i.putExtra("email",email);
            startActivity(i);
        }

        if(x==1)
        {

            prev.setVisibility(View.INVISIBLE);
            textView_onoma.setVisibility(View.VISIBLE);
            editText.setText("");


        }
        if(x==2)
        {
            prev.setVisibility(View.VISIBLE);

            textView_epitheto.setVisibility(View.VISIBLE);

            textView_kodikos.setVisibility(View.INVISIBLE);
            textView_c2.setVisibility(View.INVISIBLE);
            textView_onoma.setVisibility(View.INVISIBLE);
            editText.setText("");


        }else if(x==3)
        {
            prev.setVisibility(View.VISIBLE);

            textView_kodikos.setVisibility(View.VISIBLE);


            textView_epitheto.setVisibility(View.INVISIBLE);
            textView_c1.setVisibility(View.INVISIBLE);
            textView_onoma.setVisibility(View.INVISIBLE);
            editText.setText("");
        }






    }




}