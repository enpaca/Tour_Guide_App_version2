package com.example.en.prishtinatourguide;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
//import android.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.support.v4.view.ViewPager;


public class MainActivity extends AppCompatActivity {

    //Declare a local variable with keyword final OR declare global variable,
    //and then initialize inside the onCreate() async callback method.
    DrawerLayout mDrawerLayout;

    //Declare a local variable with keyword final OR declare global variable,
    //and then initialize inside the onCreate() async callback method.
    //private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the toolbar as action bar:
        //First change manifest to include a theme without an action bar and add toolbar view
        //in the activity_main.xml layout file (inside FrameLayout)
        //Find the toolbar.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Add navigation drawer button:
        //Enable the app bar's "home" button.
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Set icon of drawer button
        actionBar.setHomeAsUpIndicator(R.drawable.baseline_menu_white_24);


        //Declare a local variable with keyword final OR declare global variable,
        //and then initialize inside the onCreate() async callback method.
        //This is where fragment is shown upon activity creation (when app is first opened)
        final FragmentManager mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().add(R.id.content_frame, new AttractionsFragment()).commit();

        //Get a reference to the drawer layout
        //Declare a local variable with keyword final OR declare global variable,
        //and then initialize inside the onCreate() async callback method.
        //final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        //Get a reference to the navigation view
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        //check the first item of navigation drawer menu, because its fragment is first seen.
        //navigationView.getMenu().getItem(R.id.nav_attractions).setChecked(true); //for some reason it just stopped working.
        //So another option is used, the attribute checked=true of an item in the drawer_menu.xmls

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();
                // Set action bar title
                setTitle(menuItem.getTitle());

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here
                Fragment fragmentToShow = null;
                if (menuItem.getItemId() == R.id.nav_attractions) {
                    fragmentToShow = new AttractionsFragment();
                    Log.v("Now:", "Attractions Fragment");
                } else if (menuItem.getItemId() == R.id.nav_restaurants) {
                    fragmentToShow = new RestaurantsFragment();
                    Log.v("Now:", "Restraunts Fragment");
                } else if (menuItem.getItemId() == R.id.nav_parks) {
                    fragmentToShow = new ParksFragment();
                    Log.v("Now:", "Parks Fragment");
                } else if (menuItem.getItemId() == R.id.nav_shopping) {
                    fragmentToShow = new ShoppingFragment();
                    Log.v("Now:", "Shopping Fragment");
                }
                // Insert the fragment by replacing any existing fragment
                mFragmentManager.beginTransaction().replace(R.id.content_frame, fragmentToShow).commit();

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
