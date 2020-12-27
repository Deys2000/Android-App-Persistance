package com.experiment.android.persistance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startApp(View view){

        EditText name_text = findViewById(R.id.edittext_name);
        String username = name_text.getText().toString();
        Intent intent = new Intent(this, HomeActivity.class);
        if(username.equals("")){
            intent.putExtra("NAME","GUEST");
        }else{
            intent.putExtra("NAME",username);
        }
        startActivity(intent);
    }
}
