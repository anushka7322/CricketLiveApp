package com.example.cricketliveapp;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cricketliveapp.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView logo, logo_bg, ball;
    Animation rotation, rotate;
    ObjectAnimator objectAnimator, alphaanimationball, alpahaanimationlogo_bg, alphaanimationlogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ball = findViewById(R.id.ball);
        logo_bg = findViewById(R.id.logo_bg);
        logo = findViewById(R.id.logo);

//        logo_bg.setBackgroundResource(R.drawable.gradientopacity);

        float centerX = -110;
        float centerY = -110;
        float radius = 150;

        Path path = new Path();
        path.addCircle(centerX, centerY, radius, Path.Direction.CCW);

        objectAnimator = ObjectAnimator.ofFloat(ball, "translationX", "translationY", path);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.setRepeatMode(ObjectAnimator.RESTART);

        objectAnimator.start();

        alphaanimationball = ObjectAnimator.ofFloat(ball, "alpha", 1f, 0f);
        alphaanimationball.setDuration(2700);
        alphaanimationball.start();

        alpahaanimationlogo_bg = ObjectAnimator.ofFloat(logo_bg, "alpha", 1f, 0f);
        alpahaanimationlogo_bg.setDuration(3000);
        alpahaanimationlogo_bg.start();

        alphaanimationlogo = ObjectAnimator.ofFloat(logo,  "alpha", 0f, 1f);
        alphaanimationlogo.setDuration(5000);
        alphaanimationlogo.start();

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 20000);
    }
}