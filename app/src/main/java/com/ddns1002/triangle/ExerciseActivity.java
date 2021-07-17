package com.ddns1002.triangle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class ExerciseActivity extends AppCompatActivity {

    private TextView countdown;
    private ImageView pauseTimerButton;
    private CountDownTimer countDownTimer;
    private boolean runningTimer;
    private long restTimeMilis=60000;
    private long leftTimeMilis=restTimeMilis;

    private ImageView goToRoutineButton;
    private ImageView nextExerciseButton;
    private ImageView previousExerciseButton;
    private Button finishWorkout;

    private RecyclerView repsList;
    private String repsNumber[]={"12 x","10 x", "30 s"};
    private String repsWeight[]={"10 kg", "10 kg", "-"};
    private String repsRest[] = {"00:30", "01:00", "-"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
//timer
        countdown = findViewById(R.id.restCountdownID);
        pauseTimerButton = findViewById(R.id.pauseRestButton);

        pauseTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (runningTimer) {
                    pauseTimer();
                } else startTimer();
            }
        });
        updateCountdown();


//navigation buttons
        goToRoutineButton = findViewById(R.id.routineButtonID);
        nextExerciseButton = findViewById(R.id.nextExerciseButtonID);
        previousExerciseButton = findViewById(R.id.previousExerciseButtonID);
        finishWorkout = findViewById(R.id.finishWorkoutButtonID);

//exercises list
        repsList= findViewById(R.id.repsListID);
        MyAdapterExercise myAdapterExercise = new MyAdapterExercise(this, repsNumber,repsWeight,repsRest);
        repsList.setAdapter(myAdapterExercise);
        repsList.setLayoutManager(new LinearLayoutManager(this));

    }

    private void pauseTimer(){
        pauseTimerButton.setImageResource(R.drawable.ic_play_outline_24dp);
        runningTimer = false;
        countDownTimer.cancel();
    }
    private void startTimer(){
        pauseTimerButton.setImageResource(R.drawable.ic_pause_outline_24dp);
        runningTimer=true;

        countDownTimer = new CountDownTimer(leftTimeMilis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                leftTimeMilis = millisUntilFinished;
                updateCountdown ();
            }
            @Override
            public void onFinish() {
                runningTimer=false;
                //pauseTimerButton.setVisibility(View.INVISIBLE); //falta colocar como visivel sempre que clicar no RecyclerView (boolean talvez?)
            }
        }.start();

    }
    private void updateCountdown(){
        int minutes = (int) (leftTimeMilis/1000)/60;
        int seconds = (int) (leftTimeMilis/1000)%60;

        String timeLeft = String.format(Locale.getDefault(),"%02d:%02d", minutes,seconds);
        countdown.setText(timeLeft);

    }
}
