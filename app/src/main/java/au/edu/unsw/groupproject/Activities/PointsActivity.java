package au.edu.unsw.groupproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import au.edu.unsw.groupproject.R;

public class PointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        int correctAnswers = getIntent().getIntExtra("CORRECT_ANSWERS", 0);
        int wrongAnswers = getIntent().getIntExtra("WRONG_ANSWERS", 0);
        int score = getIntent().getIntExtra("SCORE", 0); // Get the experience points from the Intent

        TextView textViewRightAnswers = findViewById(R.id.totalRight);
        textViewRightAnswers.setText("Right Answers: " + correctAnswers);

        TextView textViewWrongAnswers = findViewById(R.id.totalWrong);
        textViewWrongAnswers.setText("Wrong Answers: " + wrongAnswers);

        TextView textViewScore = findViewById(R.id.totalPoints);
        textViewScore.setText("Score: " + score);
    }
}
