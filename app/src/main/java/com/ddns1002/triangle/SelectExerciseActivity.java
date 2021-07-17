package com.ddns1002.triangle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectExerciseActivity extends AppCompatActivity implements NewExerciseDialog.NewExerciseDialogListener {

    private ImageView createExercise;

    private RecyclerView exercisesList;
    private String exerciseNames[]={"Bench Press Barbell", "Bench Press Dumbell", "Burpee","Deadlift","Lunges","Pulldown","Pushups", "Squats"};
    private Integer exerciseImgs[]={R.drawable.bench_press,R.drawable.bench_press,R.drawable.arms,R.drawable.ic_fitness_24dp,R.drawable.squats,R.drawable.chest, R.drawable.bench_press,R.drawable.squats,R.drawable.squats,R.drawable.squats};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_exercise);

        createExercise = findViewById(R.id.createExerciseImgID);
        createExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExerciseDialog();
            }
        });

        exercisesList = findViewById(R.id.selectExerciseListID);
        MyAdapterExerciseSelection myAdapterExerciseSelection = new MyAdapterExerciseSelection(this,exerciseNames,exerciseImgs);
        exercisesList.setAdapter(myAdapterExerciseSelection);
        exercisesList.setLayoutManager(new LinearLayoutManager(this));

    }
    private void openExerciseDialog (){
        NewExerciseDialog exerciseDialog = new NewExerciseDialog();
        exerciseDialog.show(getSupportFragmentManager(),"New exercise");
    }
    public void applyExerciseName (String exerciseText){

    }
}
