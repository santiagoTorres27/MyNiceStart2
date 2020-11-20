package com.dam.mynicestart2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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