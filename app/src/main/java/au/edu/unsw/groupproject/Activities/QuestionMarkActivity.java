package au.edu.unsw.groupproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import au.edu.unsw.groupproject.R;
import au.edu.unsw.groupproject.Temp;

public class QuestionMarkActivity extends AppCompatActivity {

    private ImageView awardBtn, homeBtn,  newsBtn, faqBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_mark);

        awardBtn = findViewById(R.id.award_iv);
        homeBtn = findViewById(R.id.home_iv);
        newsBtn = findViewById(R.id.news_iv);
        faqBtn = findViewById(R.id.faq_iv);

        awardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuestionMarkActivity.this, awardsAvailable.class));
            }
        });


        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuestionMarkActivity.this, Temp.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuestionMarkActivity.this, MainActivity.class));
            }
        });

        faqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuestionMarkActivity.this, QuestionMarkActivity.class));
            }
        });
    }


}