package com.app.groupproject.officialunisocial.ActivityPages;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.groupproject.officialunisocial.R;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView profileImage = (ImageView) findViewById(R.id.profilepage_image_id);
        TextView username = (TextView) findViewById(R.id.profilepage_username_id);
        TextView name = (TextView) findViewById(R.id.profilepage_users_name_id);
        TextView email = (TextView) findViewById(R.id.profilepage_emailInfo_id);
        TextView gender = (TextView) findViewById(R.id.profilepage_genderInfo_id);
        TextView age = (TextView) findViewById(R.id.profilepage_ageInfo_id);
        TextView uni = (TextView) findViewById(R.id.profilepage_universityInfo_id);
        TextView number = (TextView) findViewById(R.id.profilepage_numPhoneInfo_id);

}
