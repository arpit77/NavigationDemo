package com.example.navigationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    NavHostFragment navHostFragment;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.bottomNavView);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragNavHost);
        navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void showBottomNav(){
        navigationView = findViewById(R.id.bottomNavView);
        navigationView.setVisibility(View.VISIBLE);
    }

    public void hideBottomNav(){

        navigationView.setVisibility(View.GONE);
    }

    private boolean onBackPressed = false;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {

            String data = intent.getStringExtra("data");

            if (data != null) {

                navController.navigate(R.id.notificationDetailFragment);
            }


        }
    }
}