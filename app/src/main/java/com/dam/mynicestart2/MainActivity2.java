package com.dam.mynicestart2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Ventana MainActivity2, hija de MainActivity.
 * Consta de un ImageView con una imagen de ejemplo.
 *
 * @author Santiago Torres
 */

public class MainActivity2 extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img = (ImageView) findViewById(R.id.img);

        String url = "https://images.unsplash.com/photo-1531742896094-1424584e750b?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1870&q=80";

        Glide.with(this)
//                .load(R.drawable.bg2)
                .load(url)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
//                .placeholder(R.drawable.bg2)
                .into(img);

    }
}