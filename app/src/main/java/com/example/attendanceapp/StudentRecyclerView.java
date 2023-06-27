package com.example.attendanceapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class StudentRecyclerView extends RecyclerView.Adapter<StudentRecyclerView.MyViewHolder>{
    private ArrayList<StudentDetails> studentsArrayList;
    ArrayList<StudentDetails> studentArrayListForCheckBox;
    Context mContext;

    public StudentRecyclerView(Context mContext, ArrayList<StudentDetails> studentsArrayList) {
       this.mContext = mContext;
       this.studentsArrayList = studentsArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_recyclerview_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v,studentsArrayList,mContext);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentRecyclerView.MyViewHolder holder, int position) {

        String holderStudentName = studentsArrayList.get(position).getStudentName();
        String holderStudentClass = studentsArrayList.get(position).getStudentClassName();
        String holderStudentRoll = studentsArrayList.get(position).getStudentRoll();
        holder.studentRollRv.setText(holderStudentRoll);
        holder.studentNameRv.setText(holderStudentName);
        holder.studentClassRv.setText(holderStudentClass);
        StudentDetails studentDetails = new StudentDetails(holderStudentName,holderStudentClass,holderStudentRoll);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( holder.checkBox.isChecked()){
                    studentArrayListForCheckBox.add(studentDetails);
                }else{

                    studentArrayListForCheckBox.remove(studentDetails);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ArrayList<StudentDetails> studentDetails;
        private Context mContext;
        private CheckBox checkBox;
        private TextView studentNameRv,studentRollRv,studentClassRv;
        FirebaseDatabase database;
        DatabaseReference myRef;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public MyViewHolder(@NonNull View itemView, ArrayList<StudentDetails> studentDetails, Context mContext) {
            super(itemView);
            studentRollRv = itemView.findViewById(R.id.studentRollTv);
            studentNameRv = itemView.findViewById(R.id.studentNameTv);
            studentClassRv = itemView.findViewById(R.id.studentClassTv);
            checkBox = itemView.findViewById(R.id.studentCheckBox);
            studentArrayListForCheckBox = new ArrayList<>();

        }

            public void submitCheckedStudent() {

                Toast.makeText(mContext.getApplicationContext(),""+studentArrayListForCheckBox.size(),Toast.LENGTH_SHORT).show();
                for (StudentDetails sDetails : studentArrayListForCheckBox) {
                    database = FirebaseDatabase.getInstance();
                    myRef = database.getReference("AttendanceApp");
                    // StudentDetails presentStudent = new StudentDetails(roll, name, sClass);
                    myRef.child(sDetails.getStudentClassName()).push().setValue(sDetails);
                    //Intent intent = new Intent(AddStudent.this,AllStudentActivity.class);
                    // startActivity(intent);

                }
            }



    }

    public ArrayList<StudentDetails> getSelectedStudent(){
        return studentArrayListForCheckBox;
    }


}
