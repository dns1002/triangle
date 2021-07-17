package com.ddns1002.triangle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterExerciseSets extends RecyclerView.Adapter <MyAdapterExerciseSets.MyViewHolder>{
    String reps[],weight[],rest[];
    Context ct;

    public MyAdapterExerciseSets(Context context, String[] reps, String[] weight, String[] rest) {
        ct=context;
        this.reps = reps;
        this.weight = weight;
        this.rest = rest;
    }

    @NonNull
    @Override
    public MyAdapterExerciseSets.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ct);
        View view = layoutInflater.inflate(R.layout.row_exercise_set,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterExerciseSets.MyViewHolder holder, int position) {
        holder.text1.setText(reps[position]);
        holder.text2.setText(weight[position]);
        holder.text3.setText(rest[position]);

    }

    @Override
    public int getItemCount() {
        return reps.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2,text3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1= itemView.findViewById(R.id.setExerciseRepsID);
            text2=itemView.findViewById(R.id.setExerciseWeightID);
            text3=itemView.findViewById(R.id.setExerciseRestID);
        }
    }

}
