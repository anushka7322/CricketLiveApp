package com.example.cricketliveapp.Adaptors;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cricketliveapp.CardItem;
import com.example.cricketliveapp.R;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdaptor extends PagerAdapter implements CardAdaptor {
    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;

    public CardPagerAdaptor() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
        Log.d("test", "item created");
        Log.d("MyTag", "List contents: " + mData.toString());
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.carousel_main, container, false);
        container.addView(view);

        bind(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.carousel_cardview);

        if(mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation*MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItem item, View view) {
        TextView matchTitle = (TextView) view.findViewById(R.id.match_title);
        TextView matchDate = (TextView) view.findViewById(R.id.match_date);
        TextView matchTime = (TextView) view.findViewById(R.id.match_time);
        ImageView team1Image = (ImageView) view.findViewById(R.id.first_team_flag);
        TextView team1Name = (TextView) view.findViewById(R.id.first_team_name);
        TextView team1Score = (TextView) view.findViewById(R.id.first_team_score);
        TextView team1Over = (TextView) view.findViewById(R.id.firts_team_overs);
        ImageView team2Image = (ImageView) view.findViewById(R.id.second_team_flag);
        TextView team2Name = (TextView) view.findViewById(R.id.second_team_name);
        TextView team2Score = (TextView) view.findViewById(R.id.second_team_score);
        TextView team2Over = (TextView) view.findViewById(R.id.second_team_overs);
        TextView matchMessage = (TextView) view.findViewById(R.id.match_message);

        matchTitle.setText(item.getMatchTitle());
        matchDate.setText(item.getMatchDate());
        matchTime.setText(item.getMatchTime());
        team1Image.setImageResource(item.getTeam1Flag());
        team1Name.setText(item.getTeam1Name());
        team1Score.setText(item.getTeam1Score());
        team1Over.setText(item.getTeam1Over());
        team2Image.setImageResource(item.getTeam2Flag());
        team2Name.setText(item.getTeam2Name());
        team2Score.setText(item.getTeam2Score());
        team2Over.setText(item.getTeam2Over());
        matchMessage.setText(item.getMatchMessage());
    }

}


