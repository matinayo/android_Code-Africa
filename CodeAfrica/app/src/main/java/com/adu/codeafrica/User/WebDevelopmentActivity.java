package com.adu.codeafrica.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.adu.codeafrica.R;

public class WebDevelopmentActivity extends AppCompatActivity implements View.OnClickListener {

    //TextView courseIntro;
    ImageView backButton, changeLanguage;
    Button learnHtml, learnCss, learnJavascript;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove top status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_web_development);

        //hooks
        backButton = findViewById(R.id.back_pressed);
        changeLanguage = findViewById(R.id.change_language);
        learnHtml = findViewById(R.id.learn_html);
        learnCss = findViewById(R.id.learn_css);
        learnJavascript = findViewById(R.id.learn_javascript);

        //backPress
        backButton.setOnClickListener(this);
        //changeLanguage button
        changeLanguage.setOnClickListener(this);

        //open LearnActivity when button is clicked
        learnHtml.setOnClickListener(this);
        learnCss.setOnClickListener(this);
        learnJavascript.setOnClickListener(this);
    }

    //setOnclick listener for items
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_pressed:
                //go back to previous activity
                WebDevelopmentActivity.super.onBackPressed();
                break;

            case R.id.change_language:
                //go to LanguageActivity
                startActivity(new Intent(getApplicationContext(), LanguageActivity.class));
                break;

            case R.id.learn_html:
                //navigate to LearnActivity pass title
                intent = new Intent(getApplicationContext(), LearnActivity.class);
                intent.putExtra("title", "HTML");
                startActivity(intent);
                break;

            case R.id.learn_css:
                //navigate to LearnActivity pass title
                intent = new Intent(getApplicationContext(), LearnActivity.class);
                intent.putExtra("title", "CSS");
                startActivity(intent);
                break;

            case R.id.learn_javascript:
                //navigate to LearnActivity pass title
                intent = new Intent(getApplicationContext(), LearnActivity.class);
                intent.putExtra("title", "JAVASCRIPT");
                startActivity(intent);
                break;

        }
    }
}