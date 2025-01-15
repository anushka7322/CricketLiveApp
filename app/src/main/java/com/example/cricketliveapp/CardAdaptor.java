package com.example.cricketliveapp;

import androidx.cardview.widget.CardView;

public interface CardAdaptor {
    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardView(int position);

    int getCount();
}
