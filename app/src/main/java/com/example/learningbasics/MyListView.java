package com.example.learningbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyListView extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.theList);

        ArrayList<String> ToDo = new ArrayList<>();
        ToDo.add("Laundry");
        ToDo.add("Cleaning");
        ToDo.add("Dusting");
        ToDo.add("Gardening");
        ToDo.add("Tutoring");

       // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ToDo);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.iteam_view, ToDo);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text ="Item"+i+" "+((TextView)view).getText().toString();
                Toast.makeText(MyListView.this,text, Toast.LENGTH_SHORT).show();
            }
        });
    }

}