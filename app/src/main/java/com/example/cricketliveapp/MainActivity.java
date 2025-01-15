package com.example.cricketliveapp;

import android.os.Bundle;

import com.example.cricketliveapp.Adaptors.PagerAdaptor;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.cricketliveapp.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout_main;
    private ViewPager2 viewpage_main;
    private PagerAdaptor pagerAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout_main = findViewById(R.id.tab_main_layout);
        viewpage_main = findViewById(R.id.view_main_pagger);

        FragmentManager fragmentManager = getSupportFragmentManager();
        pagerAdaptor = new PagerAdaptor(fragmentManager, getLifecycle());
        viewpage_main.setAdapter(pagerAdaptor);

        tabLayout_main.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpage_main.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpage_main.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout_main.selectTab(tabLayout_main.getTabAt(position));
            }
        });

        new TabLayoutMediator(tabLayout_main, viewpage_main, (tab, position) -> {
            if(position == 0) {
                tab.setText("Home");
            } else {
                tab.setText("Live");
            }
        }).attach();
    }

}