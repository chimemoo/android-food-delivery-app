package com.chimemoo.fooddeliveryapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.chimemoo.fooddeliveryapp.fragment.LoginFragment;
import com.chimemoo.fooddeliveryapp.fragment.SignUpFragment;

public class AuthAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public AuthAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LoginFragment login = new LoginFragment();
                return login;
            case 1:
                SignUpFragment signup = new SignUpFragment();
                return signup;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
