package com.example.learningbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class ImageSlideShow extends AppCompatActivity implements View.OnClickListener {
    ViewFlipper viewFlipper;
    Button prev_btn,next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slide_show);


        viewFlipper = findViewById(R.id.viewFlipper);
        prev_btn = findViewById(R.id.prev);
        next_btn = findViewById(R.id.next);

        prev_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == next_btn){
            viewFlipper.showNext();
        }
        else if(view == prev_btn)
            viewFlipper.showPrevious();
    }
}