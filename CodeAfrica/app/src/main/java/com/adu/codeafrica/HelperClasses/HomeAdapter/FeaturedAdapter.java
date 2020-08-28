package com.adu.codeafrica.HelperClasses.HomeAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.adu.codeafrica.R;
import com.adu.codeafrica.User.AllCategories;
import com.adu.codeafrica.User.WebDevelopmentActivity;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> implements View.OnClickListener {

    ArrayList<FeaturedHelperClass> featuredCourses;
    FeaturedCallBack featuredCallBack;
    int card_design;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredCourses, int card_design, FeaturedCallBack featuredCallBack) {
        this.featuredCourses = featuredCourses;
        this.card_design = card_design;
        this.featuredCallBack = featuredCallBack;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;

        if (card_design == 0) {
            view = inflater.inflate(R.layout.featured_card_design, parent, false);
            return new FeaturedViewHolder(view);
        } else if (card_design == 1) {
            view = inflater.inflate(R.layout.top_rated_card_design, parent, false);
            return new FeaturedViewHolder(view);
        } else if (card_design == 2) {
            view = inflater.inflate(R.layout.categories_card_design, parent, false);
            return new FeaturedViewHolder(view);
        } else if (card_design == 3) {
            view = inflater.inflate(R.layout.lesson_card_design, parent, false);
            return new FeaturedViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredCourses.get(position);

        if (card_design == 0) {
            //initialize featured_card_design
            holder.image.setImageResource(featuredHelperClass.getImage());
            holder.title.setText(featuredHelperClass.getTitle());
            holder.rating.setRating(featuredHelperClass.getRating());

            //navigate to WebDevelopment Activity
            holder.image.setOnClickListener(this);
        }
        if (card_design == 1) {
            //initialize top_rated_card_design
            holder.tr_image.setImageResource(featuredHelperClass.getTr_image());
            holder.tr_title.setText(featuredHelperClass.getTr_title());
            holder.tr_rating.setRating(featuredHelperClass.getTr_rating());

            //navigate to AllCategories Activity
            holder.tr_image.setOnClickListener(this);
        }
        if (card_design == 2) {
            //initialize categories_card_design
            holder.ct_image.setImageResource(featuredHelperClass.getCt_image());
            holder.ct_title.setText(featuredHelperClass.getCt_title());

            //navigate to AllCategories Activity
            holder.ct_image.setOnClickListener(this);
        }
        if (card_design == 3) {
            //initialize lesson_card_design
            holder.lesson_card.setCardBackgroundColor(featuredHelperClass.getCard_color());
            holder.lesson_text.setText(featuredHelperClass.getLesson_text());
            holder.lesson_content.setText(featuredHelperClass.getLesson_content());
        }

    }

    @Override
    public int getItemCount() {
        return featuredCourses.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.featured_image:
                //navigate to WebDevelopment Activity

            case R.id.tr_image:
                //navigate to AllCategories Activity
                view.getContext().startActivity(new Intent(view.getContext(), AllCategories.class));
                break;

            case R.id.ct_image:
                //navigate to AllCategories Activity
                view.getContext().startActivity(new Intent(view.getContext(), WebDevelopmentActivity.class));
                break;
        }
    }

    public class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image, tr_image, ct_image;
        TextView title, tr_title, ct_title, lesson_text, lesson_content;
        RatingBar rating, tr_rating;
        CardView lesson_card;

        public FeaturedViewHolder(@NonNull final View itemView) {
            super(itemView);

            //hooks for featured_card_design
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            rating = itemView.findViewById(R.id.featured_rating);

            //hooks for top_rated_card_design
            tr_image = itemView.findViewById(R.id.tr_image);
            tr_title = itemView.findViewById(R.id.tr_title);
            tr_rating = itemView.findViewById(R.id.tr_rating);

            //hooks for categories_card_design
            ct_image = itemView.findViewById(R.id.ct_image);
            ct_title = itemView.findViewById(R.id.ct_title);

            //hooks for lesson_card_design
            lesson_text = itemView.findViewById(R.id.lesson_text);
            lesson_card = itemView.findViewById(R.id.lesson_card);
            lesson_content = itemView.findViewById(R.id.lesson_content);
        }

        @Override
        public void onClick(View view) {
            featuredCallBack.callBack(getAdapterPosition());
        }
    }

    public interface FeaturedCallBack {
        void callBack(int pos);
    }
}
