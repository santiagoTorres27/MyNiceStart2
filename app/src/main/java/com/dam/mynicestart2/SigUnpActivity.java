package com.dam.mynicestart2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class SigUnpActivity extends AppCompatActivity {

    Button btnCancel;
    Button btnsignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnsignUp = (Button) findViewById(R.id.btnsignUp);

        Animation animLeft = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        Animation animRight = AnimationUtils.loadAnimation(this, R.anim.anim_right);

        btnCancel.startAnimation(animLeft);
        btnsignUp.startAnimation(animRight);
    }

    public void regresar (View view) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

    public void mover (View view) {
        Intent login = new Intent(this, MainActivity.class);
        startActivity(login);
    }
}