package in.paperwrk.courtcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    TextView scoreViewA;
    TextView scoreViewB;
    String teamTwo;
    String teamOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        teamOne = intent.getStringExtra("keyOne");
        teamTwo = intent.getStringExtra("keyTwo");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scoreViewB = findViewById(R.id.team_b_score);
        scoreViewA = findViewById(R.id.team_a_score);

        TextView toolbarText = findViewById(R.id.toolbar_textView);
        Button display_date = findViewById(R.id.button_date);
        toolbarText.setText(teamOne + " v " + teamTwo);


        String date = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(new Date());
        display_date.setText(date);


    }

    private void winMessage(String teamName, int score) {

        new FancyGifDialog.Builder(this)
                .setTitle("Winner is : " + teamName)
                .setMessage(teamName + " wins the match by scoring " + score + " points. ")
                .isCancellable(true)
                .setGifResource(R.drawable.win)
                .setPositiveBtnText("Ok")
                .setNegativeBtnText("Play Again")
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        startActivity(new Intent(MainActivity.this,StartActivity.class));
                    }
                })
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreViewA.setText(String.valueOf(score));
        setPointColors();
        if (scoreTeamA == 70 || scoreTeamA >= 70){
            winMessage(teamOne,scoreTeamA);
        }
    }


    // Display the scores with different colors
    private void setPointColors() {
        if (scoreTeamA > scoreTeamB){
            scoreViewA.setTextColor(getResources().getColor(R.color.blue));
            scoreViewB.setTextColor(getResources().getColor(R.color.red));
        }
        else if (scoreTeamB > scoreTeamA){
            scoreViewB.setTextColor(getResources().getColor(R.color.blue));
            scoreViewA.setTextColor(getResources().getColor(R.color.red));
        }
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        scoreViewB.setText(String.valueOf(score));
        setPointColors();
        if (scoreTeamB == 70 || scoreTeamB >= 70){
            winMessage(teamTwo,scoreTeamB);
        }
    }

    public void fieldGoalTeamA(View view) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    public void epTeamA(View view) {
        scoreTeamA += 6;
        displayForTeamA(scoreTeamA);
    }

    public void penaltyTeamA(View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    public void fieldGoalTeamB(View view) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    public void epTeamB(View view) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    public void penaltyTeamB(View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }



    /**
     * resets the scores of Team A and Team B
     * @param view The button view clicked
     */
    public void resetGame(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
