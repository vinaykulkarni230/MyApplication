package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class home extends AppCompatActivity {
    TextView welcomemsg,vinay;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        welcomemsg=(TextView)findViewById(R.id.welcomemsg);
        vinay=(TextView)findViewById(R.id.vinay);
        logout=findViewById(R.id.logout);
        Intent intent=getIntent();
        String string=intent.getStringExtra("username");
        welcomemsg.setText(string);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}