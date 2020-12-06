package com.dam.mynicestart2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Ventana MainActivity.
 * Tiene un ImageView con una foto de perfil de un usuario.
 * Un ButtonStraight que redirecciona a su activity hijo (MainActivity2).
 * @author Santiago Torres
 * @see MainActivity2
 */

public class MainActivity extends AppCompatActivity {

    ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgProfile = (ImageView) findViewById(R.id.imgProfile);

        String url = "https://images.unsplash.com/photo-1603755043619-9b94c368f4db?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80";

        Glide.with(this)
                .load(url)
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
//                .placeholder(R.drawable.bg2)
                .into(imgProfile);
    }

    public void mover(View view) {
        Intent next = new Intent(this, MainActivity2.class);
        startActivity(next);
    }
}