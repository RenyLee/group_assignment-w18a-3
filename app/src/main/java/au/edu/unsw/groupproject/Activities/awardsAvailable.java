package au.edu.unsw.groupproject.Activities;

import static au.edu.unsw.groupproject.FirebaseUtils.getUserId;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import au.edu.unsw.groupproject.R;

public class awardsAvailable extends AppCompatActivity {

    private DatabaseReference userRef;
    private FirebaseDatabase database;

    private int totalExperiencePoints = 0; // Define and initialize the totalExperiencePoints variable


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awards_available);

        // Initialize the Firebase Database instance and the reference to the current user's data
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference("users").child(getUserId());

        // Call the method to calculate the total experience points
        calculateTotalExperiencePoints();
    }

    private void calculateTotalExperiencePoints() {
        // Replace "MoneySet1Quiz", "MoneySet2Quiz", "InvestingSet1Quiz", etc. with the appropriate quiz names
        String[] quizNames = {"MoneySet1Quiz", "MoneySet2Quiz", "InvestingSet1Quiz", "InvestingSet2Quiz", "SavingsSet1Quiz", "SavingsSet2Quiz"};

        //int totalExperiencePoints = 0; // Declare and initialize totalExperiencePoints

        for (String quizName : quizNames) {
            // Get the experience points for the quiz from Firebase
            userRef.child("quizResults").child(quizName).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Integer experiencePoints = dataSnapshot.getValue(Integer.class);
                    if (experiencePoints != null) {
                        // Add the experience points to the total
                        totalExperiencePoints += experiencePoints;

                        // Update the UI with the total experience points
                        updateExperiencePointsUI(totalExperiencePoints);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle the error, if needed
                }
            });
        }
    }

    private void updateExperiencePointsUI(int totalExperiencePoints) {
        // Update the TextView with the total experience points
        TextView tvExperiencePoints = findViewById(R.id.tvExperiencePoints);
        tvExperiencePoints.setText("Experience Points: " + totalExperiencePoints);

        //totalExperiencePoints = 4500;
        // Determine which awards are unlocked based on the total experience points
        if (totalExperiencePoints >= 800) {
            // Bronze Award is unlocked
            findViewById(R.id.tvBadge1Unlocked).setVisibility(View.VISIBLE);
            findViewById(R.id.ivBadge1Locked).setVisibility(View.GONE);
        }

        if (totalExperiencePoints >= 1700) {
            // Silver Award is unlocked
            findViewById(R.id.tvBadge2Unlocked).setVisibility(View.VISIBLE);
            findViewById(R.id.ivBadge2Locked).setVisibility(View.GONE);
        }

        if (totalExperiencePoints >= 2600) {
            // Gold Award is unlocked
            findViewById(R.id.tvBadge3Unlocked).setVisibility(View.VISIBLE);
            findViewById(R.id.ivBadge3Locked).setVisibility(View.GONE);
        }

        if (totalExperiencePoints >= 3400) {
            // Diamond Award is unlocked
            findViewById(R.id.tvBadge4Unlocked).setVisibility(View.VISIBLE);
            findViewById(R.id.ivBadge4Locked).setVisibility(View.GONE);
        }

        if (totalExperiencePoints >= 4500) {
            // Platinum Award is unlocked
            findViewById(R.id.tvBadge5Unlocked).setVisibility(View.VISIBLE);
            findViewById(R.id.ivBadge5Locked).setVisibility(View.GONE);
            // Hide the TextView for points to next level and set it to "Complete"
            TextView tvPointsToNextLevel = findViewById(R.id.tvPointsToNextLevel);
            tvPointsToNextLevel.setText("Complete");

        } else {
            // Calculate the points needed to reach the next level
            int pointsToNextLevel = 0;
            if (totalExperiencePoints < 800) {
                pointsToNextLevel = 800 - totalExperiencePoints;
            } else if (totalExperiencePoints < 1700) {
                pointsToNextLevel = 1700 - totalExperiencePoints;
            } else if (totalExperiencePoints < 2600) {
                pointsToNextLevel = 2600 - totalExperiencePoints;
            } else if (totalExperiencePoints < 3400) {
                pointsToNextLevel = 3400 - totalExperiencePoints;
            } else if (totalExperiencePoints < 4500) {
                pointsToNextLevel = 4500 - totalExperiencePoints;
            }

            // Update the TextView with the points needed to reach the next level
            TextView tvPointsToNextLevel = findViewById(R.id.tvPointsToNextLevel);
            tvPointsToNextLevel.setText("Points Until Next Level: " + pointsToNextLevel);
        }
    }
}
