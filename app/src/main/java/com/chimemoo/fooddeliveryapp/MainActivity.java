package com.chimemoo.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;

import com.chimemoo.fooddeliveryapp.adapter.AuthAdapter;
import com.chimemoo.fooddeliveryapp.adapter.MainAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TabLayout tabLayout;
    ViewPager viewPager;

    private static String[] foodTypes = {
            "All",
            "Foods",
            "Drinks",
            "Snacks",
            "Sauces"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tl_main);
        viewPager = findViewById(R.id.vp_main);

        for(int i = 0; i < foodTypes.length; i++){
            tabLayout.addTab(tabLayout.newTab().setText(foodTypes[i]));
        }

        final MainAdapter mainAdapter = new MainAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(mainAdapter);
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.et_search_input_home){
            Intent intent = new Intent(MainActivity.this, SearchScreen.class);
            startActivity(intent);
        }
    }
}
