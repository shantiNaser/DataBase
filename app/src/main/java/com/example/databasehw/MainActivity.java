package com.example.databasehw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button ins ,DD , SN , Mo , rcrc;
    SQLiteDatabase db = null;
    private MyClassDatabase DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ins = findViewById(R.id.ins);
        DD = findViewById(R.id.DD);
        SN = findViewById(R.id.SN);
        Mo = findViewById(R.id.MO);
        rcrc = findViewById(R.id.rcrc);


        db = openOrCreateDatabase("Emp",MODE_PRIVATE,null);
        DB = new MyClassDatabase(db);

        ins.setOnClickListener(this);
        DD.setOnClickListener(this);
        SN.setOnClickListener(this);
        Mo.setOnClickListener(this);
        rcrc.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == ins)
        {
            Intent i = new Intent(this,insertAct.class);
            startActivity(i);
        }

        else if(view == DD)
        {
            Intent ii = new Intent(this,DeleAct.class);
            startActivity(ii);
        }
        else if(view == SN)
        {
            Intent iii = new Intent(this,SearchAct.class);
            startActivity(iii);
        }
        else if(view == Mo)
        {
            Intent vi = new Intent(this,ModAct.class);
            startActivity(vi);

        }
        else if(view == rcrc)
        {
            Intent v = new Intent(this,Rec.class);
            startActivity(v);
        }
    }
}