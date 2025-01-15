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
        if (position == 1) {
            return new LiveFragment();
        }

        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
