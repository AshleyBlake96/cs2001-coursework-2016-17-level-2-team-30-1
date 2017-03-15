package com.app.groupproject.officialunisocial;



public class EventData {

    private String image, title, description, host, date, time, location, noStudents;


    public EventData(){

    }

    public EventData(String image, String title, String description, String host, String location, String noStudents, String date, String time) {
        this.image = image;
        this.description = description;
        this.title = title;
        this.description = description;
        this.host = host;
        this.location = location;
        this.noStudents = noStudents;
        this.date = date;
        this.time = time;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNoStudents() {
        return noStudents;
    }

    public void setNoStudents(String noStudents) {
        this.noStudents = noStudents;
    }


}
