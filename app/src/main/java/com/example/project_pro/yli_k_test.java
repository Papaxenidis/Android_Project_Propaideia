package com.example.project_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class yli_k_test extends AppCompatActivity {


    String x;
    TextView textView_minima;
    Button next,prev;
    int pol=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yli_k_test);


        textView_minima = findViewById(R.id.minima);
        next = findViewById(R.id.button15);
        prev = findViewById(R.id.button16);



        x = "Ο Πολλαπλασιασμός είναι μια προόσθεση που γίνεται πολλές φορές! Για παράδειγμα: 2+2+2 = 6. Δηλάδή χρειαζόμαστε 3 διάρια " +
                "για να πάρουμε τον αριθμό 6. Οπότε, 3 φορές το 2 μας κάνει 6.";
        textView_minima.setText(x);





        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pol < 6)
                {
                    pol++;

                }
                decide();





            }


        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pol >=2 )
                {
                    pol--;

                }
                decide();
            }
        });







    }

    private void decide() {


            if(pol != 6)
            {
                next.setText("→");
                prev.setText("←");
            }





            if(pol == 1)
            {
                x = "Ο Πολλαπλασιασμός είναι μια πρόσθεση που γίνεται πολλές φορές! Για παράδειγμα: 2+2+2 = 6. Δηλάδή χρειαζόμαστε 3 διάρια " +
                        "για να πάρουμε τον αριθμό 6. Οπότε, 3 φορές το 2 μας κάνει 6.";
                textView_minima.setText(x);
            }


            if(pol == 2)
            {
                x = "Mπορούμε επίσης αντί να πούμε \"\\φορές\"\" να λέμε επί, δηλαδή 3 επί 2 μας κάνει 6.";
                textView_minima.setText(x);

            }
            if(pol == 3)
            {
                x = "Τα σύμβολα του πολλαπλασιασμού είναι το:X και το •. Εαν λοιπόν θέλουμε να γράψουμε την πράξη 2 επί 3, θα γράψουμε" +
                        "στο χαρτί: 2x3 ή 2•3. ";
                textView_minima.setText(x);
            }
            if(pol == 4)
            {

                x = " Να θυμάσαι πως δεν έχει σημασία με ποιά σειρά γράφεις τους αριθμούς. Δηλαδή το 6x5 είναι ακριβώς ίδιο με το 5x6 " +
                        "και ισούται με 30.Δες παρακάτω και άλλα παραδείγματα και αν έχεις απορίες μπορείς ανα πάσα στιγμή " +
                        "να επιστρέψεις πίσω για να ξαναδιαβάσεις.";
                textView_minima.setText(x);

            }
            if(pol == 5)
            {
                x = "1x4 = 4,δηλαδή 1+1+1+1 = 4 ──────────────\n" +
                        "2x6 = 12,δηλαδή 6+6 = 12 ή 2+2+2+2+2+2 = 12.\n─────────────" +
                        "4•7 = 28,δηλαδή 7+7+7+7 = 28 ή 4+4+4+4+4+4+4 = 28 \n────────────" +
                        "2•2 = 4,δηλαδή 2+2=4.";

                textView_minima.setText(x);
            }
            if(pol == 6 )
            {
                x = "Λοιπόν φίλε μου,είσαι έτοιμος να μάθουμε τις προπαίδειες;";

                textView_minima.setText(x);

                next.setText("ΝΑΙ");
                prev.setText("OXI");

            }









    }
}