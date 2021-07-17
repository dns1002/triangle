package com.ddns1002.triangle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NewWorkoutDialog.NewWorkoutDialogListener {

    private ImageView topMenuButtonProfile;
    private ImageView topMenuButtonCalendar;
    private ImageView topMenuButtonStatistics;
    private ImageView topMenuButtonSettings;
    private ImageView addWorkoutButton;
    private ImageView deleteWorkoutButton;
    private ImageView copyWorkoutButton;
    private TextView packageText;
    private RecyclerView workoutRecyclerView;
//example values
    String[] workoutNames={"Workout name","Chest","Arms"};
    String[] workoutLastDates={"Last: 00/00/00", "Last: 21/04/20","Last: 22/04/20"};
    Integer[] workoutImgs={R.drawable.ic_fitness_24dp,R.drawable.chest,R.drawable.arms};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topMenuButtonProfile = findViewById(R.id.buttonProfileID);
        topMenuButtonCalendar = findViewById(R.id.buttonCalendarID);
        topMenuButtonStatistics = findViewById(R.id.buttonStatisticsID);
        topMenuButtonSettings = findViewById(R.id.buttonSettingID);
        addWorkoutButton = findViewById(R.id.buttonAddWorkoutID);
        deleteWorkoutButton = findViewById(R.id.buttonDeleteWorkoutID);
        copyWorkoutButton = findViewById(R.id.buttonCopyWorkoutID);
        packageText = findViewById(R.id.textPackageID);
//buttons
        topMenuButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        topMenuButtonCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        topMenuButtonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        topMenuButtonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        addWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkoutDialog();

            }
        });
        deleteWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        copyWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        packageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//list of workout routines
        workoutRecyclerView = findViewById(R.id.workoutListID);
        workoutListRefresh();
    }
//Dialog to create new workout routine
    private void openWorkoutDialog (){
        NewWorkoutDialog workoutDialog = new NewWorkoutDialog();
        workoutDialog.show(getSupportFragmentManager(), "New workout");
    }
//to apply the name received in the Dialog to a new workout routine
    @Override
    public void applyWorkoutName(String workoutText) {
        ArrayList<String> addWorkoutName = new ArrayList<String>(Arrays.asList(workoutNames)); //to apply the name
        addWorkoutName.add(workoutText);
        workoutNames =  addWorkoutName.toArray(workoutNames);

        ArrayList<String> addWorkoutDate=new ArrayList<String>(Arrays.asList(workoutLastDates));//to create an empty last date
        addWorkoutDate.add("Last --/--/--");
        workoutLastDates = addWorkoutDate.toArray(workoutLastDates);

        ArrayList <Integer> addWorkoutImg = new ArrayList<Integer>(Arrays.asList(workoutImgs));//to apply the default img
        addWorkoutImg.add(R.drawable.ic_fitness_24dp);
        workoutImgs = addWorkoutImg.toArray(workoutImgs);

        workoutListRefresh();
    }
//refreshing the list to show it updated if there was any change
    public void workoutListRefresh(){
        MyAdapterMain myAdapterMain= new MyAdapterMain(this,workoutNames,workoutLastDates,workoutImgs);
        workoutRecyclerView.setAdapter(myAdapterMain);
        workoutRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
