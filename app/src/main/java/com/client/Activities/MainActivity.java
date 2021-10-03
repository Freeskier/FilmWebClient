package com.client.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.client.LocalStorage.Storage;
import com.client.R;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private TextView nameTV, emailTV, typeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        connectViews();
    }

    private void connectViews() {
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(navListener);
        drawerLayout = findViewById(R.id.drawerLayout);
        nameTV = navigationView.getHeaderView(0).findViewById(R.id.nav_nameTitleTV);
        emailTV = navigationView.getHeaderView(0).findViewById(R.id.nav_emailTitleTV);
        typeTV = navigationView.getHeaderView(0).findViewById(R.id.nav_typeTitleTV);

    }


    private NavigationView.OnNavigationItemSelectedListener navListener =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    Intent intent;
                    switch (item.getItemId()) {
                        case R.id.moviesIds:
                            intent = new Intent(getApplicationContext(), MoviesActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.watched_moviesIds:
                            intent = new Intent(getApplicationContext(), WatchedMoviesActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.commentsIds:
                            intent = new Intent(getApplicationContext(), MyCommentsActivity.class);
                            startActivity(intent);
                            break;
                        default:
                            intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            break;
                    }

                    return false;
                }
            };

    public void menuClick(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void logOutButtonClick(View view) {
        Storage.removeUser(this);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}