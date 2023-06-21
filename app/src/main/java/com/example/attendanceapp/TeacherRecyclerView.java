package com.example.attendanceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherRecyclerView extends RecyclerView.Adapter<TeacherRecyclerView.MyViewHolder>{
   private ArrayList<TeacherDetails> arrayList;
    Context mContext;
    public TeacherRecyclerView (Context mContext,ArrayList<TeacherDetails> arrayList){
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_recyclerview_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v,arrayList,mContext);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
         holder.teacherNameRV.setText(arrayList.get(position).getTeacherName());
         holder.teacherIndexRv.setText(arrayList.get(position).getTeacherIndex());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ArrayList<TeacherDetails> teacherArrayList;
        private Context mContext;
        private TextView teacherNameRV;
        private TextView teacherIndexRv;
        public MyViewHolder(View itemView, ArrayList<TeacherDetails> teacherArrayList, Context mContext) {
            super(itemView);
            this.teacherArrayList = teacherArrayList;
            this.mContext = mContext;
            teacherNameRV = (TextView) itemView.findViewById(R.id.teacherNameTv);
            teacherIndexRv = (TextView) itemView.findViewById(R.id.teacherIndexTv);
        }
    }
}
