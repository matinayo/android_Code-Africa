package com.adu.codeafrica.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.adu.codeafrica.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class LanguageActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView backButton, skipPressed;
    TextView selectEn, selectHa, selectIb, selectYo;
    RelativeLayout layoutEn, layoutHa, layoutIb, layoutYo;
    String lang = "en";    //default language is English

    //sharedPreference for saving selected language
    SharedPreferences languagePreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove top status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_language);

        languagePreference = getApplicationContext().getSharedPreferences("com.adu.codeafrica.User", MODE_PRIVATE);

        lang = languagePreference.getString("lang", "en");

        //Hooks
        backButton = findViewById(R.id.back_pressed);
        skipPressed = findViewById(R.id.skip_pressed);
        selectEn = findViewById(R.id.select_en);
        selectHa = findViewById(R.id.select_ha);
        selectIb = findViewById(R.id.select_ib);
        selectYo = findViewById(R.id.select_yo);
        layoutEn = findViewById(R.id.en_layout);
        layoutHa = findViewById(R.id.ha_layout);
        layoutIb = findViewById(R.id.ib_layout);
        layoutYo = findViewById(R.id.yo_layout);


        //set selectedIcon
        assert lang != null;
        switch (lang) {
            case "en":
                setEnglishVisible();
                break;
            case "ha":
                setHausaVisible();
                break;
            case "yo":
                setYorubaVisible();
                break;
            case "ib":
                setIgboVisible();
                break;
        }

        //set onclick listener for items
        layoutEn.setOnClickListener(this);
        layoutHa.setOnClickListener(this);
        layoutIb.setOnClickListener(this);
        layoutYo.setOnClickListener(this);

        backButton.setOnClickListener(this);
        skipPressed.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_pressed:
                //go to previous activity
                LanguageActivity.super.onBackPressed();
                break;

            case R.id.skip_pressed:
                //navigate to WebDevelopment Activity
                startActivity(new Intent(getApplicationContext(), WebDevelopmentActivity.class));
                break;

            case R.id.en_layout:
                //set iconText to visible and make others invisible
                setEnglishVisible();
                lang = "en";    //set language to English
                Snackbar.make(view, "Language set to English", BaseTransientBottomBar.LENGTH_SHORT).show();
                languagePreference.edit().putString("lang", lang).apply();
                break;

            case R.id.ha_layout:
                //set iconText to visible and make others invisible
                setHausaVisible();
                lang = "ha";    //set language to Hausa
                Snackbar.make(view, "Language set to Hausa", BaseTransientBottomBar.LENGTH_SHORT).show();
                //save selected language in languagePreference
                languagePreference.edit().putString("lang", lang).apply();
                break;

            case R.id.yo_layout:
                //set iconText to visible and make others invisible
                setYorubaVisible();
                lang = "yo";    //set language to Yoruba
                Snackbar.make(view, "Language set to Yoruba", BaseTransientBottomBar.LENGTH_SHORT).show();
                //save selected language in languagePreference
                languagePreference.edit().putString("lang", lang).apply();
                break;

            case R.id.ib_layout:
                //set iconText to visible and make others invisible
                setIgboVisible();
                lang = "ib";    //set language to Igbo
                Snackbar.make(view, "Language set to Igbo", BaseTransientBottomBar.LENGTH_SHORT).show();
                //save selected language in languagePreference
                languagePreference.edit().putString("lang", lang).apply();
                break;
        }
    }

    //set Igbo selectIcon to visible
    private void setIgboVisible() {
        selectEn.setVisibility(View.INVISIBLE);
        selectHa.setVisibility(View.INVISIBLE);
        selectYo.setVisibility(View.INVISIBLE);
        selectIb.setVisibility(View.VISIBLE);
    }

    //set Yoruba selectIcon to visible
    private void setYorubaVisible() {
        selectEn.setVisibility(View.INVISIBLE);
        selectHa.setVisibility(View.INVISIBLE);
        selectYo.setVisibility(View.VISIBLE);
        selectIb.setVisibility(View.INVISIBLE);
    }

    //set Hausa selectIcon to visible
    private void setHausaVisible() {
        selectEn.setVisibility(View.INVISIBLE);
        selectHa.setVisibility(View.VISIBLE);
        selectYo.setVisibility(View.INVISIBLE);
        selectIb.setVisibility(View.INVISIBLE);
    }

    //set English selectIcon to visible
    private void setEnglishVisible() {
        selectEn.setVisibility(View.VISIBLE);
        selectHa.setVisibility(View.INVISIBLE);
        selectYo.setVisibility(View.INVISIBLE);
        selectIb.setVisibility(View.INVISIBLE);
    }
}
