package com.app.groupproject.officialunisocial.ActivityPages;

import android.content.Context;

import com.app.groupproject.officialunisocial.EventData;

import java.util.ArrayList;

/**
 * Created by Jey on 15/03/2017.
 */

public class CustomAdapter {

    private Context context;
    private ArrayList<EventData> eventList;

    public CustomAdapter(Context c, ArrayList<EventData> ed) {
        this.context = c;
        this.eventList = ed;
    }



}
