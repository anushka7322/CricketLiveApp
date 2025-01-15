package com.example.cricketliveapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.cricketliveapp.CardAdaptor;
import com.example.cricketliveapp.R;

public class CardFragment extends Fragment {
    private CardView cardView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstances) {
        View view = inflater.inflate(R.layout.carousel_main, container, false);
        cardView = (CardView) view.findViewById(R.id.carousel_cardview);

        cardView.setMaxCardElevation(cardView.getCardElevation()* CardAdaptor.MAX_ELEVATION_FACTOR);

        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}
