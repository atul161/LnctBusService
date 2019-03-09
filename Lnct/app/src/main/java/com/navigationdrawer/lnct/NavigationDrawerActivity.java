package com.navigationdrawer.lnct;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lnct.R;
import com.navigationfragment.lnct.Contact;
import com.navigationfragment.lnct.DevelopedBy;
import com.navigationfragment.lnct.FindBus;
import com.navigationfragment.lnct.LocateBus;
import com.navigationfragment.lnct.Notice;
import com.navigationfragment.lnct.ViewRoute;

import java.util.Timer;
import java.util.TimerTask;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Handler handler;
    Timer timer;
    Runnable runnable;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setting a container

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView=navigationView.getHeaderView(0);
        //Animation of image bus
        final ImageView bus=headerView.findViewById(R.id.bus_id);
        Glide.with(this).load(R.drawable.bus).into(bus);
         final Animation anim= AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        bus.startAnimation(anim);

        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                bus.startAnimation(anim);

            }
        };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },8000,8000);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id==R.id.find_bus) {
            // Handle the camera action
            //handle kae rahe hai madharchod
           FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
           fragmentTransaction.add(R.id.frame_layout,new FindBus(),null);
           fragmentTransaction.addToBackStack("tag_back");
            fragmentTransaction.commit();
        } else if (R.id.locate_bus==id) {
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_layout,new LocateBus(),null);
            fragmentTransaction.addToBackStack("tag_back");
            fragmentTransaction.commit();

        } else if (R.id.view_route==id) {
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_layout,new ViewRoute(),null);
            fragmentTransaction.addToBackStack("tag_back");
            fragmentTransaction.commit();

        } else if (R.id.notice==id) {
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_layout,new Notice(),null);
            fragmentTransaction.addToBackStack("tag_back");
            fragmentTransaction.commit();

        } else if (R.id.contact==id) {
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_layout,new Contact(),null);
            fragmentTransaction.addToBackStack("tag_back");
            fragmentTransaction.commit();


        } else if (R.id.developed_by==id) {
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_layout,new DevelopedBy(),null);
            fragmentTransaction.addToBackStack("tag_back");
            fragmentTransaction.commit();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
