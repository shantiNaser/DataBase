package com.example.databasehw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleAct extends AppCompatActivity implements View.OnClickListener {

    private EditText dd;
    private Button okDele;
    SQLiteDatabase db = null;
    private MyClassDatabase DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dele);

        dd = findViewById(R.id.dee);
        okDele = findViewById(R.id.okDele);
        db = openOrCreateDatabase("Emp",MODE_PRIVATE,null);
        DB = new MyClassDatabase(db);

        okDele.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == okDele)
        {
            String g = dd.getText().toString();
            if(!g.isEmpty())
            {
                int n22 = Integer.parseInt(dd.getText().toString());
                Boolean res = DB.SearchForID(db, n22);
                System.out.println(res);
                if(res == true)
                {

                    String name = DB.printName(db,n22);
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Are You sure you want to Delete " + name + " Employee ?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int n22 = Integer.parseInt(dd.getText().toString());
                        boolean f = DB.deleteEmp(db,n22);
                        if(f==true)
                        {
                            Toast.makeText(getApplicationContext(),"The process was Done Successfully",Toast.LENGTH_LONG).show();
                        }
                        else if(f==false)
                        {
                            Toast.makeText(getApplicationContext(),"The process was Faild",Toast.LENGTH_LONG).show();
                        }
                    }
                })
                            .setNegativeButton("No",null).show();

                }
                else if(res == false)
                {
                    Toast.makeText(this,"The Employee you Search for DNE , ",Toast.LENGTH_LONG).show();
                }

            }
            else
            {
                Toast.makeText(this,"An Important Filed was Missing ... ",Toast.LENGTH_LONG).show();
            }
        }
    }
}