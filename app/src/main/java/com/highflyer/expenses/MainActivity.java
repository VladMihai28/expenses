package com.highflyer.expenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAddButton();
    }

    private void initializeAddButton(){
        Button addButton = findViewById(R.id.addExpenseButton);
        addButton.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Added an expense", Toast.LENGTH_SHORT).show());
    }
}
