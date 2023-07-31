package au.edu.unsw.groupproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import au.edu.unsw.groupproject.R;
import au.edu.unsw.groupproject.Temp;

public class ForgotPasswordActivity extends AppCompatActivity {

    private Button resetBtn, backBtn;
    private EditText edtEmail;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        backBtn = findViewById(R.id.forgot_back);
        resetBtn = findViewById(R.id.forgot_send);
        edtEmail = findViewById(R.id.forgot_email);

        auth = FirebaseAuth.getInstance();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = edtEmail.getText().toString().trim();
                if (!TextUtils.isEmpty(strEmail)) {
                    ResetPassword();
                } else {
                    edtEmail.setError("Email cannot be empty");
                }
            }
        });
    }
    private void ResetPassword() {
        auth.sendPasswordResetEmail(edtEmail.getText().toString().trim())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(ForgotPasswordActivity.this, "Reset Password link has been sent to your registered Email", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgotPasswordActivity.this, "Error :- " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



    }


    public static class InvestingActivity extends AppCompatActivity{

        private TextView setOne, setTwo;
        private ImageView backBtn;

        private ImageView awardBtn, homeBtn, newsBtn, faqBtn;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.investing_sets);

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
                    startActivity(new Intent(InvestingActivity.this, InvestingSet1QuizActivity.class));
                }
            });

            setTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(InvestingActivity.this, InvestingSet2QuizActivity.class));
                }
            });

            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(InvestingActivity.this, MainActivity.class));
                }
            });

            awardBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(InvestingActivity.this, awardsAvailable.class));
                }
            });


            newsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(InvestingActivity.this, Temp.class));
                }
            });

            homeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(InvestingActivity.this, MainActivity.class));
                }
            });

            faqBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(InvestingActivity.this, QuestionMarkActivity.class));
                }
            });
        }

    }
}
