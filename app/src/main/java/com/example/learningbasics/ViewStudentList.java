package com.example.learningbasics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    AppCompatButton delete_Btn,add_btn,more_actions_btn;

    private  LayoutInflater inflater;

    Dialog dialog;

    AlertDialog.Builder delete_confirm;
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


//        Intent intent = new Intent(ViewStudentList.this,ThreeColumnList_Adapter.class);
//        startActivity(intent);



        // ITEM CLICK LISTENER HERE!!!!
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Student student = studentArrayList.get(i);
                Toast.makeText(ViewStudentList.this, " name "+student.getStName(), Toast.LENGTH_SHORT).show();

                // On Clicking a Student we'll get an Alert!!
                delete_confirm = new AlertDialog.Builder(ViewStudentList.this);
                delete_confirm.setTitle("Alert!!")
                        .setMessage("Are you sure you want to delete "+student.getStName()+"'s record??")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                school_1.deleteById(student.getStRoll());
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .show();


           /*     //Here we are showing what we can do with the delete button and add button
                delete_Btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
*/
         /*       add_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ViewStudentList.this,StudentAdmission.class);
                        startActivity(intent);
                        finish();
                    }
                });
*//*
                ActionsDialog actionsDialog = new ActionsDialog(ViewStudentList.this,school_1,i);
                actionsDialog.setCancelable(false);
                actionsDialog.show();
*//*
                                Intent intent = new Intent(ViewStudentList.this,ActionsDialog.class);
                intent.putExtra("Student_delete",i);
                startActivity(intent);*/

                // Calling Actions Dialog Box

/*
                dialog = new Dialog(ViewStudentList.this);
                dialog.setContentView(R.layout.activity_actions_dialouge);
                dialog.setCancelable(false);
                dialog.show();

                                delete_Btn = dialog.findViewById(R.id.delete_btn);
                add_btn = dialog.findViewById(R.id.add_btn);*/

            }
        });//item click listener ends

/*
        inflater=(LayoutInflater) ViewStudentList.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_view_student_list,null);
        more_actions_btn = view.findViewById(R.id.more_Actions);

        more_actions_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewStudentList.this, "Oi Oi Oi", Toast.LENGTH_SHORT).show();
            }
        });
*/

    }// on create ends

/*
    public void removeStudentOnClick(View view){
        Student student1 = (Student)view.getTag();
        Toast.makeText(ViewStudentList.this, "Removing the Student "+student1.getStName(), Toast.LENGTH_SHORT).show();
    }


    public void add_btn_activity(){
        Intent intent = new Intent(ViewStudentList.this,StudentAdmission.class);
        startActivity(intent);
        finish();
    }
*/

/*    public void deleteRecords(int delete_id){
        Student student1 = studentArrayList.get(delete_id);
        Toast.makeText(this, "Are you sure you want to delete "+student1.getStName()+"'s Records", Toast.LENGTH_SHORT).show();
    }*/

}