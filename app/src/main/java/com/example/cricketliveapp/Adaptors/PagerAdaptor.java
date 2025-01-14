package com.example.cricketliveapp.Adaptors;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cricketliveapp.Fragments.HomeFragment;
import com.example.cricketliveapp.Fragments.LiveFragment;

public class PagerAdaptor extends FragmentStateAdapter {

    public PagerAdaptor(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0) {
            return new HomeFragment();
        } else {
            return new LiveFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
