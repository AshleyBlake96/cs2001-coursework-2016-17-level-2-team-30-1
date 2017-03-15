package com.app.groupproject.officialunisocial.ActivityPages;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.groupproject.officialunisocial.EventData;
import com.app.groupproject.officialunisocial.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class EventListActivity extends AppCompatActivity {

    private ArrayList<EventData> eventList = new ArrayList<>();
    private EventData pressedEvent;
    private UserData userInfo;
    private ListView customList;




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

                int id = item.getItemId();

                if (id == R.id.nav_profileBtn_id) {
                    Intent profileIntent = new Intent(EventListActivity.this, ProfileActivity.class);
                    profileIntent.putExtra("userInfo", userInfo);
                    startActivity(profileIntent);
                } else if (id == R.id.nav_chatroomBtn_id) {


                } else if (id == R.id.nav_eventsBtn_id) {
                    Toast.makeText(EventListActivity.this, "You are already here :D", Toast.LENGTH_SHORT).show();
                }

                return true;


            }

        });

        CircleImageView navProfileImage = (CircleImageView) headerView.findViewById(R.id.nav_profileImage_id);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_username_id);
        TextView navEmail = (TextView) headerView.findViewById(R.id.nav_email_id);

        Intent loginIntent = getIntent();
        userInfo = (UserData) loginIntent.getExtras().get("userInfo");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null) navEmail.setText(user.getEmail());

        Picasso.with(this).load(userInfo.getImageref()).into(navProfileImage);
        navUsername.setText(userInfo.getUsername());

        //This gets the url for our database because it already knows what it is
        //That's giving us the reference to the top level of our database
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
        customList = (ListView) findViewById(R.id.list_id);

        customList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pressedEvent = (EventData) parent.getItemAtPosition(position);

                Intent eventInfo = new Intent(EventListActivity.this,EventInfoActivity.class);

                Log.v("E_VALUE--------------",pressedEvent.getImage());
                eventInfo.putExtra("eventData",pressedEvent);
                eventInfo.putExtra("userInfo",userInfo);
                startActivity(eventInfo);

            }
        });

        //Instead of an inner class I call a anonymous interclass
        databaseRef.child("Events").addValueEventListener(new ValueEventListener() {

            /*
            This method will be invoked any time the data on the database changes.
            Additionally, it will be invoked as soon as we connect the listener,
            so that we can get an initial snapshot of the data on the database.
            */
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //ctrl alt v Creates the correct data type to store it in
                //Iterable gets all of the children at this level
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                //shake hands with each of them and save it as a variable (Child)
                for(DataSnapshot child: children) {
                    EventData event = child.getValue(EventData.class);
                    eventList.add(event);
                }

                CustomAdapter adapter = new CustomAdapter(EventListActivity.this,eventList);
                customList.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
