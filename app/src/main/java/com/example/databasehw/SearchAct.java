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

public class SearchAct extends AppCompatActivity implements View.OnClickListener {

    private EditText e12;
    private Button SSS;
    SQLiteDatabase db = null;
    private MyClassDatabase DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        e12 = findViewById(R.id.e12);
        SSS = findViewById(R.id.SSS);

        db = openOrCreateDatabase("Emp",MODE_PRIVATE,null);
        DB = new MyClassDatabase(db);


        SSS.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == SSS)
        {
           String g = e12.getText().toString();
           if(!g.isEmpty())
           {
               int n22 = Integer.parseInt(e12.getText().toString());
               Boolean res = DB.SearchForID(db, n22);
               if(res == true)
               {

                   String name = DB.printName(db,n22);
                   String sex = DB.printSex(db,22);
                   float Bas = DB.printBaseSala(db,n22);
                   float TS  = DB.printTSala(db,n22);
                   float CRR = DB.printCR(db,22);
                   AlertDialog.Builder builder = new AlertDialog.Builder(this);
                   builder.setTitle("The Employee You Search For has this information:")
                           .setMessage("Name is --->" + name + "\n" + "ID is ----->" + n22 + "\n" + "Gender is ---->" + sex +"\n" + "Base Salary is ----> " + Bas + "\n" + "Totall Salary is ---->"
                           + TS + "\n" + "Commission Rate is ----->" + CRR + "\n")
                           .setPositiveButton("Close",null).show();

                   e12.setText(null);

               }
               else if(res == false)
               {
                   Toast.makeText(this,"The Employee you Search for DNE , ",Toast.LENGTH_LONG).show();
               }
           }
           else
               Toast.makeText(this,"An Important Filed was Missing ... ",Toast.LENGTH_LONG).show();
        }
    }
}