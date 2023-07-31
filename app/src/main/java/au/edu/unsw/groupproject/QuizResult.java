package au.edu.unsw.groupproject;

public class QuizResult {
    private String quizName;
    private int experiencePoints;

    public QuizResult() {
        // Empty constructor required for Firebase
    }

    public QuizResult(String quizName, int experiencePoints) {
        this.quizName = quizName;
        this.experiencePoints = experiencePoints;
    }

    public String getQuizName() {
        return quizName;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }
}