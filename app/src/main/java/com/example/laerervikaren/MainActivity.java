package com.example.laerervikaren;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
//TESTING TESTING TESTING TESTING TESTING TESTING
    FragmentManager manager;
    Fragment currentFragment;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        //fragmentTransaction.add(R.id.fragment_view_top,new MatematikFragment());
        //FragmentTransaction.commit();



        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_view_top, new Klasse1_3_Fragment()).addToBackStack(null).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_view_bottom, new WhiteFragment()).addToBackStack(null).commit();

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        TextView txtView = (TextView)findViewById(R.id.StartText);
        ImageView imageView = (ImageView)findViewById(R.id.lerervikar);
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        txtView.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.INVISIBLE);

        if (id == R.id.klasse1_3) {
        //txtView.setVisibility(View.INVISIBLE);
            currentFragment = new Klasse1_3_Fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_view_top, currentFragment).addToBackStack(null).commit();
        } else if (id == R.id.klasse4_6){
            currentFragment = new klasse4_6();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_view_top, currentFragment).addToBackStack(null).commit();
        }else if (id == R.id.klasse7_9){
            currentFragment = new Klasse7_9();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_view_top, currentFragment).addToBackStack(null).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
