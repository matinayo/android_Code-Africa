package com.adu.codeafrica.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.adu.codeafrica.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.adu.codeafrica.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.adu.codeafrica.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FeaturedAdapter.FeaturedCallBack {

    //Variables
    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, topRatedRecycler, categoryRecycler;
    RecyclerView.Adapter adapter, topAdapter, catAdapter;
    ImageView menuIcon, changeLanguage;
    ConstraintLayout contentView;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove top status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        topRatedRecycler = findViewById(R.id.top_rated_recycler);
        categoryRecycler = findViewById(R.id.category_recycler);

        menuIcon = findViewById(R.id.menu_icon);
        changeLanguage = findViewById(R.id.change_language);
        contentView = findViewById(R.id.content);

        //menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        //Navigation Drawer
        navigationDrawer();

        //Recycler View Function Call
        featuredRecycler();
        topRatedRecycler();
        categoryRecycler();

        //set onClick Listener
        changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navigate to LanguageActivity
                startActivity(new Intent(getApplicationContext(), LanguageActivity.class));
            }
        });
    }

    //Navigation Drawer Functions
    private void navigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimaryDark));
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open/ close navigation drawer
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //set animation
        animateNavigationDrawer();
    }

    //animate navigation drawer
    private void animateNavigationDrawer() {

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                //TextTranslate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    //close navigation drawer when back button is pressed
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //navigate to various activities
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                //navigate to UserDashboard
                startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                break;

            case R.id.nav_all_categories:
                //navigate to AllCategories
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
                break;

            case R.id.nav_take_quiz:
                //navigate to QuizActivity
                startActivity(new Intent(getApplicationContext(), QuizActivity.class));
                break;

            case R.id.nav_select_language:
                //navigate to LanguageActivity
                startActivity(new Intent(getApplicationContext(), LanguageActivity.class));
                break;
        }
        return true;
    }

    //RecyclerView Functions
    //featured RecyclerView
    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        //set layout
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //values for featured_card_design
        ArrayList<FeaturedHelperClass> featuredCourses = new ArrayList<>();
        featuredCourses.add(new FeaturedHelperClass(R.drawable.software_image, 4.5f, "HTML"));
        featuredCourses.add(new FeaturedHelperClass(R.drawable.software_image, 4.0f, "CSS"));
        featuredCourses.add(new FeaturedHelperClass(R.drawable.javascript_image, 4.7f, "JAVASCRIPT"));

        //featured_card_design adapter
        adapter = new FeaturedAdapter(featuredCourses, 0, this);
        featuredRecycler.setAdapter(adapter);

    }

    //topRated RecyclerView
    private void topRatedRecycler() {

        topRatedRecycler.setHasFixedSize(true);
        //set layout
        topRatedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //values for top_rated_card_design
        ArrayList<FeaturedHelperClass> topRated = new ArrayList<>();
        topRated.add(new FeaturedHelperClass(R.drawable.javascript_image, "JAVASCRIPT", 4.7f));
        topRated.add(new FeaturedHelperClass(R.drawable.software_image, "HTML", 4.5f));
        topRated.add(new FeaturedHelperClass(R.drawable.javascript_image, "CSS", 4.0f));

        topAdapter = new FeaturedAdapter(topRated, 1, this);
        topRatedRecycler.setAdapter(topAdapter);
    }

    //category RecyclerView
    private void categoryRecycler() {

        categoryRecycler.setHasFixedSize(true);
        //set layout
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //values for categories_card_design
        ArrayList<FeaturedHelperClass> categories = new ArrayList<>();
        categories.add(new FeaturedHelperClass(R.drawable.software_image, "WEB DEVELOPMENT"));
        categories.add(new FeaturedHelperClass(R.drawable.javascript_image, "MOBILE DEVELOPMENT"));
        categories.add(new FeaturedHelperClass(R.drawable.javascript_image, "JAVA PROGRAMMING"));
        categories.add(new FeaturedHelperClass(R.drawable.javascript_image, "ARTIFICIAL INTELLIGENCE"));

        catAdapter = new FeaturedAdapter(categories, 2, this);
        categoryRecycler.setAdapter(catAdapter);
    }

    @Override
    public void callBack(int pos) {
        //startActivity(new Intent(getApplicationContext(), WebDevelopmentActivity.class));
    }
}