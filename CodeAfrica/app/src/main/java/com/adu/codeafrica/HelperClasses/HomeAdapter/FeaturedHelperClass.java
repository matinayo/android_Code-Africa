package com.adu.codeafrica.HelperClasses.HomeAdapter;


public class FeaturedHelperClass {

    private int image, tr_image, ct_image, card_color;
    private float rating, tr_rating;
    private String title, tr_title, ct_title, lesson_text, lesson_content;

    //constructor to set featured_card_design
    public FeaturedHelperClass(int image, float rating, String title) {
        this.image = image;
        this.rating = rating;
        this.title = title;
    }

    //constructor to set top_rated_card_design
    public FeaturedHelperClass(int tr_image, String tr_title, float tr_rating) {
        this.tr_image = tr_image;
        this.tr_rating = tr_rating;
        this.tr_title = tr_title;
    }

    //constructor to set categories_card_design
    public FeaturedHelperClass(int ct_image, String ct_title) {
        this.ct_image = ct_image;
        this.ct_title = ct_title;
    }

    //constructor to set lesson_card_design
    public FeaturedHelperClass(String lesson_text, int card_color, String lesson_content) {
        this.lesson_text = lesson_text;
        this.card_color = card_color;
        this.lesson_content = lesson_content;
    }


    //getters
    public int getImage() {
        return image;
    }

    public float getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public int getTr_image() {
        return tr_image;
    }

    public float getTr_rating() {
        return tr_rating;
    }

    public String getTr_title() {
        return tr_title;
    }

    public int getCt_image() {
        return ct_image;
    }

    public String getCt_title() {
        return ct_title;
    }

    public String getLesson_text() {
        return lesson_text;
    }

    public String getLesson_content() {
        return lesson_content;
    }

    public int getCard_color() {
        return card_color;
    }
}
