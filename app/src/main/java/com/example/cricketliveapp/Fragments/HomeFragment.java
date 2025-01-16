package com.example.cricketliveapp.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.example.cricketliveapp.Adaptors.CardFragmentPagerAdaptor;
import com.example.cricketliveapp.Adaptors.CardPagerAdaptor;
import com.example.cricketliveapp.CardItem;
import com.example.cricketliveapp.R;
import com.example.cricketliveapp.ShadowTransformer;
import java.util.Objects;

public class HomeFragment extends Fragment implements  View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private CardPagerAdaptor cardPagerAdaptor;
    private ShadowTransformer shadowTransformer;
    private ShadowTransformer shadowFragmentTransformer;
    ViewPager viewPager;

    private CardFragmentPagerAdaptor cardFragmentPagerAdaptor;

    private boolean showingFragments = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = rootView.findViewById(R.id.main_carousel_container);
        cardPagerAdaptor = new CardPagerAdaptor();
        for (int i = 0; i < 5; i++) {
            cardPagerAdaptor.addCardItem(new CardItem(
                    "Match " + (i + 1),
                    "Date " + (i + 1),
                    "Time " + (i + 1),
                    "Team 1 " + (i + 1),
                    "100-3",
                    "Team 2 " + (i + 1),
                    "90-5",
                    "15.0",
                    "14.5",
                    "Live match message",
                    R.drawable.sa_flag,
                    R.drawable.second_flag
            ));
        }

        cardFragmentPagerAdaptor = new CardFragmentPagerAdaptor(getChildFragmentManager(), doToPixels(2,requireContext()));

        shadowTransformer = new ShadowTransformer(viewPager, cardPagerAdaptor);
//        shadowFragmentTransformer = new ShadowTransformer(viewPager, cardFragmentPagerAdaptor);
        viewPager.setAdapter(cardPagerAdaptor);
        viewPager.setPageTransformer(false, shadowTransformer);
        viewPager.setOffscreenPageLimit(3);

        return viewPager;
    }

    @Override
    public void onClick(View view) {
        if(!showingFragments) {
            viewPager.setAdapter(cardFragmentPagerAdaptor);
            viewPager.setPageTransformer(false, shadowFragmentTransformer);
        } else {
            viewPager.setAdapter(cardFragmentPagerAdaptor);
            viewPager.setPageTransformer(false, shadowFragmentTransformer);
        }

        showingFragments = !showingFragments;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        shadowTransformer.enableScaling(b);
//        shadowFragmentTransformer.enableScaling(b);
    }

    public static float doToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}