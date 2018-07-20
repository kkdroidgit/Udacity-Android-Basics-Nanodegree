package in.paperwrk.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText answerText;
    private int quizScore;
    private RadioButton radioButtonQuestionOne;
    private RadioButton getRadioButtonQuestionTwo;
    private CheckBox checkBoxOne;
    private CheckBox checkBoxTwo;
    private CheckBox checkBoxThree;
    private CheckBox checkBoxFour;
    private RadioGroup questionOneGroup;
    private RadioGroup questionTwoGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerText = findViewById(R.id.input_editText);
        radioButtonQuestionOne = findViewById(R.id.radio_captcha1);
        getRadioButtonQuestionTwo = findViewById(R.id.radio_cash3);

        checkBoxOne = findViewById(R.id.cb1);
        checkBoxTwo = findViewById(R.id.cb2);
        checkBoxThree = findViewById(R.id.cb3);
        checkBoxFour = findViewById(R.id.cb4);
        answerText = findViewById(R.id.input_editText);

        questionOneGroup = findViewById(R.id.radioGroupOne);
        questionTwoGroup = findViewById(R.id.radioGroupTwo);

    }

    public void submitAnswers(View view) {
        if (validateMethod()){
            Toast.makeText(this,"Submit all answers",Toast.LENGTH_SHORT).show();
        }
        else {
            calcScore();
            quizScore = 0;
            startActivity(new Intent(this,StartActivity.class));
        }
    }

    private boolean validateMethod(){
        return questionOneGroup.getCheckedRadioButtonId() == -1
                || questionTwoGroup.getCheckedRadioButtonId() == -1
                || (!checkBoxOne.isChecked() && !checkBoxTwo.isChecked() && !checkBoxThree.isChecked() && !checkBoxFour.isChecked())
                || answerText.getText().toString().isEmpty();
    }


    private void calcScore() {
        checkAnswerOne();
        checkAnswerTwo();
        checkAnswerThree();
        checkAnswerFour();
        Toast.makeText(this,"You scored : " + quizScore,Toast.LENGTH_SHORT).show();
    }

    private void checkAnswerOne(){
        if (radioButtonQuestionOne.isChecked()){
            quizScore+=1;
        }
    }

    private void checkAnswerTwo(){
        if (getRadioButtonQuestionTwo.isChecked()){
            quizScore+=1;
        }
    }

    private void checkAnswerThree(){
        if (checkBoxOne.isChecked() && !checkBoxTwo.isChecked()
                && checkBoxThree.isChecked() && checkBoxFour.isChecked()){
            quizScore+=1;
        }
    }

    private void checkAnswerFour(){
        String answerQuestionFour = "First Lady of the United States of America";
        if (answerText.getText().toString().equalsIgnoreCase(answerQuestionFour)){
            quizScore+=1;
        }
    }
}
