package com.example.attendanceapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdminAllActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<TeacherDetails> arrayList;
    private DatabaseReference fireBaseDatabase;
    TeacherRecyclerView teacherRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_all);
        recyclerView = (RecyclerView) findViewById(R.id.teacherRecyclerView);
        fireBaseDatabase = FirebaseDatabase.getInstance().getReference("AttendanceApp");
        arrayList = new ArrayList<>();
        
        fireBaseDatabase.child("Teachers").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                arrayList.add(snapshot.getValue(TeacherDetails.class));
                teacherRecyclerView.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                arrayList.add(snapshot.getValue(TeacherDetails.class));
                teacherRecyclerView.notifyDataSetChanged();
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

        teacherRecyclerView = new TeacherRecyclerView(AdminAllActivity.this,arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(teacherRecyclerView);




    }

    public void AddTeacher(View view) {
        Intent intent = new Intent(AdminAllActivity.this,AddTeacherActivity.class);
        startActivity(intent);
    }

    public void addStudent(View view) {
        Intent intent = new Intent(AdminAllActivity.this,AddStudent.class);
        startActivity(intent);
    }
}