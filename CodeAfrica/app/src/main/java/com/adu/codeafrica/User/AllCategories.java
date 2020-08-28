package com.adu.codeafrica.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.adu.codeafrica.R;

public class AllCategories extends AppCompatActivity implements View.OnClickListener {

    ImageView backButton, changeLanguage;
    Button expandWebDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove top status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all_categories);

        //Hooks
        backButton = findViewById(R.id.back_pressed);
        changeLanguage = findViewById(R.id.change_language);
        expandWebDev = findViewById(R.id.expand_web_dev);

        //go back to previous activity
        backButton.setOnClickListener(this);
        //navigate to LanguageActivity
        changeLanguage.setOnClickListener(this);
        //navigate to lecture activity
        expandWebDev.setOnClickListener(this);
    }

    //set onClick listener for items
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_pressed:
                //go back to previous activity
                AllCategories.super.onBackPressed();
                break;

            case R.id.change_language:
                //navigate to LanguageActivity
                startActivity(new Intent(getApplicationContext(), LanguageActivity.class));
                break;

            case R.id.expand_web_dev:
                //navigate to lecture activity
                startActivity(new Intent(getApplicationContext(), WebDevelopmentActivity.class));
                break;
        }
    }
}