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

    TabLayout tabLayout_main;
    ViewPager2 viewpage_main;
    FragmentManager fragmentManager;
    PagerAdaptor pagerAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "MainActivity onCreate");

        tabLayout_main = findViewById(R.id.tab_main_layout);
        viewpage_main = findViewById(R.id.view_main_pagger);
        fragmentManager = getSupportFragmentManager();
        pagerAdaptor = new PagerAdaptor(fragmentManager, getLifecycle());

        viewpage_main.setAdapter(pagerAdaptor);

        new TabLayoutMediator(tabLayout_main, viewpage_main, (tab, position) -> {
            if(position == 0) {
                tab.setText("Home");
            } else {
                tab.setText("Live");
            }
        }).attach();
    }

}