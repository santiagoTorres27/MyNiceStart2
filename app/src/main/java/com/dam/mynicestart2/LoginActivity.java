package com.dam.mynicestart2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Ventana de Login de la aplicación.
 * En la parte superior se encuentra el logo de la aplicación.
 * Dos EditText para que el usuario ingrese su nombre y password.
 * Un ButtonOutlined para Cancelar.
 * Un ButtonStraight de Login.
 * Un TextView que redirecciona al Activity de SignUp.
 *
 * @author Santiago Torres
 * @see SigUnpActivity
 */

public class LoginActivity extends AppCompatActivity {

    ImageView logo;
    ImageView bg;
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
        bg = (ImageView) findViewById(R.id.bg);
        username = (TextInputLayout) findViewById(R.id.username);
        password = (TextInputLayout) findViewById(R.id.password);
        btnCancel = (MaterialButton) findViewById(R.id.btnCancel);
        btnLogin = (MaterialButton) findViewById(R.id.btnLogin);
        txtRegistro = (TextView) findViewById(R.id.txtRegistro);

        // Animations
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fade_in3);
        logo.startAnimation(myanim);
        username.startAnimation(myanim);
        password.startAnimation(myanim);
        btnCancel.startAnimation(myanim);
        btnLogin.startAnimation(myanim);
        txtRegistro.startAnimation(myanim);

        // Glide
        Glide.with(this)
                .load(R.drawable.bg)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(200))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
//                .placeholder(R.drawable.bg2)
                .into(bg);

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