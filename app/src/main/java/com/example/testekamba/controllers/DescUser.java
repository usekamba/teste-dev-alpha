package com.example.testekamba.controllers;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import android.widget.ProgressBar;
import android.widget.Toolbar;

import com.example.testekamba.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class DescUser extends AppCompatActivity {
    // The singleton HTTP client.
    private ProgressBar progressBar;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private boolean connected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_user);

        tabLayout =findViewById(R.id.idTabLayout);
        viewPager =findViewById(R.id.idViewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 1);

        AddFragment();
    }


    private void AddFragment() {

        viewPagerAdapter.AddFragment(new fragment_home());
        viewPagerAdapter.AddFragment(new fragment_activities());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_notifications);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Objects.requireNonNull(getSupportActionBar()).show();

    }
}