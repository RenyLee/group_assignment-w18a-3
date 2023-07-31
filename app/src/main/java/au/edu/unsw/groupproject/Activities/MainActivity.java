package au.edu.unsw.groupproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import au.edu.unsw.groupproject.Learning.InvestingLearning;
import au.edu.unsw.groupproject.Learning.MoneyLearning;
import au.edu.unsw.groupproject.R;
import au.edu.unsw.groupproject.Learning.SavingLearning;
import au.edu.unsw.groupproject.Temp;

public class MainActivity extends AppCompatActivity {

    private ImageView levelOne, levelTwo, levelThree;

    private ImageView awardBtn, homeBtn, newsBtn, faqBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        levelOne = findViewById(R.id.level_1);
        levelTwo = findViewById(R.id.level_2);
        levelThree = findViewById(R.id.level_3);
        awardBtn = findViewById(R.id.award_iv);
        homeBtn = findViewById(R.id.home_iv);
        newsBtn = findViewById(R.id.news_iv);
        faqBtn = findViewById(R.id.faq_iv);

        levelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MoneyLearning.class));
            }
        });

        levelTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SavingLearning.class));
            }
        });

        levelThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InvestingLearning.class));
            }
        });

        awardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, awardsAvailable.class));
            }
        });


        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Temp.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        faqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuestionMarkActivity.class));
            }
        });
    }
}

