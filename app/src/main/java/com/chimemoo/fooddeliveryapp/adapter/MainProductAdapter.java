package com.chimemoo.fooddeliveryapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.chimemoo.fooddeliveryapp.fragment.HomeFragment;
import com.chimemoo.fooddeliveryapp.fragment.MainProductFragment;

public class MainProductAdapter extends FragmentPagerAdapter {
    HomeFragment context;
    int totalTabs;

    public MainProductAdapter(HomeFragment c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                MainProductFragment all = new MainProductFragment("All");
                return all;
            case 1:
                MainProductFragment foods = new MainProductFragment("Foods");
                return foods;
            case 2:
                MainProductFragment drinks = new MainProductFragment("Drinks");
                return drinks;
            case 3:
                MainProductFragment snacks = new MainProductFragment("Snacks");
                return snacks;
            case 4:
                MainProductFragment sauces = new MainProductFragment("Sauces");
                return sauces;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
