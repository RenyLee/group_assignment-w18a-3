package au.edu.unsw.groupproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import au.edu.unsw.groupproject.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {


    ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportActionBar().hide();

        int totalScore = getIntent().getIntExtra("total", 0);
        int correctAnsw = getIntent().getIntExtra("score", 0);

        int wrong = totalScore - correctAnsw;

        binding.TotalQuestions.setText(String.valueOf(totalScore));
        binding.rightAnswer.setText(String.valueOf(correctAnsw));

        binding.wrongAnswer.setText(String.valueOf(wrong));

        binding.btnRetry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}