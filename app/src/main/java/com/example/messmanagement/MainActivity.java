package com.example.messmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private LinearLayout member,mealCounter,expenditure,addBalance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle("Mess Management");

        addBalance = findViewById(R.id.memberListID);
        addBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,IndividualInvestment.class);
                startActivity(intent);
            }
        });
        member = findViewById(R.id.members);
        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,members.class);
                startActivity(intent);
            }
        });
        mealCounter  = findViewById(R.id.mealCounterid);
        mealCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,mealCounter.class);
                startActivity(intent);
            }
        });
        expenditure = findViewById(R.id.expenditureLayout);
        expenditure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,expenditure.class);
                startActivity(intent);
            }
        });




    }
}