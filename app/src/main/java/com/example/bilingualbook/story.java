package com.example.bilingualbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class story extends AppCompatActivity {
    int position;
    ImageView img_show;
    TextView txt_title, txt_show;
    String [] title_list = new String[9];
    String [] story_list = new String[4];
    int [] image_list = new int[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        findViews();
        titleList();
        storyList();
        imageList();
        setting();
    }
    public void setting() {
//      Setting the title image and text of each story according to the position we received.
        position = getIntent().getIntExtra("pos", 0);
        txt_title.setText(title_list[position]);
        txt_show.setText(story_list[position]);
        if (image_list[position] == -1) {
            img_show.setVisibility(View.GONE);
        }else {
            img_show.setBackgroundResource(image_list[position]);
        }
    }
//    Creating this method to connect views to this activity.
    public void findViews(){
        txt_title = findViewById(R.id.txt_title);
        txt_show  = findViewById(R.id.txt_show);
        img_show  = findViewById(R.id.img_show);
    }
//        Creating a method to value the array of story title.
    public void titleList(){
//        Array quantization of story title.
        title_list[0] = getResources().getString(R.string.chart_1);
        title_list[1] = getResources().getString(R.string.chart_2);
        title_list[2] = getResources().getString(R.string.chart_3);
        title_list[3] = getResources().getString(R.string.chart_4);
        title_list[4] = getResources().getString(R.string.chart_4);
        title_list[5] = getResources().getString(R.string.chart_5);
        title_list[6] = getResources().getString(R.string.chart_6);
        title_list[7] = getResources().getString(R.string.chart_7);
        title_list[8] = getResources().getString(R.string.chart_8);
     }
//      Creating a method to value the array of story list.
    public void storyList(){
//        Array quantization of story list.
        story_list[0] = getResources().getString(R.string.story1);
        story_list[1] = getResources().getString(R.string.story2_duckling);
        story_list[2] = getResources().getString(R.string.story3_Newton);
        story_list[3] = getResources().getString(R.string.story4_Harry);
    }
//    Creating a method to value the array of stories images.
    public void imageList(){
        image_list[0] = -1;
        image_list[1] = R.drawable.duckling;
        image_list[2] = R.drawable.newton;
        image_list[3] = R.drawable.harry;

    }
}