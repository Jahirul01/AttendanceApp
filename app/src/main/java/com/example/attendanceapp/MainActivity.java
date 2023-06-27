package com.example.attendanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAdminSignUp(View view) {
        Intent intent = new Intent(MainActivity.this,AdminSignUp.class);
        startActivity(intent);
    }

    public void goAdminActivity(View view) {
        Intent intent = new Intent(MainActivity.this,AdminAllActivity.class);
        startActivity(intent);
    }

    public void goAllStudentActivity(View view) {
        Intent intent = new Intent(MainActivity.this,AllStudentActivity.class);
        startActivity(intent);
    }
}