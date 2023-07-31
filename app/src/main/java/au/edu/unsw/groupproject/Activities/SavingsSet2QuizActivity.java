package au.edu.unsw.groupproject.Activities;

import static au.edu.unsw.groupproject.FirebaseUtils.getUserId;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import au.edu.unsw.groupproject.R;

public class SavingsSet2QuizActivity extends AppCompatActivity {

    String[] question_list = {"What is the relationship between inflation and interest rate", "What is the term for Interest paid on interest previously earned",
            "How does the unemployment rate affect interest rate"};

    String[] option_list = {"High inflation leads to lower interest rates.", "High inflation leads to higher interest rates.", "Inflation has no impact on interest rates.",
            "Inflation only affects compound interest, not simple interest.",
            "Simple interest rate", "Compound interest rate", "Fixed interest rate", "None of the above",
            "High unemployment leads to lower interest rates.", "High unemployment leads to higher interest rates.",
            "Unemployment rate has no relation with interest rates", "Changes in the unemployment rate only affect short-term loans."};

    String[] answer_list = {"High inflation leads to higher interest rates. ", "Compound interest rate",
            "High unemployment leads to lower interest rates."};

    TextView total_question, text_question;
    Button option1_button, option2_button, option3_button, option4_button, next_button, image_back;

    int currentQuestion = 0;
    boolean isclickBtn = false;
    String valueOption = "";
    Button btn_click;

    int correctAnswerCounter = 0;
    int wrongAnswerCounter = 0;
    private int experiencePoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_set2_quiz);
        total_question = findViewById(R.id.total_question);
        text_question = findViewById(R.id.text_question);

        option1_button = findViewById(R.id.option1_button);
        option2_button = findViewById(R.id.option2_button);
        option3_button = findViewById(R.id.option3_button);
        option4_button = findViewById(R.id.option4_button);
        next_button = findViewById(R.id.next_button);

        findViewById(R.id.image_back).setOnClickListener(a -> finish());

        int startingExperiencePoints = getIntent().getIntExtra("EXPERIENCE_POINTS", 0);
        experiencePoints = startingExperiencePoints;

        remplirData();

        next_button.setOnClickListener(view -> {
            if (isclickBtn) {
                isclickBtn = false;

                if (!valueOption.equals(answer_list[currentQuestion])) {
                    Toast.makeText(SavingsSet2QuizActivity.this, "wrong", Toast.LENGTH_LONG).show();
                    btn_click.setBackgroundResource(R.drawable.background_btn_wrong);
                    correctAnswerCounter = correctAnswerCounter;
                    wrongAnswerCounter = wrongAnswerCounter + 1;
                } else {
                    Toast.makeText(SavingsSet2QuizActivity.this, "correct", Toast.LENGTH_LONG).show();
                    btn_click.setBackgroundResource(R.drawable.background_btn_correct);
                    correctAnswerCounter = correctAnswerCounter + 1;
                    wrongAnswerCounter = wrongAnswerCounter;
                }

                new Handler().postDelayed(() -> {
                    if (currentQuestion != 2) {
                        currentQuestion = currentQuestion + 1;
                        remplirData();
                        isclickBtn = false;
                        valueOption = "";
                        option1_button.setBackgroundResource(R.drawable.background_btn_option_color);
                        option2_button.setBackgroundResource(R.drawable.background_btn_option_color);
                        option3_button.setBackgroundResource(R.drawable.background_btn_option_color);
                        option4_button.setBackgroundResource(R.drawable.background_btn_option_color);
                    } else {
                        // The quiz is completed, calculate the score (experience points)
                        int score = 0;
                        if (correctAnswerCounter == 1)
                            score = 300;
                        else if (correctAnswerCounter == 2)
                            score = 600;
                        else if (correctAnswerCounter == 3)
                            score = 1000;

                        // Get the user ID from Firebase (Replace this with your own method to get the user ID)
                        String userId = getUserId();

                        // Replace "QuizName" with the appropriate name for this quiz
                        String quizName = "SavingsSet2Quiz";

                        // Instead of "XP", use "experiencePoints" node to save the score
                        FirebaseDatabase.getInstance().getReference("users").child(userId).child("quizResults").child(quizName).setValue(score);


                        experiencePoints += score;
                        FirebaseDatabase.getInstance().getReference("users")
                                .child(getUserId()).child("experiencePoints").setValue(experiencePoints);

                        //Intent intent = new Intent(MoneySet1QuizActivity.this, awardsAvailable.class);
                        //intent.putExtra("EXPERIENCE_POINTS", experiencePoints);
                        //

                        Intent intent = new Intent(SavingsSet2QuizActivity.this, PointsActivity.class);
                        intent.putExtra("SCORE", score);
                        intent.putExtra("CORRECT_ANSWERS", correctAnswerCounter);
                        intent.putExtra("WRONG_ANSWERS", wrongAnswerCounter);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
            } else {
                Toast.makeText(SavingsSet2QuizActivity.this, "You must at least choose one", Toast.LENGTH_LONG).show();
            }
        });
    }

    void remplirData() {
        total_question.setText((currentQuestion + 1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);
        option1_button.setText(option_list[currentQuestion * 4]);
        option2_button.setText(option_list[currentQuestion * 4 + 1]);
        option3_button.setText(option_list[currentQuestion * 4 + 2]);
        option4_button.setText(option_list[currentQuestion * 4 + 3]);
    }

    public void ClickOption(View view) {
        btn_click = (Button) view;
        if (!isclickBtn) {
            optionBtn();
        } else {
            option1_button.setBackgroundResource(R.drawable.background_btn_option_color);
            option2_button.setBackgroundResource(R.drawable.background_btn_option_color);
            option3_button.setBackgroundResource(R.drawable.background_btn_option_color);
            option4_button.setBackgroundResource(R.drawable.background_btn_option_color);
            optionBtn();
        }
    }

    void optionBtn() {
        btn_click.setBackgroundResource(R.drawable.background_btn_choose);
        isclickBtn = true;
        valueOption = btn_click.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            int updatedExperiencePoints = data.getIntExtra("UPDATED_EXPERIENCE_POINTS", 0);
            experiencePoints = updatedExperiencePoints;
        }
    }
}
