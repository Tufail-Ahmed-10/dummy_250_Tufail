package com.example.messmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class NewMember extends AppCompatActivity {
    private EditText name,initMoney;
    private Button submit;
    private Toolbar toolbar;
    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_member);

        toolbar = findViewById(R.id.NewMemberToolbarID);
        toolbar.setTitle("Add New Member");

        db = FirebaseDatabase.getInstance("https://my-mess-meal-6851d-default-rtdb.firebaseio.com/");
        dbRef = db.getReference("members");
        name = findViewById(R.id.newMemberNameid);
        initMoney = findViewById(R.id.initMoneyid);
        submit = findViewById(R.id.submitNewMemberid);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewMember();
            }
        });
    }

    private void addNewMember() {
        String eName,eMoney;
        try {
            eName = name.getText().toString();
            eMoney = initMoney.getText().toString();
            HashMap<String,String> data = new HashMap<>();
            data.put("name",eName);
            data.put("amount",eMoney);
            data.put("debt","0");
            data.put("totalMeal","0");
            dbRef.child(eName).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Intent intent = new Intent(NewMember.this,members.class);
                    startActivity(intent);
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
    }
}