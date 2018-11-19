package kg.fitness.app;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import kg.fitness.app.classes.Exercise;
import kg.fitness.app.classes.Program;
import kg.fitness.app.utils.HF;

public class MainActivity extends AppCompatActivity {
    private Context mContext = this;
    private TextView ex1Text, ex2Text, ex3Text, ex4Text, ex5Text, timerText, exTitle, totalExText;
    private Button currentExButton;
    private Program currentProgram;
    private int timerSeconds = 0;
    private Handler timerHandler = new Handler();
    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            if (timerSeconds <= 0) {
                nextExercise();
            } else {
                timerSeconds--;
                timerHandler.postDelayed(this, 1000);
                updateTimer();
            }
        }
    };

    private void nextExercise() {
        if (!currentProgram.hasMoreExercise()) {
            Toast.makeText(mContext, R.string.you_finished_program, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        currentProgram.finishedExercise();
        initExercise(currentProgram.getCurrentExercise());
        switch (currentProgram.getCurrentExercise().type) {
            case REST:
                showTimerUI();
                resumeTimer();
                break;
            case WORK:
                hideTimerUI();
                break;
        }
    }

    private void resumeTimer() {
        timerSeconds = currentProgram.getCurrentExercise().count;
        timerHandler.postDelayed(timerRunnable, 0);
    }

    private void updateTimer() {
        timerText.setText(String.valueOf(HF.getFTime(timerSeconds)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();


        currentProgram = new Program(HF.getInitExercises());

        nextExercise();
    }

    private void initExercise(Exercise exercise) {
        currentExButton.setText(String.valueOf(exercise.count));
        exTitle.setText(exercise.title);
        totalExText.setText(getString(R.string.all_ex_count_x_num, currentProgram.getExercisesCount()));
    }

    private void showTimerUI() {
        currentExButton.setVisibility(View.GONE);
        timerText.setVisibility(View.VISIBLE);
    }

    private void hideTimerUI() {
        currentExButton.setVisibility(View.VISIBLE);
        timerText.setVisibility(View.GONE);
    }

    private void initEvent() {
        currentExButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextExercise();
            }
        });
    }

    private void initView() {
        currentExButton = findViewById(R.id.current_ex_cnt_button);
        ex1Text = findViewById(R.id.ex_cnt_1_text);
        ex2Text = findViewById(R.id.ex_cnt_2_text);
        ex3Text = findViewById(R.id.ex_cnt_3_text);
        ex4Text = findViewById(R.id.ex_cnt_4_text);
        ex5Text = findViewById(R.id.ex_cnt_5_text);
        timerText = findViewById(R.id.timer_text);
        exTitle = findViewById(R.id.ex_title);
        totalExText = findViewById(R.id.total_ex_text);

        currentExButton.setVisibility(View.GONE);
        timerText.setVisibility(View.GONE);
    }
}
