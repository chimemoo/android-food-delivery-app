package com.chimemoo.fooddeliveryapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chimemoo.fooddeliveryapp.R;

import java.util.ArrayList;

import nl.psdcompany.duonavigationdrawer.views.DuoOptionView;

public class DrawerAdapter extends BaseAdapter {
    private ArrayList<String> mOptions = new ArrayList<>();
    private ArrayList<DuoOptionView> mOptionViews = new ArrayList<>();

    public DrawerAdapter(ArrayList<String> mOptions) {
        this.mOptions = mOptions;
    }

    @Override
    public int getCount() {
        return mOptions.size();
    }

    @Override
    public Object getItem(int position) {
        return mOptions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String option = mOptions.get(position);

        final DuoOptionView optionView;
        if (convertView == null) {
            optionView = new DuoOptionView(parent.getContext());
        } else {
            optionView = (DuoOptionView) convertView;
        }

        // Using the DuoOptionView's default selectors
        optionView.bind(option, parent.getContext().getResources().getDrawable(menuIcons[position]));

        // Adding the views to an array list to handle view selection
        mOptionViews.add(optionView);

        return optionView;
    }

    void setViewSelected(int position, boolean selected) {

        // Looping through the options in the menu
        // Selecting the chosen option
        for (int i = 0; i < mOptionViews.size(); i++) {
            if (i == position) {
                mOptionViews.get(i).setSelected(selected);
            } else {
                mOptionViews.get(i).setSelected(!selected);
            }
        }
    }

    private static int[] menuIcons = {
            R.drawable.ic_profile,
            R.drawable.ic_order,
            R.drawable.ic_offer,
            R.drawable.ic_privacy,
            R.drawable.ic_security
    };
}
