package com.dam.mynicestart2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Ventana de Login con un usuario y contraseña y registro
 * @author Santiago Torres
 * @see SigUnpActivity
 */

public class LoginActivity extends AppCompatActivity {

    ImageView logo;
    TextInputLayout username;
    TextInputLayout password;
    MaterialButton btnCancel;
    MaterialButton btnLogin;
    TextView txtRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logo = (ImageView) findViewById(R.id.logo);
        username = (TextInputLayout) findViewById(R.id.username);
        password = (TextInputLayout) findViewById(R.id.password);
        btnCancel = (MaterialButton) findViewById(R.id.btnCancel);
        btnLogin = (MaterialButton) findViewById(R.id.btnLogin);
        txtRegistro = (TextView) findViewById(R.id.txtRegistro);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fade_in3);

        logo.startAnimation(myanim);
        username.startAnimation(myanim);
        password.startAnimation(myanim);
        btnCancel.startAnimation(myanim);
        btnLogin.startAnimation(myanim);
        txtRegistro.startAnimation(myanim);
    }

    public void register(View view) {
        Intent next = new Intent(this, SigUnpActivity.class);
        startActivity(next);
    }

    public void mover(View view) {
        Intent next = new Intent(this, MainActivity.class);
        next.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(next);
    }
}