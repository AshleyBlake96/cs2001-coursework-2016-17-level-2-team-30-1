package com.app.groupproject.unisocial.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jey on 04/01/2017.
 */

public class GetEventReq extends StringRequest {

    private static final String getEventURL = "http://digitalreceipt.esy.es/group_project/getEvents.php";
    private Map<String, String> serverData;

    public GetEventReq(String title, String description, String host, String location, String noStudents, String date, String time, String image, Response.Listener<String> listener) {
        super(Method.POST,getEventURL,listener,null);

        /*
        these basically post the values onto the sql table in the server
        using the URL of my server
         */

        serverData = new HashMap<>();
        serverData.put("title", title);
        serverData.put("description", description);
        serverData.put("host",host);
        serverData.put("location", location);
        serverData.put("noStudents", noStudents);
        serverData.put("dates",date);
        serverData.put("time", time);
        serverData.put("image", image);
        getParams();
    }


    @Override
    public Map<String, String> getParams() {
        return serverData;
    }





}
