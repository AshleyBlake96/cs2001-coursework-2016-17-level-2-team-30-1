package com.app.groupproject.unisocial.ActivityPages;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.groupproject.unisocial.R;
import com.app.groupproject.unisocial.UserData;
import com.app.groupproject.unisocial.UserData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth fAuth;
    private FirebaseUser firebaseUser;
    private FirebaseAuth.AuthStateListener fAuthListener;
    private DatabaseReference fbDatabase;
    private EditText email;
    private EditText passw;
    private String userID;
    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fAuth = FirebaseAuth.getInstance();
        fbDatabase = FirebaseDatabase.getInstance().getReference().child("Users");


        email = (EditText) findViewById(R.id.emailentered_id);
        passw = (EditText) findViewById(R.id.passwordentered_id);

        Button signin = (Button) findViewById(R.id.sign_in_button_id);
        Button register = (Button) findViewById(R.id.register_button_id);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(start);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Remove this when sign out button is added
                FirebaseAuth.getInstance().signOut();
                login();


            }
        });


    }

    private void login() {

        String emailStr = email.getText().toString();
        String passwStr = passw.getText().toString();

        if (TextUtils.isEmpty(emailStr) || TextUtils.isEmpty(passwStr)) {
            Toast.makeText(this, "Fill in Login Details!", Toast.LENGTH_SHORT).show();
        } else {
            fAuth.signInWithEmailAndPassword(emailStr, passwStr).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isComplete()) {
                        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                        if (firebaseUser == null) {
                            passw.getText().clear();
                            Toast.makeText(LoginActivity.this, "Incorrect Details", Toast.LENGTH_SHORT).show();
                        } else {
                            getUserDetails();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }


    }

    private void getUserDetails() {


        userID = firebaseUser.getUid();

        fbDatabase.child(userID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Stores all the values in registerInfo
                userData = dataSnapshot.getValue(UserData.class);
                Log.v("E_VALUE---------------", userData.getFullname());
                Log.v("E_VALUE---------------", userData.getNumber());
                Intent eventListIntent = new Intent(LoginActivity.this, EventListActivity.class);
                eventListIntent.putExtra("userInfo", userData);
                startActivity(eventListIntent);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
