package au.edu.unsw.groupproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import au.edu.unsw.groupproject.R;
import au.edu.unsw.groupproject.Temp;

public class SavingActivity extends AppCompatActivity{

    private TextView setOne, setTwo;

    private ImageView backBtn;

    private ImageView awardBtn, homeBtn, newsBtn, faqBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savinghabits_sets);

        setOne = findViewById(R.id.set_1);
        setTwo = findViewById(R.id.set_2);
        backBtn = findViewById(R.id.back_button);
        awardBtn = findViewById(R.id.award_iv);
        homeBtn = findViewById(R.id.home_iv);
        newsBtn = findViewById(R.id.news_iv);
        faqBtn = findViewById(R.id.faq_iv);

        setOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavingActivity.this, SavingsSet1QuizActivity.class));
            }
        });

        setTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavingActivity.this, SavingsSet2QuizActivity.class));
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavingActivity.this, MainActivity.class));
            }
        });
        awardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavingActivity.this, awardsAvailable.class));
            }
        });

        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavingActivity.this, Temp.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavingActivity.this, MainActivity.class));
            }
        });

        faqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavingActivity.this, QuestionMarkActivity.class));
            }
        });

    }

}
