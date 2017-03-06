package com.app.groupproject.officialunisocial.ActivityPages;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.app.groupproject.officialunisocial.R;

public class RegisterActivity extends AppCompatActivity {

    private ImageView profileImg;
    private UserData registerData = new UserData();
    private EditText[] textField = new EditText[8];
    private static final int PICK_IMAGE = 11;


    private FirebaseAuth fAuth;
    private DatabaseReference dbRef;
    private StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialising Authentication database
        fAuth = FirebaseAuth.getInstance();

        //Initialising database reference for where user info will be stored
        dbRef = FirebaseDatabase.getInstance().getReference().child("Users");

        //Initialising database reference for where the useres profile pics willl be stored
        storageRef = FirebaseStorage.getInstance().getReference();


        //TextField for user information
        textField[0] = (EditText) findViewById(R.id.fullName_field_id);
        textField[1] = (EditText) findViewById(R.id.username_field_id);
        textField[2] = (EditText) findViewById(R.id.Email_field_id);
        textField[3] = (EditText) findViewById(R.id.password_field_id);
        textField[4] = (EditText) findViewById(R.id.reenter_password_field_id);
        textField[5] = (EditText) findViewById(R.id.age_field_id);
        textField[6] = (EditText) findViewById(R.id.university_field_id);
        textField[7] = (EditText) findViewById(R.id.number_field_id);

        //ImageView for profile pic
        profileImg = (ImageView) findViewById(R.id.profileimage_id);

        //retrieved the buttons from the layout activity page
        Button registerBtn = (Button) findViewById(R.id.register_button_id);
        Button browserImg = (Button) findViewById(R.id.BrowseProfileImage_button_id);

        //Added a spinner to give users an option between male and female
        Spinner genderOptions = (Spinner) findViewById(R.id.gender_options_id);

        //making the browser button open the gallery when pressed
        browserImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(SCMethods.textToString(textField[1]).equals("")) {
                    Toast.makeText(RegisterActivity.this, "Fill in Username Field", Toast.LENGTH_SHORT).show();
                }
                else {
                    openGallery();
                }
            }
        });



        //added array adapter which gets the string array values which the user choses from
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.gender_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Spinner adding adapter for the male/female selection and storing it in the UserData Information
        genderOptions.setAdapter(adapter);
        genderOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                registerData.setGender(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            //gets Uri of the chosen image
            Uri imageFileUri = data.getData();

            CropImage.activity(imageFileUri)
                    .setGuidelines(CropImageView.Guidelines.OFF)
                    .setFixAspectRatio(true)
                    .setAspectRatio(1,1)
                    .setActivityTitle("Crop Profile Image")
                    .setBackgroundColor(Color.parseColor("#86FF0004"))
                    .setBorderCornerColor(Color.WHITE)
                    .setBorderLineColor(Color.parseColor("#0191e4"))
                    .start(this);

        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {

        }


    }

}
