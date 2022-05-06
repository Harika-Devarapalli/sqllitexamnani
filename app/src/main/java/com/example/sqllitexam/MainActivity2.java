package com.example.sqllitexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String nameh=intent.getStringExtra("name");
        String contacth=intent.getStringExtra("contact");
        String dobh=intent.getStringExtra("date of birth");
        TextView res=findViewById(R.id.txt1);


        res.setText("name: "+nameh+"\ncontact :"+contacth+"\ndate of birth :"+dobh);
        //res.setText("name: "+nameh+"\ncontact :"+contacth+"\ndate of birth :"+dobh);
    }
}