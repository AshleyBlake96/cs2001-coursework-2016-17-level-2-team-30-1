package com.app.groupproject.officialunisocial.ActivityPages;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.app.groupproject.officialunisocial.EventData;
import com.app.groupproject.officialunisocial.R;


import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    private ArrayList<EventData> eventList = new ArrayList<>();
    private EventData pressedEvent;
    private UserData userInfo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navView = (NavigationView) findViewById(R.id.nav_view_id);
        View headerView = navView.getHeaderView(0);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                public boolean onNavigationItemSelected(MenuItem item) {
                    int id = item.getItemId();

                    if(id == R.id.nav_profileBtn_id) {
                        Intent profileIntent = new Intent(EventListActivity.this,ProfileActivity.class);
                        profileIntent.putExtra("userInfo",userInfo);
                        startActivity(profileIntent);
                    }
                    else if(id == R.id.nav_chatroomBtn_id) {






                    }
                    else if(id == R.id.nav_eventsBtn_id) {
                        Toast.makeText(EventListActivity.this, "You are already here :D", Toast.LENGTH_SHORT).show();
                    }

                    return true;


            }


        });


    }
}
