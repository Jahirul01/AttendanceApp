package com.example.attendanceapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTeacherActivity extends AppCompatActivity {
    private EditText teacherNameEt,teacherIndexEt,teacherPhoneEt,teacherEmailEt,teacherPasswordEt;
    private String teacherName,teacherIndex,teacherPhone,teacherEmail,teacherPass;
    private Button submitBtn;
    FirebaseDatabase database;
    DatabaseReference myRef;
    TeacherDetails teacherDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addteacher);
        teacherNameEt = findViewById(R.id.teacherNameEt);
        teacherIndexEt = findViewById(R.id.teacherIndexEt);
        teacherPhoneEt = findViewById(R.id.teacherPhoneEt);
        teacherEmailEt = findViewById(R.id.teacherEmailEt);
        teacherPasswordEt = findViewById(R.id.teacherPasswordEt);
        submitBtn = findViewById(R.id.teacherInformationSubmit);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("AttendanceApp");
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherName = teacherNameEt.getText().toString().trim();
                teacherIndex = teacherIndexEt.getText().toString().trim();
                teacherPhone = teacherPhoneEt.getText().toString().trim();
                teacherEmail = teacherEmailEt.getText().toString().trim();
                teacherPass= teacherPasswordEt.getText().toString().trim();

                teacherDetails = new TeacherDetails(teacherName,teacherIndex,teacherPhone,teacherEmail,teacherPass);
                myRef.child("Teachers").push().setValue(teacherDetails);

               Intent intent = new Intent(AddTeacherActivity.this,AdminAllActivity.class);
               startActivity(intent);


            }
        });
    }
}