package au.edu.unsw.groupproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import au.edu.unsw.groupproject.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        android.os.Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashScreenActivity.this, StartActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_right);
                finish();
            }
        };
        handler.postDelayed(runnable, 1500);
    }
}
