package com.example.learningbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learningbasics.data.MySchoolHandler;
import com.example.learningbasics.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdmission extends AppCompatActivity{

    EditText enter_name,enter_id,enter_dob;
    AppCompatButton addBtn,viewBtn;
   boolean insertData;

   ArrayList<Student> studentArrayList;

    public MySchoolHandler school_1 = new MySchoolHandler(StudentAdmission.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_view);



        //Adding New Students to New School
        Student nanda = new Student(1, "Nanda Su", "01.06.2002");
        Student asta = new Student(2, "Asta", "21.06.2000");
        Student luffy = new Student(3, "Monkey D Luffy", "21.06.2002");
        Student naruto = new Student(4, "Uzumaki Naruto", "21.06.2011");

        // ADDING TO DATABASE
        school_1.addStudents(nanda);
        school_1.addStudents(asta);
        school_1.addStudents(luffy);
        school_1.addStudents(naruto);

        nanda.setDOB("16.06.2024");
        school_1.updateStuDetails(nanda);


        Log.d("Testing", "Reached Here");

        List<Student> stu_list = school_1.getAllStudents();

        for (Student i : stu_list)
            Log.d("Testing2", " Roll " + i.getStRoll() + " Name :" + i.getStName() + " Birthday " + i.getDOB());

        enter_id = findViewById(R.id.stu_id);
        enter_name = findViewById(R.id.stu_name);
        enter_dob = findViewById(R.id.stu_dob);

        addBtn = findViewById(R.id.add_btn);
        viewBtn = findViewById(R.id.view_btn);

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Testing5", "Inside viewBtn");
                Intent intent = new Intent(StudentAdmission.this,ViewStudentList.class);
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // assigning the entered text to the list from EditText
                int id = Integer.parseInt(enter_id.getText().toString());
                String name = enter_name.getText().toString();
                String dob = enter_dob.getText().toString();

                Log.d("Testing6", "Inside addBtn");

                if(name.length() != 0 && dob.length() != 0 && id != 0){
                    Student studentAdd = new Student();
                    studentAdd.setStRoll(id);
                    studentAdd.setStName(name);
                    studentAdd.setDOB(dob);
//                    school_1.addStudents(studentAdd);

                    insertData = school_1.AddData(studentAdd);

                    //Initializing Edit text wd empty string
                    enter_id.setText("");
                    enter_name.setText("");
                    enter_dob.setText("");
                }
                else {
                    Toast.makeText(StudentAdmission.this, "You Cannot leave Empty Places", Toast.LENGTH_SHORT).show();
                }
            }
        });
       Log.d("Testing3","Reached Here");
        if(insertData)
            Toast.makeText(this, "Insertion of New Record Successful!!", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(this, "Insertion Failed!!", Toast.LENGTH_SHORT).show();
        }//on create
    public void deleteRecords(int delete_id){
        Intent intent = new Intent(StudentAdmission.this,ViewStudentList.class);
        startActivity(intent);
    }

}