package com.example.databasehw;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

import java.util.ArrayList;


public class MyClassDatabase {
    private SQLiteDatabase DB;


    public MyClassDatabase(SQLiteDatabase db)
    {
        this.DB = db;
        db.execSQL("create table if not exists Emp ( name Text , id int primary key , sex Text , BaseSala real ,TSala real , CR real);");
    }

    public void print(SQLiteDatabase db)
    {
        Cursor d = db.rawQuery("select * from Emp;",null);
        while(d.moveToNext())
        {
            System.out.println(d.getString(0)+d.getInt(1));
        }
    }

    public ArrayList<person> print1(SQLiteDatabase db)
    {
        Cursor d = db.rawQuery("select * from Emp;",null);
        ArrayList<person> e1 = new ArrayList<person>();
        while(d.moveToNext())
        {
           e1.add(new person(d.getString(0),d.getInt(1),d.getString(2),d.getFloat(3),d.getFloat(4),d.getFloat(5)));
        }
        return e1;
    }



    public boolean ModifyMe(SQLiteDatabase d , int idd, float e1,float e2 ,float e3)
    {
        System.out.println(e3);
        try {
            String r = "update Emp set BaseSala = " + e1 + "," + "TSala = " + e2 + ", CR = " + e3 + " where id = " + idd + ";";
            d.execSQL(r);
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean SearchForID(SQLiteDatabase db , int dd)
    {
        Cursor d = db.rawQuery("select name,id from Emp;",null);
        while(d.moveToNext())
        {
            int g = d.getInt(1);
            if(g == dd)
            {
               return true;
            }
        }
        return false; // here its end the while without found it
    }

    public String printName(SQLiteDatabase db,int dd)
    {
        String name = null;
        Cursor d = db.rawQuery("select name,id from Emp;",null);
        while(d.moveToNext())
        {
            int g = d.getInt(1);
            if(g == dd)
            {
               name = d.getString(0); 
            }
            else
                continue;
                
        }
        return name;
    }

    public String printSex(SQLiteDatabase db,int dd)
    {
        String Sex = null;
        Cursor d = db.rawQuery("select name,id,sex from Emp;",null);
        while(d.moveToNext())
        {
            int g = d.getInt(1);
            if(g == dd)
            {
                Sex = d.getString(2);
            }
            else
                continue;

        }
        return Sex;
    }

    public float printCR(SQLiteDatabase db,int dd)
    {
        float CR =0;
        Cursor d = db.rawQuery("select id,CR from Emp;",null);
        while(d.moveToNext())
        {
            int g = d.getInt(0);
            if(g == dd)
            {
                CR = d.getFloat(1);
            }
            else
                continue;

        }
        return CR;
    }

    public float printTSala(SQLiteDatabase db,int dd)
    {
        float TSala = 0;
        Cursor d = db.rawQuery("select id,TSala from Emp;",null);
        while(d.moveToNext())
        {
            int g = d.getInt(0);
            if(g == dd)
            {
                TSala = d.getFloat(1);
            }
            else
                continue;

        }
        return TSala;
    }

    public float printBaseSala(SQLiteDatabase db,int dd)
    {
        float BaseSala = 0;
        Cursor d = db.rawQuery("select id,BaseSala from Emp;",null);
        while(d.moveToNext())
        {
            int g = d.getInt(0);
            if(g == dd)
            {
                BaseSala = d.getFloat(1);
            }
            else
                continue;

        }
        return BaseSala;
    }





    public int Eqid(SQLiteDatabase db , int id)
    {
        int bb = 0;
     try {
    Cursor d = db.rawQuery("select id from Emp;", null);
    while (d.moveToNext()) {
        int g = d.getInt(0);

        if (g == id)
            bb = 1;
        else
            bb = 0;
    }
    return bb;

     }
    catch (Exception e)
    {
    System.out.println("Database is Empty");
    bb=0;

    }
     return bb;
    }


    public boolean insert(SQLiteDatabase db,String name , int id , String sex , float B ,float T , float CR)
    {
        try {
            String s = "insert into Emp values ('";
            s += name + "'," + id + ",'" + sex + "'," + B + "," + T + "," + CR + ");";
            db.execSQL(s);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


    public boolean deleteEmp(SQLiteDatabase db , int idd)
    {
        try
        {
            String hh = "delete from Emp where id = " + idd + ";";
           db.execSQL(hh);
            return true;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
