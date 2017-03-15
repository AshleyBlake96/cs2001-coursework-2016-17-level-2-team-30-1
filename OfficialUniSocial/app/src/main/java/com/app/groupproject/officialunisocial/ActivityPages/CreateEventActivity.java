package com.app.groupproject.officialunisocial.ActivityPages;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
        eventDetails[0] = (EditText) findViewById(R.id.Title_field_id);

        browserImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(textToString(eventDetails[0]).equals("")) {
                    Toast.makeText(CreateEventActivity.this, "Fill in Title Field", Toast.LENGTH_SHORT).show();
                }
                else {
                    openGallery();
                }
            }
        });


        Button submitButton = (Button) findViewById(R.id.Submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventDetails[1] = (EditText) findViewById(R.id.Description_field_id);
                eventDetails[2] = (EditText) findViewById(R.id.Host_field_id);
                eventDetails[3] = (EditText) findViewById(R.id.Location_field_id);
                eventDetails[4] = (EditText) findViewById(R.id.No_of_students_field_id);
                eventDetails[5] = (EditText) findViewById(R.id.Date_field_id);
                eventDetails[6] = (EditText) findViewById(R.id.Time_field_id);
                ImageView image = (ImageView) findViewById(R.id.imageview_id);



            }
        });
    }




    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }


}
