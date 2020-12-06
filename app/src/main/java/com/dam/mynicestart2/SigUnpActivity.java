package com.dam.mynicestart2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Ventana de SignUp.
 * Cuatro EditText donde el usuario podrá ingresar su nombre, email y password.
 * Un ButtonOutlined de Cancelar.
 * Un ButtonStraight de SignUp que registra al usuario y lo redirecciona al MainActivity.
 * @author Santiago Torres
 * @see MainActivity
 */

public class SigUnpActivity extends AppCompatActivity {

    ImageView bg;
    Button btnCancel;
    Button btnsignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bg = (ImageView) findViewById(R.id.bg);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnsignUp = (Button) findViewById(R.id.btnsignUp);

        // Animations
        Animation animLeft = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        Animation animRight = AnimationUtils.loadAnimation(this, R.anim.anim_right);
        btnCancel.startAnimation(animLeft);
        btnsignUp.startAnimation(animRight);

        // Glide
        Glide.with(this)
                .load(R.drawable.bg)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(200))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
//                .placeholder(R.drawable.bg2)
                .into(bg);
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