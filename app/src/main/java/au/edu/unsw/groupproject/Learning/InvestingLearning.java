package au.edu.unsw.groupproject.Learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import au.edu.unsw.groupproject.Activities.ForgotPasswordActivity;
import au.edu.unsw.groupproject.Activities.MainActivity;
import au.edu.unsw.groupproject.Activities.QuestionMarkActivity;
import au.edu.unsw.groupproject.Activities.awardsAvailable;
import au.edu.unsw.groupproject.R;
import au.edu.unsw.groupproject.Temp;

public class InvestingLearning extends AppCompatActivity {
    private Button quizBtn;
    private ImageView backBtn;

    private ImageView awardBtn, homeBtn, newsBtn, faqBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.investing_learning);

        quizBtn = findViewById(R.id.quiz_button);
        backBtn = findViewById(R.id.back_button2);
        awardBtn = findViewById(R.id.award_iv);
        homeBtn = findViewById(R.id.home_iv);
        newsBtn = findViewById(R.id.news_iv);
        faqBtn = findViewById(R.id.faq_iv);

        quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InvestingLearning.this, ForgotPasswordActivity.InvestingActivity.class));
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InvestingLearning.this, MainActivity.class));
            }
        });

        awardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InvestingLearning.this, awardsAvailable.class));
            }
        });


        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InvestingLearning.this, Temp.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InvestingLearning.this, MainActivity.class));
            }
        });

        faqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InvestingLearning.this, QuestionMarkActivity.class));
            }
        });
    }
}
