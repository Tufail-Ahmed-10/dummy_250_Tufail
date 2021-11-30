package com.example.messmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class members extends AppCompatActivity {
    private Button addMember;
    private Toolbar toolbar;
    private ListView listView;
    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private myAdapter adapter;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);

        toolbar = findViewById(R.id.membersToolbarID);
        toolbar.setTitle("Mess Members");

        db = FirebaseDatabase.getInstance("https://my-mess-meal-6851d-default-rtdb.firebaseio.com/");
        dbRef = db.getReference("members");

        listView = findViewById(R.id.listIdyo);

        addMember = findViewById(R.id.addmemberIid);
        addMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(members.this,NewMember.class);
                startActivity(intent);
            }
        });

        list = new ArrayList<>();


        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot Snapshot) {
                for(DataSnapshot dataSnapshot : Snapshot.getChildren()){

                    list.add(dataSnapshot.child("name").getValue(String.class));
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(members.this,R.layout.single_member,R.id.singleNameId,list);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}