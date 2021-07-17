package com.ddns1002.triangle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RoutineActivity extends AppCompatActivity {

    RecyclerView exercisesList;
    String s1[]={"EXERCISE NAME","BENCH PRESS", "SQUATS"};
    String s2[]={"Sets: -","Sets: 3","Sets: 4"};
    String s3[] ={"Reps: -", "Reps: 12","Reps: 12, 10, 8, 6"};
    String s4[] ={"Weight: -", "Weight: 20, 18, 16kg", "Weight: 20kg"};
    String s5[] ={"Rest: -","Rest: 30s","Rest:-"};
    String s6[] = {"Description/note","youtube.com/watch?v=gRVjAtPip0Y","Use the big bar"};
    int im1[] = {R.drawable.ic_fitness_24dp,R.drawable.bench_press,R.drawable.squats};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        exercisesList = findViewById(R.id.exerciseListID);
        MyAdapter myAdapter = new MyAdapter(this,s1,s2,s3,s4,s5,s6,im1);
        exercisesList.setAdapter(myAdapter);
        exercisesList.setLayoutManager(new LinearLayoutManager(this));


    }
}
