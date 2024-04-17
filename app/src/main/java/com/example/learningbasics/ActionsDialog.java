package com.example.learningbasics;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.learningbasics.data.MySchoolHandler;
import com.example.learningbasics.model.Student;

import java.util.ArrayList;

public class ActionsDialog extends AppCompatActivity {

    StudentAdmission mainClass;
    int stu_id;
    EditText stu_id_input;
    AppCompatButton add_btn_action,delete_btn_action;
    MySchoolHandler school_1;

    ArrayList<Student> studentArrayList;

    ViewStudentList viewStudentList;
    ThreeColumnList_Adapter threeColumnList_adapter;

/*    public ActionsDialog(@NonNull Context context, MySchoolHandler db,int stu_id_change) {
        super(context);
        school_1=db;
        stu_id = stu_id_change;


    }*/

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        add_btn_action = findViewById(R.id.add_btn);
        delete_btn_action = findViewById(R.id.delete_btn);

        add_btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainClass.onCreate(savedInstanceState);
            }
        });

//        stu_id_input = findViewById(R.id.edit_stu_id);

        delete_btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                stu_id=Integer.parseInt(getIntent().getStringExtra("Student_delete"));
//                Student student=studentArrayList.get(stu_id);
//                Toast.makeText(ActionsDialog.this, "Are u sure u want to delete "+student.getStName(), Toast.LENGTH_SHORT).show();
            }
        });

    }// onCreate()
}
