package com.app.groupproject.unisocial.ActivityPages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.groupproject.unisocial.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StreamDownloadTask;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatroomActivity extends AppCompatActivity {


    private Button sendMessageBtn;
    private EditText inputMessage;
    private TextView chatConvo;

    private String roomName, tempKey,un,chatMsg,chatUN;
    private DatabaseReference messageRef;
    private DatabaseReference chatRoomRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);



        Intent eventIntent = getIntent();
        roomName = eventIntent.getStringExtra("roomName");
        un = "Jey Jey";

        setTitle("Room " + roomName);



        sendMessageBtn = (Button) findViewById(R.id.send_message_button_id);
        inputMessage = (EditText) findViewById(R.id.user_msg_id);
        chatConvo = (TextView) findViewById(R.id.chat_id);


        chatRoomRef = FirebaseDatabase.getInstance().getReference().child(roomName +" Chatroom");

        sendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //This is for the random keys
                Map<String,Object> map = new HashMap<String, Object>();
                tempKey = chatRoomRef.push().getKey();
                chatRoomRef.updateChildren(map);

                messageRef = chatRoomRef.child(tempKey);

                Map<String,Object> map2 = new HashMap<String, Object>();
                map2.put("name",un);
                map2.put("msg",inputMessage.getText().toString());

                messageRef.updateChildren(map2);

            }
        });

        chatRoomRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                updateChatConvo(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                updateChatConvo(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    private void updateChatConvo(DataSnapshot ds) {

        Iterator i = ds.getChildren().iterator();

        while(i.hasNext()) {

            //i.next gets the first child value then the next child value
            //i.hasNext Loops till there are no more next child values!
            chatMsg = (String) ((DataSnapshot)i.next()).getValue();
            chatUN = (String) ((DataSnapshot)i.next()).getValue();

            //This puts the string together into one
            chatConvo.append(chatUN+" : "+chatMsg+" \n");

        }
    }
}
