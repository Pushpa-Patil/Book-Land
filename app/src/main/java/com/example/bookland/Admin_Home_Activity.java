package com.example.bookland;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;

import com.example.bookland.Fragments.admin_profile_fragment;
import com.example.bookland.Fragments.home_fragment;
import com.example.bookland.Fragments.admin_profile_fragment;
import com.example.bookland.Fragments.publish_fragment;
import com.example.bookland.Fragments.ratting_fragment;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.widget.TextView;
import android.widget.Toast;

public class Admin_Home_Activity extends AppCompatActivity implements View.OnClickListener {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__home_);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setUpNavigationView();
        FragmentManager fragmentManager2=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction2=fragmentManager2.beginTransaction();
        fragmentTransaction2.replace(R.id.nav_host_fragment,new ratting_fragment());
        fragmentTransaction2.commit();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.Profile:
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, new admin_profile_fragment());
                        getSupportActionBar().setTitle("Profile");
                        fragmentTransaction.commit();
                        break;
                    case R.id.Publish:
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.replace(R.id.nav_host_fragment, new publish_fragment());
                        getSupportActionBar().setTitle("Publish");
                        fragmentTransaction1.commit();

                        break;
                    case  R.id.Ratting:
                         FragmentManager fragmentManager2=getSupportFragmentManager();
                         FragmentTransaction fragmentTransaction2=fragmentManager2.beginTransaction();
                         fragmentTransaction2.replace(R.id.nav_host_fragment,new ratting_fragment());
                        getSupportActionBar().setTitle("Ratting");
                         fragmentTransaction2.commit();
                         break;
                }
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return false;
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView)  {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_admin__home__drawer, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {

    }
}