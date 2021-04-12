package com.example.databasehw;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myvv> {


    String data1[],data2[];
     int images[];
     Context context;
    SQLiteDatabase db = null;
    private MyClassDatabase DB;
    ArrayList<person> e2;

    public MyAdapter(SQLiteDatabase db ,Context ct ,String s1[],String s2[],int img[])
    {
      context = ct;
      data1 = s1;
      data2 = s2;
      images = img;
      DB = new MyClassDatabase(db);
      e2 = DB.print1(db);

    }
    @NonNull
    @Override
    public Myvv onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(context);
        View view = inf.inflate(R.layout.my_row,parent,false);
        return new Myvv(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myvv holder, int position) {

        holder.text1.setText(e2.get(position).name);
        holder.text2.setText(""+e2.get(position).id);
        holder.text3.setText(e2.get(position).sex);
        holder.text4.setText(""+e2.get(position).T);
        holder.text5.setText(""+e2.get(position).B);
        holder.text6.setText(""+e2.get(position).C);


    }

    @Override
    public int getItemCount() {
        return e2.size();
    }

    public class Myvv extends RecyclerView.ViewHolder {

        TextView text1,text2,text3,text4,text5,text6;
        ImageView myImg;


        public Myvv(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.t1);
            text2 = itemView.findViewById(R.id.t2);
            text3 = itemView.findViewById(R.id.t3);
            text4 = itemView.findViewById(R.id.t4);
            text5 = itemView.findViewById(R.id.t5);
            text6 = itemView.findViewById(R.id.t6);
            myImg = itemView.findViewById(R.id.imageView7);

        }
    }
}
