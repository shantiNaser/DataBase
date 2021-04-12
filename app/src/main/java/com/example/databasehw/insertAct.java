package com.example.databasehw;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class insertAct extends AppCompatActivity implements View.OnClickListener {

    private EditText name,id,B,T,CR;
    private RadioButton M,F;
    private RadioGroup g;
    private Button save , dele;
    SQLiteDatabase db = null;
    private MyClassDatabase DB;


public String whatIM()
{
    String n=null;
    if(M.isChecked())
    {
        n= "M";
    }
    else if(F.isChecked())
    {
        n = "F";
    }
    return n;
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name = findViewById(R.id.name);
        id = findViewById(R.id.id);
        B = findViewById(R.id.B);
        T =findViewById(R.id.T);
        CR = findViewById(R.id.CR);
        M = findViewById(R.id.e1);
        F = findViewById(R.id.F);
        save = findViewById(R.id.ok);
        dele = findViewById(R.id.Cancle);

        db = openOrCreateDatabase("Emp",MODE_PRIVATE,null);
        DB = new MyClassDatabase(db);


        save.setOnClickListener(this);
        dele.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == save)
        {

            String n1 = name.getText().toString();
            //
            String n2 = id.getText().toString();
            String n3=whatIM();
            String n4 = B.getText().toString();
            String n5 = T.getText().toString();
            String n6 = CR.getText().toString();

            if(!n1.isEmpty()&&!n2.isEmpty()&&!n3.isEmpty()&&!n4.isEmpty()&&!n5.isEmpty()&&!n6.isEmpty()) {

                int n22 = Integer.parseInt(id.getText().toString());
                float n44 = Float.parseFloat(B.getText().toString());
                float n55 = Float.parseFloat(T.getText().toString());
                float n66 = Float.parseFloat(CR.getText().toString());
                int res = DB.Eqid(db, n22);


                if (res == 1) {
                    Toast.makeText(this, "The id you Chooes is Used ", Toast.LENGTH_LONG).show();
                } else if (res == 0) {

                    boolean f = DB.insert(db, n1, n22, n3, n44, n55, n66);
                    if (f == true) {
                        Toast.makeText(this, "employee was add Successfully", Toast.LENGTH_LONG).show();
                        dele.callOnClick();
                    }
                    else if (!f)
                    {
                        Toast.makeText(this, "The id you Chooes is Used ", Toast.LENGTH_LONG).show();
                    }
                }
            }
            else
            {
                Toast.makeText(this,"an important Data was Missing",Toast.LENGTH_LONG).show();
            }


        }

        else if(view == dele)
        {
            name.setText(null);
            id.setText(null);
            B.setText(null);
            T.setText(null);
            CR.setText(null);
        }
    }
}