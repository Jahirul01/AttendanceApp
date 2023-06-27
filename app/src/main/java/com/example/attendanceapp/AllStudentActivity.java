package com.example.attendanceapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AllStudentActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<StudentDetails> arrayList;
    private DatabaseReference fireBaseDatabase;
    StudentRecyclerView studentRecyclerView;
    Button submitBtn;

    ArrayList<StudentDetails> studentArrayListForCheckBox;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_student);

        submitBtn = (Button) findViewById(R.id.submitPresentStudent);
        recyclerView = findViewById(R.id.studentRecyclerView);
        fireBaseDatabase = FirebaseDatabase.getInstance().getReference("AttendanceApp");
        arrayList = new ArrayList<>();
        studentArrayListForCheckBox = new ArrayList<>();

        fireBaseDatabase.child("Students").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                arrayList.add(snapshot.getValue(StudentDetails.class));
                studentRecyclerView.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                arrayList.add(snapshot.getValue(StudentDetails.class));
                studentRecyclerView.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        studentRecyclerView = new StudentRecyclerView(AllStudentActivity.this,arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(studentRecyclerView);
    // checkBox work

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentArrayListForCheckBox = studentRecyclerView.getSelectedStudent();
                Toast.makeText(getApplicationContext(),""+studentArrayListForCheckBox.size(),Toast.LENGTH_SHORT).show();

                for (StudentDetails sDetails : studentArrayListForCheckBox) {

                    fireBaseDatabase.child(sDetails.getStudentClassName()).push().setValue(sDetails);
                    Intent intent = new Intent(AllStudentActivity.this,AttendanceDetails.class);
                    startActivity(intent);

                }
            }
        });

    }
}