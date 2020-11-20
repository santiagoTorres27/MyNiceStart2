package com.dam.mynicestart2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView subtitulo;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Implements and starts animation

        logo = (ImageView) findViewById(R.id.logo);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo.startAnimation(myanim);

        subtitulo = (TextView) findViewById(R.id.subtitulo);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        subtitulo.startAnimation(myanim2);

        openApp(true);
    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}