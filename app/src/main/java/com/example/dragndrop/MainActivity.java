package com.example.dragndrop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learningbasics.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView dragImage,dropImage1A,dropImage1B,dropImage1C;
    ImageView dropImage2A,dropImage2B,dropImage2C;

    TextView text_1,text_2,text_3,text_4;

    String msg = "TESTING";
    float drgImgX,drgImgY,dx,dy;

    int flag =0,dragImgColor;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        text_1 = findViewById(R.id.txt_1);
        dragImage = findViewById(R.id.dragImage);
        text_2 = findViewById(R.id.txt_2);
        text_3 = findViewById(R.id.txt_3);

        dropImage1A = findViewById(R.id.dropImage1_a);
        dropImage1B = findViewById(R.id.dropImage1_b);
        dropImage1C = findViewById(R.id.dropImage1_c);

        dropImage2A = findViewById(R.id.dropImage2_a);
        dropImage2B = findViewById(R.id.dropImage2_b);
        dropImage2C = findViewById(R.id.dropImage2_c);
//        text_4 = findViewById(R.id.txt_4);


        /*OnLongClickListener longClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder mydragShadowBuilder = new View.DragShadowBuilder(dragImage);

                view.startDragAndDrop(data,mydragShadowBuilder,dragImage,0);
                return true;
            }
        };

        OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder dragImageShadow = new View.DragShadowBuilder(view);

                view.startDragAndDrop(data,dragImageShadow,view,0);

            }
        };*/

        dropImage1A.setTag("A");
        dropImage2A.setTag("B");

        Random rand = new Random();
        dragImgColor = rand.nextInt(2);
        setDragImgColor(dragImgColor);

        dragImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                    ClipData data = ClipData.newPlainText("","");
                    View.DragShadowBuilder mydragShadowBuilder = new View.DragShadowBuilder(dragImage);
                    view.startDragAndDrop(data,mydragShadowBuilder,dragImage,0);
                    dragImage.setVisibility(View.INVISIBLE);

                    dragImage.setTag("1");
                return true;
            }
        });
//        text_1.setOnLongClickListener(longClickListener);
        //text_2.setOnLongClickListener(longClickListener);
        //text_3.setOnLongClickListener(longClickListener);
        ///dragImage.setOnLongClickListener(longClickListener);
//        dragImage.setOnClickListener(clickListener);


        View.OnDragListener dragListener = new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {

                int draggy = dragEvent.getAction();
                final  ImageView dragImgLoc = (ImageView) dragEvent.getLocalState();
                switch (draggy){
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DROP:
                        if(dragImgLoc.getTag().equals("1") && view.getTag().equals("A") && dragImgColor==0){
                            flag = 1;
//                            Toast.makeText(MainActivity.this, "Dropped", Toast.LENGTH_SHORT).show();
                                dropImage1A.setImageResource(R.drawable.sa_8_a);
                                ImageViewCompat.setImageTintList(dropImage1A, ColorStateList.valueOf(getResources().getColor(R.color.red_btn,null)));
                            }
                        if(dragImgLoc.getTag().equals("1") && view.getTag().equals("B")&& dragImgColor==1){
                            flag = 1;
                                dropImage2A.setImageResource(R.drawable.sa_8_a);
                                ImageViewCompat.setImageTintList(dropImage2A, ColorStateList.valueOf(getResources().getColor(R.color.red_btn,null)));
                            }
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                      //  dragImage.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        if(flag == 0)
                            dragImage.setVisibility(View.VISIBLE);
                        Animation move = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move_right);
                        dropImage1A.startAnimation(move);
                        dropImage1A.setVisibility(View.INVISIBLE);
                        break;
                }

                return true;
            }
        };

//        text_4.setOnDragListener(dragListener);
        dropImage1A.setOnDragListener(dragListener);
        dropImage2A.setOnDragListener(dragListener);
    }

    public void setDragImgColor(int i){
        if(i==0){
            ImageViewCompat.setImageTintList(dragImage,ColorStateList.valueOf(getColor(R.color.purple_200)));
        }
        else
            ImageViewCompat.setImageTintList(dragImage,ColorStateList.valueOf(getColor(R.color.green_btn)));

    }
}
