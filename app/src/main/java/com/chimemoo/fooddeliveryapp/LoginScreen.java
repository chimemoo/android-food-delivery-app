package com.chimemoo.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.chimemoo.fooddeliveryapp.adapter.AuthAdapter;
import com.google.android.material.tabs.TabLayout;

public class LoginScreen extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        tabLayout = findViewById(R.id.tl_login);
        viewPager = findViewById(R.id.vp_login);

        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("Sign-up"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final AuthAdapter authAdapter = new AuthAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(authAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
