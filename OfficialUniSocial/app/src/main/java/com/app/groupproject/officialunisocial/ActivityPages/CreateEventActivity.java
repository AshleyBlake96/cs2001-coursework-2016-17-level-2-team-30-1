package com.app.groupproject.officialunisocial.ActivityPages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.app.groupproject.officialunisocial.R;

public class CreateEventActivity extends AppCompatActivity {

    private EditText[] eventDetails = new EditText[7];
    public ImageView eventImage;
    private StorageReference storageFef;
    private FirebaseDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        storageFef = FirebaseStorage.getInstance().getReference();

        //This gets the database
        database = FirebaseDatabase.getInstance();

        eventImage = (ImageView) findViewById(R.id.imageview_id);
        Button browserImageBtn = (Button) findViewById(R.id.BrowseImage_button_id);


    }
}
