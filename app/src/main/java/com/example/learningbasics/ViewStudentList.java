package com.example.learningbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.learningbasics.data.MySchoolHandler;
import com.example.learningbasics.model.Student;

import java.util.ArrayList;

public class ViewStudentList extends AppCompatActivity {
    ListView listView;
    Student student;
    ArrayList<Student> studentArrayList;
    MySchoolHandler school_1 = new MySchoolHandler(ViewStudentList.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_admission);

        Log.d("Testing4","View Student List class");

        studentArrayList = new ArrayList<>();
        Cursor data = school_1.getStudentList();
        if(school_1.getTotalRecords() == 0)
            Toast.makeText(ViewStudentList.this, "No Data in Database", Toast.LENGTH_SHORT).show();
        else{
            while(data.moveToNext()) {
                student = new Student(Integer.parseInt(data.getString(0)), data.getString(1), data.getString(2));
                studentArrayList.add(student);
            }
        }
        ThreeColumnList_Adapter adapter = new ThreeColumnList_Adapter(ViewStudentList.this, R.layout.activity_view_student_list, studentArrayList);
        listView = findViewById(R.id.stu_listview);
        listView.setAdapter(adapter);

    }
}