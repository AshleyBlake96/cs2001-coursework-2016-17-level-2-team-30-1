package com.app.groupproject.officialunisocial.ActivityPages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.app.groupproject.officialunisocial.EventData;

import java.util.ArrayList;

/**
 * Created by Jey on 15/03/2017.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<EventData> eventList;

    public CustomAdapter(Context c, ArrayList<EventData> ed) {
        this.context = c;
        this.eventList = ed;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //This controls how the strings that were passed in are laid out
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_event_row, parent, false);
        }




        return convertView;
    }


}
