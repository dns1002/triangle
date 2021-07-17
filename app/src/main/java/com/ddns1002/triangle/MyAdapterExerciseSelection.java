package com.ddns1002.triangle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterExerciseSelection extends RecyclerView.Adapter <MyAdapterExerciseSelection.MyViewHolder> {

    Context ct;
    Integer exImg[];
    String exName[];

    public MyAdapterExerciseSelection(Context context, String exercisesNames[], Integer exerciseImgs[]) {
        ct=context;
        exImg=exerciseImgs;
        exName=exercisesNames;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.row_select_exercise,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(exName[position]);
        holder.img1.setImageResource(exImg[position]);

    }

    @Override
    public int getItemCount() {
        return exName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text1;
        ImageView img1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.exerciseSelectionNameID);
            img1 = itemView.findViewById(R.id.exerciseSelectionImgID);
        }
    }
}
