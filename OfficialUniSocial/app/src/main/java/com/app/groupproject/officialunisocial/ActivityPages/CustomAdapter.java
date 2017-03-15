package com.app.groupproject.officialunisocial.ActivityPages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

        TextView title = (TextView) convertView.findViewById(R.id.event_title_id);
        TextView desc = (TextView) convertView.findViewById(R.id.event_info_id);
        TextView location = (TextView) convertView.findViewById(R.id.event_location_id);
        TextView date = (TextView) convertView.findViewById(R.id.event_date_id);
        ImageView eventImage = (ImageView) convertView.findViewById(R.id.event_image_id);

        final EventData singleEventData = (EventData) this.getItem(position);

        title.setText(singleEventData.getTitle());
        desc.setText(singleEventData.getDescription());
        location.setText(singleEventData.getLocation());
        date.setText(singleEventData.getDate());
        Picasso.with(context).load(singleEventData.getImage()).into(eventImage);

        notifyDataSetChanged();

        return convertView;
    }


}
