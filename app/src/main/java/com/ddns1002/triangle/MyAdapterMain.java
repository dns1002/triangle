package com.ddns1002.triangle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterMain extends RecyclerView.Adapter <MyAdapterMain.MyViewHolder> {

    private String[] wName,wLast;
    private Integer[] wImg;
    private Context context;

    public MyAdapterMain(Context ct, String[] workoutName, String[] workoutLast, Integer[] workoutImage) {
        context=ct;
        wName=workoutName;
        wLast=workoutLast;
        wImg=workoutImage;
    }

    @NonNull
    @Override
    public MyAdapterMain.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_workouts,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterMain.MyViewHolder holder, int position) {
        holder.text1.setText(wName[position]);
        holder.text2.setText(wLast[position]);
        holder.img.setImageResource(wImg[position]);
//using the cardview to open the workout routine - yet to send parameters
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RoutineActivity.class );
                context.startActivity(intent);
            }
        });
//starting the routine through the play button - yet to send parameters
        holder.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ExerciseActivity.class );
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return wName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text1,text2;
        ImageView img,startButton;
        ConstraintLayout row;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.workoutRowNameID);
            text2 = itemView.findViewById(R.id.workoutRowLastID);
            img = itemView.findViewById(R.id.workoutRowImgID);
            startButton = itemView.findViewById(R.id.workoutRowStartID);
            row = itemView.findViewById(R.id.workoutRowID);
        }
    }
}
