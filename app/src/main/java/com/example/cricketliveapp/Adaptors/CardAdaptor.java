package com.example.cricketliveapp.Adaptors;

import android.view.ViewGroup;

import androidx.cardview.widget.CardView;

public interface CardAdaptor {
    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();

}
