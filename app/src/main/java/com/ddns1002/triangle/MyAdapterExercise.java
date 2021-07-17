package com.ddns1002.triangle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterExercise extends RecyclerView.Adapter <MyAdapterExercise.MyViewHolder> {

    String rNumber[],rWeight[],rRest[];
    Context context;

    public MyAdapterExercise(Context ct, String repsNumber[], String repsWeight[], String repsRest[]) {
        context=ct;
        rNumber=repsNumber;
        rWeight=repsWeight;
        rRest=repsRest;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_reps,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(rNumber[position]);
        holder.text2.setText(rWeight[position]);
        holder.text3.setText(rRest[position]);

    }

    @Override
    public int getItemCount() {
        return rNumber.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text1,text2,text3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.repsRowRepsID);
            text2 = itemView.findViewById(R.id.repsRowWeightID);
            text3 = itemView.findViewById(R.id.repsRowRestID);
        }
    }

}
