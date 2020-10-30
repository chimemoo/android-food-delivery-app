package com.chimemoo.fooddeliveryapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chimemoo.fooddeliveryapp.R;
import com.chimemoo.fooddeliveryapp.adapter.MainProductAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    private static String[] foodTypes = {
            "All",
            "Foods",
            "Drinks",
            "Snacks",
            "Sauces"
    };

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View mView = inflater.inflate(R.layout.fragment_home, container, false);

        tabLayout = mView.findViewById(R.id.tl_main_product);
        viewPager = mView.findViewById(R.id.vp_main_product);

        for(int i = 0; i < foodTypes.length; i++){
            tabLayout.addTab(tabLayout.newTab().setText(foodTypes[i]));
        }

        final MainProductAdapter mainProductAdapter = new MainProductAdapter(this, getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(mainProductAdapter);
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
        return mView;
    }
}
