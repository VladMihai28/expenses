package com.highflyer.expenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        addButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Added an expense", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
