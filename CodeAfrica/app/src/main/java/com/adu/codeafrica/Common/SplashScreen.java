package com.adu.codeafrica.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.adu.codeafrica.R;
import com.adu.codeafrica.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    public static int SPLASH_TIMER = 5000;

    TextView appName;
    ImageView appLogo;
    SharedPreferences sharedPreferences;

    //Animations
    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //remove top status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //hooks
        appName = findViewById(R.id.app_name);
        appLogo = findViewById(R.id.logo_image);

        //Animations
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //set animations
        appLogo.setAnimation(sideAnim);
        appName.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedPreferences = getSharedPreferences("com.adu.codeafrica", MODE_PRIVATE);
                boolean isFirstTime = sharedPreferences.getBoolean("firstTime", true);

                //prevents coming back to SplashScreen
                if (isFirstTime) {
                    sharedPreferences.edit().putBoolean("firstTime", false).apply();

                    //navigate to activity_user_dashboard
                    Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                    startActivity(intent);
                }
                finish();   //prevents coming back to SplashScreen

            }
        }, SPLASH_TIMER);

    }
}