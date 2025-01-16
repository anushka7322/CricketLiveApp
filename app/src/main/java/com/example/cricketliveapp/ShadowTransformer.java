package com.example.cricketliveapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.cricketliveapp.Adaptors.CardAdaptor;
import com.example.cricketliveapp.Adaptors.CardFragmentPagerAdaptor;
import com.example.cricketliveapp.Adaptors.CardPagerAdaptor;

public class ShadowTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer  {
    private final ViewPager viewPager;
    private float LastOffset;
    private boolean ScalingEnabled;
    private final CardPagerAdaptor cardPagerAdaptor;
//    private final CardFragmentPagerAdaptor cardFragmentPagerAdaptor;

    public ShadowTransformer(ViewPager viewPager, CardPagerAdaptor cardPagerAdaptor) {
        this.viewPager = viewPager;
//        this.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                ShadowTransformer.this.onPageScrolled(position, positionOffset, positionOffsetPixels);
//            }
//        });

        this.cardPagerAdaptor = cardPagerAdaptor;
    }

//    public ShadowTransformer(ViewPager viewPager, CardFragmentPagerAdaptor cardFragmentPagerAdaptor) {
//        this.viewPager = viewPager;
//        this.viewPager.addOnPageChangeListener(this);
//        this.cardFragmentPagerAdaptor = cardFragmentPagerAdaptor;
//    }

    public void enableScaling(boolean enable) {
        if(this.ScalingEnabled && !enable) {
            CardView currentCard = this.cardPagerAdaptor.getCardViewAt(this.viewPager.getCurrentItem());
            if(currentCard != null) {
                currentCard.animate().scaleY(1);
                currentCard.animate().scaleX(1);
            }
        } else if(!this.ScalingEnabled && enable) {
            CardView currentCard = this.cardPagerAdaptor.getCardViewAt(this.viewPager.getCurrentItem());

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
        float baseElevation = this.cardPagerAdaptor.getBaseElevation();
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

        if(nextPosition > this.cardPagerAdaptor.getCount() - 1 || realCurrentPosition > this.cardPagerAdaptor.getCount() - 1) {
            return;
        }

        CardView currentCard = this.cardPagerAdaptor.getCardViewAt(realCurrentPosition);

        if(currentCard != null) {
            if(this.ScalingEnabled) {
                currentCard.setScaleX((float) (1 + 0.1 * (1 - realOffset)));
                currentCard.setScaleY((float) (1 + 0.1 * (1 - realOffset)));
            }

            currentCard.setCardElevation((baseElevation + baseElevation * (CardAdaptor.MAX_ELEVATION_FACTOR-1)*(1-realOffset)));
        }

        CardView nextCard = this.cardPagerAdaptor.getCardViewAt(nextPosition);

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
