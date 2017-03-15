package com.app.groupproject.officialunisocial.ActivityPages;

/**
 * Created by Jey on 15/03/2017.
 */

public class UserData {

    private String uniqueID,university, number, imageref, fullname, gender, age, username;

    public UserData(String uniqueID,String username,String fullname,String age, String gender, String number, String university, String imageref) {
        this.username = username;
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.number = number;
        this.university = university;
        this.imageref = imageref;
        this.uniqueID = uniqueID;
    }


}
