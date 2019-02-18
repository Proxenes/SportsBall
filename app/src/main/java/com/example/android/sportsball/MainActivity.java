package com.example.android.sportsball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables used to store the total score for Team A and Team B
    int teamAScore = 0;
    int teamBScore = 0;

    @Override
    protected void onCreate(Bundle scores) {
        super.onCreate(scores);
        setContentView(R.layout.activity_main);

        // Restores the scores of each team if the activity is destroyed and recreated
        if(scores != null) {
            teamAScore = scores.getInt("teamAScore");
            teamBScore = scores.getInt("teamBScore");

            displayForTeamA(teamAScore);
            displayForTeamB(teamBScore);
        }

        EditText teamA = findViewById(R.id.team_a);
        teamA.setOnEditorActionListener(editorListener);

        // Test functionality of below method(s)
        // displayForTeamA(8);

        // Set the value of teamAScore to the text value of the
        // team_a_score TextView
        // TextView teamAScoreTextView = findViewById(R.id.team_a_score);
        // teamAScore = Integer.parseInt(teamAScoreTextView.getText().toString());
    }

    public TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            EditText teamA = findViewById(R.id.team_a);
            teamA.setEnabled(false);
            teamA.setBackgroundResource(android.R.color.transparent);
            teamA.setTextColor(getResources().getColor(android.R.color.black));
            return false;
        }
    };

    /**
     * Saves the scores of each team to the scores Bundles to be
     * restored if the activity is destroyed
     */
    protected void onSaveInstanceState(Bundle scores) {
        super.onSaveInstanceState(scores);
        scores.putInt("teamAScore", teamAScore);
        scores.putInt("teamBScore", teamBScore);
    }

    /**
     * Overrides back button to not completely exit the app
     */
    public void onBackPressed(){
        moveTaskToBack(true);
    }

    /**
     * Displays the total score for Team A in the team_a_score TextView
     */
    public void displayForTeamA(int score) {
        TextView teamAScoreTextView = (findViewById(R.id.team_a_score));
        teamAScoreTextView.setText(String.valueOf(score));
    }

    /**
     * Increases teamAScore by 6 then updates the team_a_score TextView
     * by calling the displayForTeamA method
     */
    public void teamATouchdown(View view) {
        teamAScore += 6;
        displayForTeamA(teamAScore);
    }

    /**
     * Increases teamAScore by 1 then updates the team_a_score TextView
     * by calling the displayForTeamA method
     */
    public void teamAExtraPoint(View view) {
        teamAScore += 1;
        displayForTeamA(teamAScore);
    }

    /**
     * Increases teamAScore by 2 then updates the team_a_score TextView
     * by calling the displayForTeamA method
     */
    public void teamATwoPoints(View view) {
        teamAScore += 2;
        displayForTeamA(teamAScore);
    }

    /**
     * Increases teamAScore by 3 then updates the team_a_score TextView
     * by calling the displayForTeamA method
     */
    public void teamAFieldGoal(View view) {
        teamAScore += 3;
        displayForTeamA(teamAScore);
    }

    /**
     * Increases teamAScore by 2 then updates the team_a_score TextView
     * by calling the displayForTeamA method
     */
    public void teamASafety(View view) {
        teamAScore += 2;
        displayForTeamA(teamAScore);
    }

    /**
     * Displays the total score for Team B in the team_a_score TextView
     */
    public void displayForTeamB(int score) {
        TextView teamBScoreTextView = (findViewById(R.id.team_b_score));
        teamBScoreTextView.setText(String.valueOf(score));
    }

    /**
     * Increases teamBScore by 6 then updates the team_b_score TextView
     * by calling the displayForTeamB method
     */
    public void teamBTouchdown(View view) {
        teamBScore += 6;
        displayForTeamB(teamBScore);
    }

    /**
     * Increases teamBScore by 1 then updates the team_b_score TextView
     * by calling the displayForTeamB method
     */
    public void teamBExtraPoint(View view) {
        teamBScore += 1;
        displayForTeamB(teamBScore);
    }

    /**
     * Increases teamBScore by 2 then updates the team_b_score TextView
     * by calling the displayForTeamB method
     */
    public void teamBTwoPoints(View view) {
        teamBScore += 2;
        displayForTeamB(teamBScore);
    }

    /**
     * Increases teamBScore by 3 then updates the team_b_score TextView
     * by calling the displayForTeamB method
     */
    public void teamBFieldGoal(View view) {
        teamBScore += 3;
        displayForTeamB(teamBScore);
    }

    /**
     * Increases teamBScore by 2 then updates the team_b_score TextView
     * by calling the displayForTeamB method
     */
    public void teamBSafety(View view) {
        teamBScore += 2;
        displayForTeamB(teamBScore);
    }

    /**
     * Resets scores for both teams to 0
     */
    public void resetScores(View view) {
        teamAScore = 0;
        teamBScore = 0;
        displayForTeamA(teamAScore);
        displayForTeamB(teamBScore);
    }

    public void setOnEditorActionListener(TextView view)
    {

    }
}