package com.example.bookland.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bookland.Fragments.download_fragment;
import com.example.bookland.Fragments.favorite_fragment;
import com.example.bookland.Fragments.home_fragment;
import com.example.bookland.Fragments.profile_fragment;
import com.example.bookland.Fragments.publish_fragment;
import com.example.bookland.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottomnevigation_activity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnevigationl_layout);
        bottomNavigation = findViewById(R.id.bottomnevigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, new home_fragment());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.home) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, new home_fragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Home");
        }
        if (menuItem.getItemId() == R.id.downloads) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, new download_fragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Downloads");
        }

        if (menuItem.getItemId() == R.id.favorite) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, new favorite_fragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Favorite");
        }
        if (menuItem.getItemId() == R.id.userprofile) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame, new profile_fragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Profile");
        }



            return false;
        }
    }