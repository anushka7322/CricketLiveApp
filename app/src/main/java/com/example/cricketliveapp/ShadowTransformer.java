package com.example.cricketliveapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

public class ShadowTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer,  {
    private ViewPager viewPager;
    private float LastOffset;
    private boolean ScalingEnabled;
    private CardAdaptor cardAdaptor;

    public ShadowTransformer(ViewPager viewPager, CardAdaptor cardAdaptor) {
        this.viewPager = viewPager;
        this.viewPager.addOnPageChangeListener(this);
        this.cardAdaptor = cardAdaptor;
    }

    public void enableScaling(boolean enable) {
        if(this.ScalingEnabled && !enable) {
            CardView currentCard = this.cardAdaptor.getCardView(this.viewPager.getCurrentItem());
            if(currentCard != null) {
                currentCard.animate().scaleY(1);
                currentCard.animate().scaleX(1);
            }
        } else if(!this.ScalingEnabled && enable) {
            CardView currentCard = this.cardAdaptor.getCardView(this.viewPager.getCurrentItem());

            if(currentCard != null) {
                currentCard.animate().scaleY(1.1f);
                currentCard.animate().scaleX(1.1f);
            }
        }

        this.ScalingEnabled = enable;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int realCurrentPosition;
        int nextPosition;
        float baseElevation = this.cardAdaptor.getBaseElevation();
        float realOffset;
        boolean goingLeft = this.LastOffset > positionOffset;

        if(goingLeft) {
            realCurrentPosition = position + 1;
            nextPosition = position;
            realOffset = 1 - positionOffset;
        } else {
            nextPosition = position + 1;
            realCurrentPosition = position;
            realOffset = positionOffset;
        }

        if(nextPosition > this.cardAdaptor.getCount() - 1 || realCurrentPosition > this.cardAdaptor.getCount() - 1) {
            return;
        }

        CardView currentCard = this.cardAdaptor.getCardView(realCurrentPosition);

        if(currentCard != null) {
            if(this.ScalingEnabled) {
                currentCard.setScaleX((float) (1 + 0.1 * (1 - realOffset)));
                currentCard.setScaleY((float) (1 + 0.1 * (1 - realOffset)));
            }

            currentCard.setCardElevation((baseElevation + baseElevation * (CardAdaptor.MAX_ELEVATION_FACTOR-1)*(1-realOffset)));
        }

        CardView nextCard = this.cardAdaptor.getCardView(nextPosition);

        if(nextCard != null) {
            if(this.ScalingEnabled) {
                nextCard.setScaleX((float) (1 + 0.1 * (realOffset)));
                nextCard.setScaleY((float) (1 + 0.1 * (realOffset)));
            }

            nextCard.setCardElevation((baseElevation + baseElevation * (CardAdaptor.MAX_ELEVATION_FACTOR - 1) * realOffset));
        }

        this.LastOffset = positionOffset;
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void transformPage(@NonNull View page, float position) {

    }
}
