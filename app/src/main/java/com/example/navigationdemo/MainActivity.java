package com.example.navigationdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    NavHostFragment navHostFragment;
    BottomNavigationView navigationView;
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        navigationView = findViewById(R.id.bottomNavView);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragNavHost);
        navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

                if (destination.getId() == R.id.homeFragment){

                    String loginStatus = sharedPreferences.getString("login", null);
                    if (loginStatus == null){
                        controller.navigate(R.id.loginFragment);
                        hideBottomNav();
                    }

                    else{
                        showBottomNav();
                    }
                }
            }
        });
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