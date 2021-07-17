package com.ddns1002.triangle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] st1,st2,st3,st4,st5,st6;
    private int[] img1;
    private Context context;

    public MyAdapter(Context ct, String[] exerciseName,  String[] exerciseSets, String[] exerciseReps, String[] exerciseWeight, String[] exerciseRest,String[] exerciseDescription, int[] exerciseImage) {

        context = ct;
        img1 = exerciseImage;
        st1 = exerciseName;
        st6 = exerciseDescription;
        st2 = exerciseSets;
        st3 = exerciseReps;
        st4 = exerciseRest;
        st5 = exerciseWeight;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_exercise,parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(st1[position]);
        holder.text2.setText(st2[position]);
        holder.text3.setText(st3[position]);
        holder.text4.setText(st4[position]);
        holder.text5.setText(st5[position]);
        holder.text6.setText(st6[position]);
        holder.img.setImageResource(img1[position]);

    }

    @Override
    public int getItemCount() {
        return st1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text1,text2,text3,text4,text5,text6;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.exerciseRowNameID);
            text2 = itemView.findViewById(R.id.exerciseRowSetsID);
            text3 = itemView.findViewById(R.id.exerciseRowRepsID);
            text4 = itemView.findViewById(R.id.exerciseRowRestID);
            text5 = itemView.findViewById(R.id.exerciseRowWeightID);
            text6 = itemView.findViewById(R.id.exerciseRowDescriptionID);
            img = itemView.findViewById(R.id.exerciseRowImgID);
        }
    }

}