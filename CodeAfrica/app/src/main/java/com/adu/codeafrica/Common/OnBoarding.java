package com.adu.codeafrica.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adu.codeafrica.HelperClasses.SliderAdapter;
import com.adu.codeafrica.R;
import com.adu.codeafrica.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    TextView dots[];
    Button layoutButton;
    Animation animation;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove top status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        //connecting viewPager to SliderAdapter
        //hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        layoutButton = findViewById(R.id.get_started_btn);

        //Adapter
        SliderAdapter sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        //add dots, 0 is default position
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view){
        //start activity
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
        finish();   //destroy activity
    }

    public void next(View view){
        //move to next screen
        viewPager.setCurrentItem(currentPosition + 1);
    }

    public void addDots(int position){
        dots = new TextView[4];
        dotsLayout.removeAllViews();

        currentPosition = position;

        for(int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        //check if dots is present
        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    //change color on dots
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            if(position > 2){
                animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.bottom_anim);
                layoutButton.setAnimation(animation);
                layoutButton.setVisibility(View.VISIBLE);
            }else{
                layoutButton.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}