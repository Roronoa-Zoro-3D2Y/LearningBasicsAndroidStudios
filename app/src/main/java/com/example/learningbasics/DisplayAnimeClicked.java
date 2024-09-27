package com.example.learningbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learningbasics.R;

public class DisplayAnimeClicked extends AppCompatActivity {
    TextView anime_title,anime_mc_name;
    Button Prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_anime_clicked);

        anime_title = findViewById(R.id.animeTitle);
        anime_mc_name = findViewById(R.id.animeMC);
        Prev = findViewById(R.id.go_to_prev);

        Intent intent = getIntent();
        anime_title.setText(intent.getStringExtra("title"));
        anime_mc_name.setText(intent.getStringExtra("mc_name"));

        Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DisplayAnimeClicked.this,MainActivity2.class);
                startActivity(intent1);
            }
        });
    }


}