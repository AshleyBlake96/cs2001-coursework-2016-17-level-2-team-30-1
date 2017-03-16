package com.app.groupproject.officialunisocial.ActivityPages;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.groupproject.officialunisocial.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SocialWallActivity extends AppCompatActivity{

    private Button addWall;
    private TextView mWallView;

    private DatabaseReference mDatabase;
    private TextView mUserWall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_wall);

        TextView social_wall = (TextView) findViewById(R.id.wall_view);

        addWall = (Button) findViewById(R.id.AddWall);
        mDatabase = FirebaseDatabase.getInstance().getReference().child(" ");
        mWallView = (TextView) findViewById(R.id.wall_view);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String wall = dataSnapshot.getValue().toString();
                mWallView.setText("" + wall);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        });
    }
}