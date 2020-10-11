package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText username,password,emailid,dob,country;
    Button register,cancel;
    RadioGroup gender;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        emailid = findViewById(R.id.mailid);
        dob = findViewById(R.id.dob);
        gender = findViewById(R.id.gender);
        country = findViewById(R.id.country);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        databaseHelper = new DatabaseHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue=username.getText().toString();
                String passwordValue=password.getText().toString();
                String mailidValue=emailid.getText().toString();
                String dobValue=dob.getText().toString();
                RadioButton checkedBtn=findViewById(gender.getCheckedRadioButtonId());
                String genderValue=checkedBtn.getText().toString();
                String countryValue=country.getText().toString();

                if(usernameValue.length()>1){
                    ContentValues contentValues=new ContentValues();
                    contentValues.put("username",usernameValue);
                    contentValues.put("password",passwordValue);
                    contentValues.put("mailid",mailidValue);
                    contentValues.put("dob",dobValue);
                    contentValues.put("country",countryValue);
                    contentValues.put("gender",genderValue);

                    databaseHelper.insertUser(contentValues);
                    Toast.makeText(register.this,"user registered",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(register.this, "Enter user details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(register.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}