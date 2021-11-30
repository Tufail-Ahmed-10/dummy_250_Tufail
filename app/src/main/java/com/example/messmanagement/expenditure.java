package com.example.messmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class expenditure extends AppCompatActivity {
    private Toolbar toolbar;
    private Spinner spinner;
    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private String investor,prevMeal;
    private Button increment;
    private EditText amountField,messageField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenditure);
        toolbar = findViewById(R.id.expenditureToolbar);
        toolbar.setTitle("Expenditure");
        db = FirebaseDatabase.getInstance("https://my-mess-meal-6851d-default-rtdb.firebaseio.com/");
        dbRef = db.getReference("Expenditure");


    }
}