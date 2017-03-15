package com.app.groupproject.officialunisocial.ActivityPages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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


    }
}
