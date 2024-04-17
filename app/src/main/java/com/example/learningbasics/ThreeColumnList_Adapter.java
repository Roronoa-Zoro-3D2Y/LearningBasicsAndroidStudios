package com.example.learningbasics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.example.learningbasics.model.Student;

import java.util.ArrayList;

public class ThreeColumnList_Adapter extends ArrayAdapter<Student> {
    private final LayoutInflater inflater;
    private final ArrayList<Student> students;
    private final int resourceId;
    AppCompatButton actions_btn;

    public ThreeColumnList_Adapter(Context context,int rid,ArrayList<Student> studentArrayList){
        super(context,rid,studentArrayList);
        this.students=studentArrayList;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        resourceId=rid;
    }


    @SuppressLint("ViewHolder")
    public View getView(int pos, View convertView, ViewGroup parents){

        Log.d("Testing6", "Inside three column adapter");

       convertView = inflater.inflate(resourceId,null);

        Student student = students.get(pos);

        if(student != null){

            Log.d("Testing7", "Inside three column adapter getView");

            TextView stu_roll = (TextView) convertView.findViewById(R.id.stu_id_list);
            TextView stu_name = (TextView) convertView.findViewById(R.id.stu_name_list);
            TextView stu_dob = (TextView) convertView.findViewById(R.id.stu_dob_list);

            if(stu_roll != null)
                stu_roll.setText(""+student.getStRoll());
            if(stu_name != null) {
                stu_name.setText(""+student.getStName());
            }
            if(stu_dob != null) {
                stu_dob.setText(""+student.getDOB());
            }
        }
        return convertView;
    }


}
