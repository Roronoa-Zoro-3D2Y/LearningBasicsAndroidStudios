package com.example.learningbasics;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.example.learningbasics.model.Student;

import java.util.ArrayList;

public class ThreeColumnList_Adapter extends ArrayAdapter<Student> implements ListAdapter{
    private final LayoutInflater inflater;
    private final ArrayList<Student> students;
    private final int resourceId;
    AppCompatButton actions_btn;
    ViewStudentList viewStudentList;

    ListView listView;


    public ThreeColumnList_Adapter(Context context,int rid,ArrayList<Student> studentArrayList){
        super(context,rid,studentArrayList);
        this.students=studentArrayList;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        resourceId=rid;

    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @SuppressLint("ViewHolder")
    public View getView(int pos, View convertView, ViewGroup parents){

        Log.d("Testing6", "Inside three column adapter");

       convertView = inflater.inflate(resourceId,null);

        Student student = students.get(pos);

        if(student != null){

            Log.d("Testing7", "Inside three column adapter getView");

            listView = (ListView) convertView.findViewById(R.id.stu_listview);
            TextView stu_roll = (TextView) convertView.findViewById(R.id.stu_id_list);
            TextView stu_name = (TextView) convertView.findViewById(R.id.stu_name_list);
            TextView stu_dob = (TextView) convertView.findViewById(R.id.stu_dob_list);
//            AppCompatButton more_actions_btn = (AppCompatButton) convertView.findViewById(R.id.more_Actions);

            if(stu_roll != null)
                stu_roll.setText(""+student.getStRoll());
            if(stu_name != null) {
                stu_name.setText(""+student.getStName());
            }
            if(stu_dob != null) {
                stu_dob.setText(""+student.getDOB());
            }

            convertView.setTag(student);


/*            stu_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });*/
/*            more_actions_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "More Actions Button", Toast.LENGTH_SHORT).show();
                    viewStudentList.add_btn_activity();

                }
            });*/
        }
        return convertView;
    }


}
