package com.adu.codeafrica.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adu.codeafrica.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.adu.codeafrica.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.adu.codeafrica.R;

import java.util.ArrayList;

public class LearnActivity extends AppCompatActivity implements FeaturedAdapter.FeaturedCallBack, View.OnClickListener {

    //variables
    TextView learnTitle, takeQuiz;
    ImageView learnImage, backButton;
    RecyclerView lessonRecycler;
    RecyclerView.Adapter adapter;
    String title = "";
    String lang = "en"; //Set default language to English

    //sharedPreference for selected language
    SharedPreferences languagePreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove top status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_learn);

        languagePreference = getApplicationContext().getSharedPreferences("com.adu.codeafrica.User", MODE_PRIVATE);
        lang = languagePreference.getString("lang", "en"); //English default language

        //Hooks
        backButton = findViewById(R.id.back_pressed);
        takeQuiz = findViewById(R.id.take_quiz);
        learnTitle = findViewById(R.id.learn_title);
        learnImage = findViewById(R.id.learn_img);
        lessonRecycler = findViewById(R.id.lesson_recycler);

        title = getIntent().getStringExtra("title");
        learnTitle.setText(title);

        //back button Pressed
        backButton.setOnClickListener(this);
        //navigate to Quiz Activity
        takeQuiz.setOnClickListener(this);

        //implement recyclerView
        lessonRecycler();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_pressed:
                //go back to previous activity
                LearnActivity.super.onBackPressed();
                break;

            case R.id.take_quiz:
                //navigate to QuizActivity
                startActivity(new Intent(getApplicationContext(), QuizActivity.class));
                break;
        }
    }

    private void lessonRecycler() {
        lessonRecycler.setHasFixedSize(true);
        //set layout
        lessonRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //values for featured_card_design
        ArrayList<FeaturedHelperClass> featuredCourses = new ArrayList<>();

        if (title.equals("HTML")) {
            switch (lang) {
                case "en":
                    //display HTML Contents in English
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.en_html_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.en_html_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.en_html_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.en_html_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.en_html_lesson_five)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 6", getResources().getColor(R.color.card1), getResources().getString(R.string.en_html_lesson_six)));
                    break;
                case "ha":
                    //display HTML Contents in Hausa
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ha_html_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.ha_html_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.ha_html_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.ha_html_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ha_html_lesson_five)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 6", getResources().getColor(R.color.card1), getResources().getString(R.string.ha_html_lesson_six)));
                    break;
                case "yo":
                    //display HTML Contents in Yoruba
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.yo_html_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.yo_html_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.yo_html_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.yo_html_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.yo_html_lesson_five)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 6", getResources().getColor(R.color.card1), getResources().getString(R.string.yo_html_lesson_six)));
                    break;
                case "ib":
                    //display HTML Contents in Igbo
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ib_html_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.ib_html_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.ib_html_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.ib_html_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ib_html_lesson_five)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 6", getResources().getColor(R.color.card1), getResources().getString(R.string.ib_html_lesson_six)));
                    break;
            }
        } else if (title.equals("CSS")) {
            switch (lang) {
                case "en":
                    //display CSS Contents in English
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.en_css_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.en_css_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.en_css_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.en_css_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.en_css_lesson_five)));
                    break;
                case "ha":
                    //display CSS Contents in Hausa
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ha_css_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.ha_css_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.ha_css_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.ha_css_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ha_css_lesson_five)));
                    break;
                case "yo":
                    //display CSS Contents in Yoruba
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.yo_css_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.yo_css_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.yo_css_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.yo_css_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.yo_css_lesson_five)));
                    break;
                case "ib":
                    //display CSS Contents in Igbo
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ib_css_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.ib_css_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.ib_css_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.ib_css_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ib_css_lesson_five)));
                    break;
            }
        }else if (title.equals("JAVASCRIPT")) {
            switch (lang) {
                case "en":
                    //display JavaScript Contents in English
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.en_js_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.en_js_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.en_js_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.en_js_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.en_js_lesson_five)));
                    break;
                case "ha":
                    //display JavaScript Contents in Hausa
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ha_js_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.ha_js_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.ha_js_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.ha_js_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ha_js_lesson_five)));
                    break;
                case "yo":
                    //display JavaScript Contents in Yoruba
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.yo_js_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.yo_js_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.yo_js_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.yo_js_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.yo_js_lesson_five)));
                    break;
                case "ib":
                    //display JavaScript Contents in Igbo
                    featuredCourses.add(new FeaturedHelperClass("Lesson 1", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ib_js_lesson_one)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 2", getResources().getColor(R.color.colorPrimary), getResources().getString(R.string.ib_js_lesson_two)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 3", getResources().getColor(R.color.card3), getResources().getString(R.string.ib_js_lesson_three)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 4", getResources().getColor(R.color.card4), getResources().getString(R.string.ib_js_lesson_four)));
                    featuredCourses.add(new FeaturedHelperClass("Lesson 5", getResources().getColor(R.color.colorPrimaryDark), getResources().getString(R.string.ib_js_lesson_five)));
                    break;
            }
        }

        //featured_card_design adapter
        adapter = new FeaturedAdapter(featuredCourses, 3, this);
        lessonRecycler.setAdapter(adapter);
    }

    @Override
    public void callBack(int pos) {

    }

}