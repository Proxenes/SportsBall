package com.example.android.sportsball;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Variables used to store the total score for Team A and Team B
    int teamAScore = 0;
    int teamBScore = 0;

    // Variables used to store the team names
    String teamAText = "";
    String teamBText = "";

    @Override
    protected void onCreate(Bundle scores) {
        super.onCreate(scores);
        setContentView(R.layout.activity_main);

        // Restores the scores and names of each team if the activity is destroyed and recreated
        if(scores != null) {
            teamAScore = scores.getInt("teamAScore");
            teamBScore = scores.getInt("teamBScore");
            teamAText = scores.getString("teamAText");
            teamBText = scores.getString("teamBText");

            displayForTeamA(teamAScore);
            displayForTeamB(teamBScore);


            // If team names have already been entered, prevents the team names from
            // being editable again
            if(teamAText.isEmpty() == false) {
                EditText teamA = findViewById(R.id.team_a);
                teamA.setEnabled(false);
                teamA.setBackgroundResource(android.R.color.transparent);
                teamA.setTextColor(getResources().getColor(android.R.color.black));
            }

            if(teamBText.isEmpty() == false) {
                EditText teamB = findViewById(R.id.team_b);
                teamB.setEnabled(false);
                teamB.setBackgroundResource(android.R.color.transparent);
                teamB.setTextColor(getResources().getColor(android.R.color.black));
            }
        }

        // Set editor listeners for enter key functionality
        final EditText teamA = findViewById(R.id.team_a);
        teamA.setOnEditorActionListener(editorListenerA);

        final EditText teamB = findViewById(R.id.team_b);
        teamB.setOnEditorActionListener(editorListenerB);

        // Clears hint text when tapping on team name EditTexts
        teamA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                teamA.setHint(hasFocus ? "" : getString(R.string.team_a_name));
            }
        });

        teamB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                teamB.setHint(hasFocus ? "" : getString(R.string.team_b_name));
            }
        });
    }

    /**
     * Create action listener for keyboard enter press for Team A Name
     */
    public TextView.OnEditorActionListener editorListenerA = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            EditText teamA = findViewById(R.id.team_a);
            teamA.setBackgroundResource(android.R.color.transparent);
            teamA.setTextColor(getResources().getColor(android.R.color.black));
            teamAText = teamA.getText().toString();
            teamA.clearFocus();
            teamA.setEnabled(false);
            return false;
        }
    };

    /**
     * Create action listener for keyboard enter press for Team B Name
     */
    public TextView.OnEditorActionListener editorListenerB = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            EditText teamB = findViewById(R.id.team_b);
            teamB.setBackgroundResource(android.R.color.transparent);
            teamB.setTextColor(getResources().getColor(android.R.color.black));
            teamBText = teamB.getText().toString();
            teamB.clearFocus();
            teamB.setEnabled(false);
            return false;
        }
    };

    /**
     * Saves the scores and names of each team to the scores Bundles to be
     * restored if the activity is destroyed
     */
    protected void onSaveInstanceState(Bundle scores) {
        super.onSaveInstanceState(scores);
        scores.putInt("teamAScore", teamAScore);
        scores.putInt("teamBScore", teamBScore);
        scores.putString("teamAText", teamAText);
        scores.putString("teamBText", teamBText);
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

        EditText teamA = findViewById(R.id.team_a);
        teamA.setEnabled(true);
        teamA.setText("");
        teamA.setTextColor(getResources().getColor(android.R.color.darker_gray));
        teamA.setHint(getString(R.string.team_a_name));

        EditText teamB = findViewById(R.id.team_b);
        teamB.setEnabled(true);
        teamB.setText("");
        teamB.setTextColor(getResources().getColor(android.R.color.darker_gray));
        teamB.setHint(getString(R.string.team_b_name));
    }


}