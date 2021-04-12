package com.example.databasehw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModAct extends AppCompatActivity implements View.OnClickListener {

    private EditText Moed,e1,e2,e3;
    private Button Moo,Moo2;
    SQLiteDatabase db = null;
    private MyClassDatabase DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod);

        Moed = findViewById(R.id.Moed);
        Moo = findViewById(R.id.Moo);
        Moo2 = findViewById(R.id.Moo2);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);

        db = openOrCreateDatabase("Emp",MODE_PRIVATE,null);
        DB = new MyClassDatabase(db);

        Moo.setOnClickListener(this);
        Moo2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == Moo)
        {
            String g = Moed.getText().toString();
            if(!g.isEmpty())
            {
                int n22 = Integer.parseInt(Moed.getText().toString());
                Boolean res = DB.SearchForID(db, n22);
                if(res == true) {

                    String name = DB.printName(db, n22);
                    String sex = DB.printSex(db, 22);
                    float Bas = DB.printBaseSala(db, n22);
                    float TS = DB.printTSala(db, n22);
                    float CRR = DB.printCR(db, 22);
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("The Employee You Search for :")
                            .setMessage("Name is --->" + name + "\n" + "ID is ----->" + n22 + "\n" + "Gender is ---->" + sex +"\n" + "Base Salary is ----> " + Bas + "\n" + "Totall Salary is ---->"
                                    + TS + "\n" + "Commission Rate is ----->" + CRR + "\n")
                            .setPositiveButton("Modify", null).show();

                    e1.setVisibility(View.VISIBLE);
                    e2.setVisibility(View.VISIBLE);
                    e3.setVisibility(View.VISIBLE);
                    Moo2.setVisibility(View.VISIBLE);






                }
                else if(res == false)
                {
                    Toast.makeText(this,"The Employee you Search for DNE , ",Toast.LENGTH_LONG).show();
                }
            }

            else
                Toast.makeText(this,"An Important Filed was Missing ... ",Toast.LENGTH_LONG).show();
        }


        else if(view == Moo2)
        {
            String r1 = e1.getText().toString();
            String r2 = e2.getText().toString();
            String r3 = e3.getText().toString();

            if(!r1.isEmpty()&&!r2.isEmpty()&&!r3.isEmpty())
            {
                float n44 = Float.parseFloat(e1.getText().toString());
                float n55 = Float.parseFloat(e2.getText().toString());
                float n66 = Float.parseFloat(e3.getText().toString());
                int n22 = Integer.parseInt(Moed.getText().toString());
              boolean r =  DB.ModifyMe(db,n22,n44,n55,n66);
              if(r==true) {
                  Toast.makeText(this, "Modify was Done succssfuuly", Toast.LENGTH_LONG).show();
                  e1.setText(null);
                  e2.setText(null);
                  e3.setText(null);
              }

              else if(r==false)
              {
                  Toast.makeText(this,"Modify was Faild",Toast.LENGTH_LONG).show();
              }
            }
            else
            {
                Toast.makeText(this,"Modify are allowed for all filed",Toast.LENGTH_LONG).show();
            }

        }

    }
}