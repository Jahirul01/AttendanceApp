package com.example.attendanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudent extends AppCompatActivity {

    private EditText studentNameEt,studentClassNameEt,studentSectionNameEt,studentRollEt,studentPhoneEt,studentAddressEt;
    private String studentName,studentClassName,studentSection,studentRoll,studentPhone,studentAddress;
    private Button studentInfoSubmitBtn;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        studentNameEt = findViewById(R.id.studentNameEt);
        studentRollEt = findViewById(R.id.studentRollEt);
        studentPhoneEt = findViewById(R.id.studentPhoneEt);
        studentAddressEt = findViewById(R.id.studentAddressEt);
        studentInfoSubmitBtn = findViewById(R.id.studentInformationSubmit);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("AttendanceApp");

        studentInfoSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentName = studentNameEt.getText().toString().trim();
                studentRoll = studentRollEt.getText().toString().trim();
                studentPhone = studentPhoneEt.getText().toString().trim();
                studentAddress = studentAddressEt.getText().toString().trim();
                //myRef.child("Students").push().setValue();
            }
        });
    }
}