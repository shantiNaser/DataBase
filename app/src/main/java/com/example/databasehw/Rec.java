package com.example.databasehw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Rec extends AppCompatActivity {

    String s1[],s2[];
    int images[] ={R.drawable.employee};
    RecyclerView rcc;
    SQLiteDatabase db = null;
    private MyClassDatabase DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);

        rcc = findViewById(R.id.rcc);

        s1 = getResources().getStringArray(R.array.Employee_Information);
        s2 = getResources().getStringArray(R.array.Employee_Information);

        db = openOrCreateDatabase("Emp",MODE_PRIVATE,null);
        DB = new MyClassDatabase(db);

        MyAdapter md = new MyAdapter(db,this,s1,s2,images);

        rcc.setAdapter(md);
        rcc.setLayoutManager(new LinearLayoutManager(this));
    }


}