package com.app.groupproject.officialunisocial;

import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by Jey on 15/03/2017.
 */

public class SCMethods {

    //This makes the child of the event and its value for example "Location = Uxbridge"
    public static void addChildAndValue(DatabaseReference ref, String child, String value) {
        ref.getRef().child(child).setValue(value);
    }

    public static String textToString(EditText editText) {

        return editText.getText().toString();
    }

}
