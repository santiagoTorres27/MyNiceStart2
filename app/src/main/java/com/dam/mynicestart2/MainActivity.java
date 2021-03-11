package com.dam.mynicestart2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

/**
 * Ventana MainActivity.
 * Tiene un ImageView con una foto de perfil de un usuario.
 * Un ButtonStraight que redirecciona a su activity hijo (MainActivity2).
 * Un menú contextual, AppBar, BottomBar, SwipeRefreshLayout con Snackbar, Alert/Modal Dialog, Expandable CardView
 *
 * @author Santiago Torres
 * @see MainActivity2
 */

public class MainActivity extends AppCompatActivity {

    ImageView imgProfile;
    SwipeRefreshLayout swipeLayout;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setTitle(Html.fromHtml("<font color='#ff0000'>ActionBarTitle </font>"));

        navigationView = findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(navListener);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        registerForContextMenu(imgProfile);

        // Swip Layout
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        String url = "https://images.unsplash.com/photo-1603755043619-9b94c368f4db?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80";

        Glide.with(this)
                .load(url)
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
//                .placeholder(R.drawable.bg2)
                .into(imgProfile);

        // Expandable view
        ExpandableCardView card = findViewById(R.id.profile);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" :
                        "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.bottomBookmark) {
                Toast.makeText(MainActivity.this, "Bookmark", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.bottomSearch) {
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.bottomShare) {
                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            final ConstraintLayout mLayout = findViewById(R.id.activity_main_context);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);
        }
    };

    public void mover(View view) {
        Intent next = new Intent(this, MainActivity2.class);
        startActivity(next);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                Toast toast = Toast.makeText(this, "going CONTEXT CAMERA", Toast.LENGTH_SHORT);
                toast.show();
                break;

            case R.id.delete:
                Toast toast2 = Toast.makeText(this, "going CONTEXT SETTINGS", Toast.LENGTH_SHORT);
                toast2.show();
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.camera) {
            Toast toast = Toast.makeText(this, "Opening alert dialog", Toast.LENGTH_SHORT);
            toast.show();

            showAlertDialogButtonClicked(MainActivity.this);
        }
        return super.onOptionsItemSelected(item);
    }

    // *** DIALOGO MODAL ***
    public void showAlertDialogButtonClicked(MainActivity view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
//        builder.setTitle("Achtung!");
//        builder.setMessage("Where do you go?");
//        builder.setIcon(R.drawable.ic_action_name_dark);
//        un XML a medida para el diálogo

        builder.setView(getLayoutInflater().inflate(R.layout.alert_dialog_view,
                null));

        // add the buttons
        builder.setPositiveButton("Glide", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("ChatBot", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });

        builder.setNeutralButton("MotionLayout", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
