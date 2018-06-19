package in.paperwrk.courtcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.shashank.sony.fancygifdialoglib.FancyGifDialog;

public class StartActivity extends AppCompatActivity {


    private EditText etTeamOne;
    private EditText etTeamTwo;
    private String teamNameOne;
    private String teamNameTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        etTeamOne = findViewById(R.id.teamNameOne);
        etTeamTwo = findViewById(R.id.teamNameTwo);

    }


    public void startGame(View view) {
        teamNameOne = etTeamOne.getText().toString().trim();
        teamNameTwo = etTeamTwo.getText().toString().trim();
        if (teamNameOne.isEmpty() || teamNameTwo.isEmpty()){
            Toast.makeText(this,"Please enter the Team Name",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("keyOne",teamNameOne);
            intent.putExtra("keyTwo",teamNameTwo);
            startActivity(intent);
        }
    }


    public void showInstructions(View view) {
        new FancyGifDialog.Builder(this)
                .setTitle("Game Instructions")
                .setMessage(getResources().getString(R.string.instructions))
                .setPositiveBtnText("OK")
                .setGifResource(R.drawable.football)
                .setNegativeBtnText("Cancel")
                .isCancellable(true)
                .build();
    }
}
