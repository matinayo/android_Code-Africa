package com.adu.codeafrica.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adu.codeafrica.HelperClasses.Question;
import com.adu.codeafrica.R;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView backPressed, skipPressed;
    TextView questionTextView;
    Button falseButton, trueButton, nextButton, prevButton;

    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[]{
            new Question(R.string.question_html_stands, true),
            new Question(R.string.question_heading, true),
            new Question(R.string.question_background, false),
            new Question(R.string.question_hyperlink, false),
            new Question(R.string.question_breaks, true),
            new Question(R.string.question_list, false),
            new Question(R.string.question_js_function, true),
            new Question(R.string.question_css_stands, false),
            new Question(R.string.question_css_external, true),
            new Question(R.string.question_css_internal, true),
            //add more questions
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove top status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);

        //hooks
        backPressed = findViewById(R.id.back_pressed);
        skipPressed = findViewById(R.id.skip_pressed);
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        questionTextView = findViewById(R.id.answer_text_view);

        //set onClicked Listener for items
        backPressed.setOnClickListener(this);
        skipPressed.setOnClickListener(this);
        //register buttons to listen to click events
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_pressed:
                //go back to previous activity
                QuizActivity.super.onBackPressed();
                break;

            case R.id.skip_pressed:
                //navigate to AllCategories activity
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
                break;

            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;

            case R.id.next_button:
                //go to next question
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length; //safe
                updateQuestion();
                break;
            case R.id.prev_button:
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                    updateQuestion();
                }
        }
    }

    private void updateQuestion() {
        Log.d("Current", "onClick: " + currentQuestionIndex);
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

    private void checkAnswer(boolean b) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId;

        if (b == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
        } else {
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(QuizActivity.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }
}