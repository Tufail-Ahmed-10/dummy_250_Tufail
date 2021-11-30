package com.example.messmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class mealCounter extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Toolbar toolbar;
    private Spinner spinner;
    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private ArrayList<String> arrayList,mealList;
    private String investor,prevMeal;
    private Button increment,decrement;
    private EditText amountField;
    private TextView mealPrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_counter);
        toolbar = findViewById(R.id.mealCounterToolbar1);
        toolbar.setTitle("Meal Counter");
        db = FirebaseDatabase.getInstance("https://my-mess-meal-6851d-default-rtdb.firebaseio.com/");
        dbRef = db.getReference("members");
        spinner = findViewById(R.id.spinnerMealCounter1);
        arrayList = new ArrayList<>();
        mealList = new ArrayList<>();
        investor = "Null";

        increment  = findViewById(R.id.addMeal1);
        decrement  = findViewById(R.id.reduceMeal1);
        amountField = findViewById(R.id.mealAmount);
        mealPrev = findViewById(R.id.currentMeal1);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementMeal(1);
            }
        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementMeal(-1);
            }
        });

        dbRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot Snapshot) {
                for (DataSnapshot dataSnapshot : Snapshot.getChildren()) {

                    arrayList.add(dataSnapshot.child("name").getValue(String.class));
                    mealList.add(dataSnapshot.child("totalMeal").getValue(String.class));

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(mealCounter.this,
                        android.R.layout.simple_spinner_item,arrayList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        spinner.setOnItemSelectedListener(this);
    }
    private void incrementMeal(int p) {
        try{
            String amount = amountField.getText().toString();
            if(investor!="Null"){
                int a = Integer.parseInt(amount);
                int t = Integer.parseInt(prevMeal);
                if(a>0)
                {
                    a = a*p;
                    a = a+t;
                    dbRef.child(investor).child("totalMeal").setValue(String.valueOf(a));
                    finish();
                    startActivity(getIntent());
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please insert Valid Amount",Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        investor = parent.getItemAtPosition(position).toString();
        for(int i=0;i<arrayList.size();i++)
        {
            if(arrayList.get(i) ==investor){
                prevMeal = mealList.get(i);
                mealPrev.setText("Current Meal :  "+prevMeal);
                break;

            }
        }
        Toast.makeText(parent.getContext(), investor, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}