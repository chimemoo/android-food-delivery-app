package com.chimemoo.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.chimemoo.fooddeliveryapp.adapter.DrawerAdapter;
import com.chimemoo.fooddeliveryapp.fragment.HistoryFragment;
import com.chimemoo.fooddeliveryapp.fragment.HomeFragment;
import com.chimemoo.fooddeliveryapp.fragment.LoveFragment;
import com.chimemoo.fooddeliveryapp.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, DuoMenuView.OnMenuClickListener {
    BottomNavigationView bottomNavigationView;
    DrawerAdapter drawerAdapter;
    private ViewHolder mViewHolder;


    private ArrayList<String> drawerMenuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Drawer Menu Item
        drawerMenuList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.menuDrawer)));

        // Initialize bottom navigation
        bottomNavigationView = findViewById(R.id.bnv_bottom);

        // Initialize view Holder
        mViewHolder = new ViewHolder();

        handleToolbar();

        handleMenu();

        handleDrawer();

        // Load fragment
        loadFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void handleMenu() {
        drawerAdapter = new DrawerAdapter(drawerMenuList);

        mViewHolder.menuView.setOnMenuClickListener(this);
        mViewHolder.menuView.setAdapter(drawerAdapter);
    }

    private void handleToolbar() {
        setSupportActionBar(mViewHolder.toolbarMain);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    @SuppressLint("ResourceAsColor")
    private void handleDrawer() {
        DuoDrawerToggle duoDrawerToggle;
        duoDrawerToggle = new DuoDrawerToggle(this,
                mViewHolder.drawerLayout,
                mViewHolder.toolbarMain,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mViewHolder.drawerLayout.setDrawerListener(duoDrawerToggle);
        mViewHolder.drawerLayout.setBackgroundColor(R.color.colorAccentSecondary);
        duoDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_nav_menu, menu);
        return true;
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_main_home, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()) {
            case R.id.action_home:
                fragment = new HomeFragment();
                break;

            case R.id.action_love:
                fragment = new LoveFragment();
                break;

            case R.id.action_user:
                fragment = new UserFragment();
                break;

            case R.id.action_history:
                fragment = new HistoryFragment();
                break;
        }

        return loadFragment(fragment);
    }

    @Override
    public void onFooterClicked() {

    }

    @Override
    public void onHeaderClicked() {

    }

    @Override
    public void onOptionClicked(int position, Object objectClicked) {

    }

    private class ViewHolder{
        private DuoDrawerLayout drawerLayout;
        private DuoMenuView menuView;
        private Toolbar toolbarMain;

        ViewHolder() {
            drawerLayout = findViewById(R.id.dl_main);
            menuView = (DuoMenuView) drawerLayout.getMenuView();
            toolbarMain = findViewById(R.id.toolbar_main);
        }
    }
}
