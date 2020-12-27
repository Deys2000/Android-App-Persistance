package com.experiment.android.persistance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        TextView name_log = findViewById(R.id.textView_home);
        Intent intent = getIntent();
        String username = "User: "+intent.getStringExtra("NAME") ;
        name_log.setText(username);
    }

    public void openTables(View view){
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }
    public void openPractice(View view){
        Intent intent = new Intent(this, PracticeActivity.class);
        startActivity(intent);
    }
    public void openTest(View view){
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }
    public void openRecords(View view){
        Intent intent = new Intent(this, RecordsActivity.class);
        startActivity(intent);
    }
}
