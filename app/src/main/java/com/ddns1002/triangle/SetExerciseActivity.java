package com.ddns1002.triangle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SetExerciseActivity extends AppCompatActivity {

    private ImageView exerciseImg;
    private TextView exerciseName;
    private TextView exerciseDescription;
    private ImageView addSerieButton;
    private ImageView editExerciseButton;
    private RecyclerView seriesList;
//example values
    String setExerciseReps[]={"12 x","00:45"};
    String setExerciseWeight[]={"15 kg","-"};
    String setExerciseRest[]={"01:00","00:30"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_exercise);

        exerciseImg=findViewById(R.id.setExerciseImgID);
        exerciseName=findViewById(R.id.setExerciseNameID);
        exerciseDescription=findViewById(R.id.setExerciseDescriptionID);
//add one more series through the add button
        addSerieButton=findViewById(R.id.setExerciseAddButtonID);
        addSerieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//editing the exercise name and image
        editExerciseButton=findViewById(R.id.setExerciseEditButtonID);
        editExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//series listing
        seriesList=findViewById(R.id.setExerciseSeriesListID);
        MyAdapterExerciseSets myAdapterExerciseSets = new MyAdapterExerciseSets(
                this,setExerciseReps,setExerciseWeight,setExerciseRest);
        seriesList.setAdapter(myAdapterExerciseSets);
        seriesList.setLayoutManager(new LinearLayoutManager(this));
    }
}
