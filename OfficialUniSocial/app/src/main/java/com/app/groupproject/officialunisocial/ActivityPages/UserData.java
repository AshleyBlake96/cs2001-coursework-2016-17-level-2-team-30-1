package com.app.groupproject.officialunisocial.ActivityPages;

import java.io.Serializable;

/**
 * Created by Jey on 15/03/2017.
 */

public class UserData implements Serializable{

    private String uniqueID,university, number, imageref, fullname, gender, age, username;

    public UserData() {

    }
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImageref() {
        return imageref;
    }

    public void setImageref(String imageref) {
        this.imageref = imageref;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String name) {
        this.fullname = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

}
